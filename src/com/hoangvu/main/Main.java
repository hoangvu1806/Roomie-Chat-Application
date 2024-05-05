package com.hoangvu.main;

import com.hoangvu.component.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hoangvu.model.ModelLogin;
import com.hoangvu.model.ModelMessage;
import com.hoangvu.model.ModelUser;
import com.hoangvu.service.Service;
import com.hoangvu.service.ServiceSendMail;
import com.hoangvu.service.ServiceUser;

import io.socket.client.Ack;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import net.miginfocom.swing.MigLayout;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;

public class Main extends JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin = true;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    public Main() {
        initComponents();
        init();

    }

    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        ImageIcon icon = new ImageIcon("E:/Roomie Project/src/com/hoangvu/icon/logo.png");
        setIconImage(icon.getImage());
        Service.getInstance().connectToServer();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    register();
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    login();
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation

        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        loginAndRegister.showRegister(!isLogin);
        cover.login(isLogin);
        cover.addEvent(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent ae) {
            if (!animator.isRunning()) {
                animator.start();
            }
        }
        });
    }

    private void sendMail(ModelUser user) {
        verifyCode = new PanelVerifyCode(user.getUserID());
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(verifyCode, "pos 0 0 100% 100%");
        new Thread(new Runnable() {
            @Override
            public void run() {
                loading.setVisible(true);

                ModelMessage ms = new ServiceSendMail().sendMain(user.getEmail(), user.getUserName(),user.getVerifyCode());

                if (ms.isSuccess()) {
                    loading.setVisible(false);
                    verifyCode.setVisible(true);
                } else {
                    loading.setVisible(false);
                    showMessage(Notification.MessageType.ERROR, ms.getMessage());
                }
            }
        }).start();
        verifyCode.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    JSONObject data = new JSONObject();
                    data.put("userID", verifyCode.getUserID());
                    data.put("verifyCode", verifyCode.getInputCode());
                    System.out.println(data);
                    Service.getInstance().getClient().emit("authentication", data.toString(),new Ack(){
                        @Override
                        public void call(Object... args) {
                            if (args[0].equals("success")) {
                                verifyCode.setVisible(false);
                                showMessage(Notification.MessageType.SUCCESS, "Register Success!");
                            } else {
                                showMessage(Notification.MessageType.ERROR, "Verify code incorrect");
                            }
                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void register() throws JSONException {
        ModelUser user = loginAndRegister.getUser();
        if (!user.isValidUsername()) {
            showMessage(Notification.MessageType.ERROR, "The username is invalid");
        } else if (!user.isValidEmail()){
            showMessage(Notification.MessageType.ERROR, "The email is invalid");
        } else if (!user.isValidPassword()) {
            showMessage(Notification.MessageType.ERROR, "Passwords need uppercase, lowercase, and digits!");
        } else {
            Service.getInstance().getClient().emit("register", user.toJsonObject(), new Ack() {
                @Override
                public void call(Object... objects) {
                    if (objects.length > 0) {
                        String objectJs = (String) objects[0];
                        String message = (String) objects[1];
                        System.out.println(message);
                        System.out.println("Server response: " + objectJs);
                        try {
                            if (message.equals("duplicate email")) {
                                showMessage(Notification.MessageType.ERROR, "Email already exist");
                            } else if (message.equals("duplicate user")) {
                                showMessage(Notification.MessageType.ERROR, "User name already exist");
                            } else if (message.equals("success")) {
                                ModelUser user = new ModelUser(objectJs);
                                sendMail(user);
                                System.out.println(user.showUser());
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                            showMessage(Notification.MessageType.ERROR,"Error Register!");
                        }
                    } else {
                        System.out.println("No response from server");
                    }
                }
            });
        }
    }

    private void login() throws JSONException {
        ModelLogin data = loginAndRegister.getDataLogin();
        System.out.println(data.toJsonObject());
        Service.getInstance().getClient().emit("login", data.toJsonObject(), new Ack() {
            @Override
            public void call(Object... objects) {
                if (objects.length > 0) {
                    String objectJs = (String) objects[0];
                    String message = (String) objects[1];
                    System.out.println(message);
                    System.out.println("Server response: " + objectJs);
                    try {
                        switch (message) {
                            case "valid account":
                                ModelUser user = new ModelUser(objectJs);
                                System.out.println("Signed in successfully!");
                                System.out.println(user.showUser());
                                dispose();
                                ArrayList<ModelUser> listUsers= new ArrayList<>();
                                Service.getInstance().getClient().emit("list-Users", new Ack() {
                                    @Override
                                    public void call(Object... objects) {

                                    }
                                });
                                Client.main(user,listUsers);
                                break;
                            case "server is at fault":
                                showMessage(Notification.MessageType.ERROR, "Server is at fault");
                                break;
                            case "invalid account":
                                showMessage(Notification.MessageType.ERROR, "Email or password incorrect");
                                break;
                            default:
                                showMessage(Notification.MessageType.SUCCESS, "Login successful");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("No response from server");
                }
            }
        });
    }

    private void sendRequestListUser(){
        Service.getInstance().getClient().emit("list-user", new Ack() {
            @Override
            public void call(Object... objects) {
                if (objects.length > 0) {
                    String objectJs = (String) objects[0];
                    String message = (String) objects[1];
                    System.out.println(message);
                    System.out.println("Server response: " + objectJs);
                } else {
                    System.out.println("No response from server");
                }
            }
        });
    }

    private void showMessage(Notification.MessageType messageType, String message) {
        Notification ms = new Notification();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTarget() {
            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0);
                    bg.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                } else {
                    ms.setShow(true);
                }
            }
            @Override
            public void repeat() {
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new JLayeredPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new Color(255, 255, 255));
        bg.setOpaque(true);

        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 537, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bg, GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
