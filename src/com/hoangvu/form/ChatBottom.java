package com.hoangvu.form;


import com.hoangvu.event.EventChat;
import com.hoangvu.event.PublicEvent;
import com.hoangvu.swing.JIMSendTextPane;
import com.hoangvu.swing.ScrollBar;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class ChatBottom extends javax.swing.JPanel {
    public ChatBottom() {
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
        scroll.setVerticalScrollBar(sb);
        sb.setPreferredSize(new Dimension(2,10));
        add(sb);
        add(scroll,"w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly","0[]0","2[bottom]2"));
        JButton sendMsBt = new JButton();
        panel.setPreferredSize(new Dimension(30,28));
        panel.setBackground(Color.WHITE);
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
                if (!message.isEmpty()){
                    // add chat items
                    PublicEvent.getInstance().getEventChat().sendMessage(message);
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
