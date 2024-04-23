
package com.hoangvu.component;
import java.awt.*;
import javax.swing.ImageIcon;

public class Notification extends javax.swing.JPanel {

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;

    public Notification() {
        initComponents();
        setOpaque(false);
        setVisible(true);

    }

    public void showMessage(MessageType messageType, String message) {
        this.messageType = messageType;
        lbMessage.setText(message);
        if (messageType == MessageType.SUCCESS) {
            lbMessage.setIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/success.png")));
        } else {
            lbMessage.setIcon(new ImageIcon(getClass().getResource("/com/hoangvu/icon/error.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMessage = new javax.swing.JLabel();

        lbMessage.setBackground(new java.awt.Color(255, 255, 255));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("lbMessage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        lbMessage.getAccessibleContext().setAccessibleName("Message");
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        GradientPaint gra1 = new GradientPaint(0, 0, new Color(43, 228, 255), 0, getHeight(), new Color(1, 154, 201));
        GradientPaint gra2 = new GradientPaint(0, 0, new Color(255, 65, 175), 0, getHeight(), new Color(168, 13, 96));
        if (messageType == MessageType.SUCCESS) {
            g2.setPaint(gra1);
        } else {
            g2.setPaint(gra2);
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));

        g2.fillRoundRect(0, 0, getWidth(), getHeight(),20,20);
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(new Color(245, 245, 245));
        super.paintComponent(grphcs);
    }

    public static enum MessageType {
        SUCCESS, ERROR
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbMessage;
    // End of variables declaration//GEN-END:variables
}
