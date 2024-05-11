package com.hoangvu.form;


import com.hoangvu.connection.ServerConnection;
import com.hoangvu.event.EventChat;
import com.hoangvu.event.PublicEvent;
import com.hoangvu.model.ModelSendMessage;
import com.hoangvu.model.ModelUser;
import com.hoangvu.service.Service;
import com.hoangvu.swing.JIMSendTextPane;
import com.hoangvu.swing.ScrollBar;
import io.socket.client.Ack;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class ChatBottom extends javax.swing.JPanel {
    private ModelUser user;
    private ModelUser toUser;

    public ModelUser getUser() {
        return user;
    }
    public void setUser(ModelUser user) {
        this.user = user;
    }
    public void setToUser(ModelUser toUser) {
        this.toUser = toUser;
    }
    public ChatBottom(ModelUser user) {
        this.user = user;
        initComponents();
        init();
    }
    public void init(){
        setLayout(new MigLayout("fillx, filly","0[fill]0[]0[]2","2[fill]2"));
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane sendTextPane = new JIMSendTextPane();
        sendTextPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                refresh();
            }
        });
        sendTextPane.setHintText("Type a message...");
        scroll.setViewportView(sendTextPane);
        ScrollBar sb = new ScrollBar();
        sb.setPreferredSize(new Dimension(2,10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll,"w 100%");

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly","0[]0","2[bottom]2"));
        panel.setPreferredSize(new Dimension(30,28));
        panel.setBackground(Color.WHITE);

        JButton sendMsBt = new JButton();
        sendMsBt.setBorder(null);
        sendMsBt.setOpaque(false);
        sendMsBt.setContentAreaFilled(false);
        sendMsBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sendMsBt.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/hoangvu/icon/send.png"))));
        sendMsBt.setSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/hoangvu/icon/send_selected.png"))));
        sendMsBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = sendTextPane.getText().trim();
                ModelSendMessage data = new ModelSendMessage(user.getUserID(),toUser.getUserID(), message);
                if (!message.isEmpty()){
                    // add chat items
                    System.out.println("From "+ user.getUserID()+ "to "+ toUser.getUserID() +"\n");
                    send(data);
                    PublicEvent.getInstance().getEventChat().sendMessage(data);
                    sendTextPane.setText("");
                    sendTextPane.grabFocus();
                    refresh();
                } else {
                    sendTextPane.grabFocus();
                }
            }
        });
        panel.add(sendMsBt);
        add(panel);
    }
    private void send(ModelSendMessage data) {
        ServerConnection.getInstance().getClient().emit("send-message", data.toJsonObject());
    }
    private void refresh() {
        revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
