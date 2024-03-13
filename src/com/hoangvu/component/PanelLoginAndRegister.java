package com.hoangvu.component;

import com.hoangvu.swing.Button;
import com.hoangvu.swing.MyPasswordField;
import com.hoangvu.swing.MyTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

//Do Hoang Vu 23dai
//12/3/2024
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);

    }
    private void initRegister(){
        register.setLayout(new MigLayout("wrap","push[center]push","push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif",1,30));
        label.setForeground(new Color(201,1,148));
        register.add(label);

        MyTextField txtUser = new MyTextField();// init textbox user name
        txtUser.setColor(new Color(255, 234, 249, 255));
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/user.png")));
        txtUser.setForeground(new Color(218, 56, 155, 255));
        txtUser.setHint("User name");
        register.add(txtUser,"w 60%");

        MyTextField txtEmail = new MyTextField();// init textbox Email
        txtEmail.setColor(new Color(255, 234, 249, 255));
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/mail.png")));
        txtEmail.setForeground(new Color(218, 56, 155, 255));
        txtEmail.setHint("Email");
        register.add(txtEmail,"w 60%");

        MyPasswordField txtPass = new MyPasswordField();// init password textbox
        txtPass.setColor(new Color(255, 234, 249, 255));
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/pass.png")));
        txtPass.setForeground(new Color(218, 56, 155, 255));
        txtPass.setHint("Password");
        register.add(txtPass,"w 60%");

        Button cmd = new Button(); // init sign up button
        cmd.setBackground(new Color(201,1,148));
        cmd.setForeground(new Color(250,250,250));
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");
    }
    private void initLogin(){
        login.setLayout(new MigLayout("wrap","push[center]push","push[]25[]10[]10[]10[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sanssarif",1,30));
        label.setForeground(new Color(12,201,226));
        login.add(label);

        MyTextField txtEmail = new MyTextField();// init textbox Email
        txtEmail.setColor(new Color(221, 249, 250, 255));
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/mail.png")));
        txtEmail.setForeground(new Color(13, 143, 164));
        txtEmail.setHint("Email");
        login.add(txtEmail,"w 60%");

        MyPasswordField txtPass = new MyPasswordField();// init password textbox
        txtPass.setColor(new Color(221, 249, 250, 255));
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/pass.png")));
        txtPass.setForeground(new Color(13, 143, 164));
        txtPass.setHint("Password");
        login.add(txtPass,"w 60%");

        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100,100,100));
        cmdForget.setFont(new Font("sansserif",1,12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);

        Button cmd = new Button(); // init sign in button
//        cmd.setBackground(new Color(7,164,121));
        cmd.setBackground(new Color(12,201,226));//hoangvu
        cmd.setForeground(new Color(250,250,250));
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
    }

    public void showLogin(boolean show){
        if (show){
            register.setVisible(false);
            login.setVisible(true);
        }else{
            register.setVisible(true);
            login.setVisible(false);
        }
    }

    public void showRegister(boolean show){
        if (show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card2");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card3");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}