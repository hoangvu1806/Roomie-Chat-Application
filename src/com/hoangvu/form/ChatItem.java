
package com.hoangvu.form;

import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

public class ChatItem extends javax.swing.JLayeredPane {

    private JLabel label;
    public ChatItem() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
    }
    public void setUserProfile(String user) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        layer.setBorder(new EmptyBorder(10, 10, 0, 10));
        JButton cmd = new JButton(user);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setFocusable(false);
        cmd.setForeground(new Color(255, 255, 255));
        cmd.setFont(new java.awt.Font("sansserif", 1, 13));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        layer.add(cmd);
        add(layer, 0);
    }

    public void setText(String text) {
        txt.setText(text);
    }

    public void setTime(String time, Color color) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        layer.setBorder(new EmptyBorder(0, 5, 10, 5));
        this.label = new JLabel(time);
        this.label.setForeground(color);
        this.label.setHorizontalTextPosition(JLabel.LEFT);
        layer.add(this.label);
        add(layer);
    }
    
    public void setImage(boolean right, Icon... image) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        ChatImage chatImage = new ChatImage(right);
        chatImage.addImage(image);
        layer.add(chatImage);
        add(layer);
    }
    public void setImage(boolean right, String [] image) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 0, 5));
        ChatImage chatImage = new ChatImage(right);
        chatImage.addImage(image);
        layer.add(chatImage);
        add(layer);
    }
    public void sendSuccess() {
        if (this.label != null) {
            this.label.setIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/tick.png")));
        }
    }

    public void seen() {
        if (this.label != null) {
            this.label.setIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/double_tick.png")));
        }
    }
    public void hideText() {
        txt.setVisible(false);
    }

    public void setSelectionColor(Color color) {
        this.txt.setSelectionColor(color);
    }
    public void setForeground(Color color) {
        this.txt.setForeground(color);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.hoangvu.swing.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txt.setSelectionColor(new java.awt.Color(59, 176, 229));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents

        @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hoangvu.swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
