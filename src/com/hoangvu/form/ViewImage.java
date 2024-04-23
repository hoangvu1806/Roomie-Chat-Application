package com.hoangvu.form;

import com.hoangvu.event.PublicEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class ViewImage extends javax.swing.JComponent {

    public ViewImage() {
        initComponents();
    }

    private Icon image;

    public void viewImage(Icon image) {
        this.image = image;
        pic.setImage(image);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new com.hoangvu.swing.PictureBox();
        cmdSave = new javax.swing.JButton();

        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                picMousePressed(evt);
            }
        });

        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hoangvu/icon/download.png"))); // NOI18N
        cmdSave.setBorder(null);
        cmdSave.setBorderPainted(false);
        cmdSave.setContentAreaFilled(false);
        cmdSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });
        pic.add(cmdSave);
        cmdSave.setBounds(800, 550, 75, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void picMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            setVisible(false);
        }
    }//GEN-LAST:event_picMousePressed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
//        PublicEvent.getInstance().getEventImageView().saveImage(image);
        JFrame frame = new JFrame("Dialog Example");
        JOptionPane.showMessageDialog(frame, "Pay $ 10 to download photos");
    }//GEN-LAST:event_cmdSaveActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private com.hoangvu.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
