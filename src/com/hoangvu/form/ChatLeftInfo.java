
package com.hoangvu.form;

import com.hoangvu.model.ModelUser;

import javax.swing.*;
import java.awt.Color;

public class ChatLeftInfo extends javax.swing.JLayeredPane {

    public ChatLeftInfo() {
        initComponents();
        txt.setBackground(new Color(203, 20, 122));
        txt.setForeground(new Color(255,255,255));
        txt.setSelectionColor(new Color(49, 170, 224));
    }
    public void setUserProfile(String user){
        txt.setUserProfile(user);
    }
    public void setImageProfile(Icon img){
        this.image.setImage(img);
    }
    public void showTime( Color color) {
        txt.showTime(color);
    }
    public void setImage(Icon image) {
        txt.setImage(false, image);
    }


    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    public void setText(String text) {
        if (text.trim().isEmpty()) {
            txt.hideText();
        } else {
            txt.setText(text);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        image = new com.hoangvu.swing.ImageAvatar();
        txt = new com.hoangvu.form.ChatItem();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        image.setBorderSize(0);
        image.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/hoangvu/icon/bb.png"))); // NOI18N
        image.setMaximumSize(new java.awt.Dimension(32, 32));
        image.setMinimumSize(new java.awt.Dimension(32, 32));

        jLayeredPane1.setLayer(image, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);

        txt.setBackground(new java.awt.Color(255, 255, 255));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hoangvu.swing.ImageAvatar image;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.hoangvu.form.ChatItem txt;
    // End of variables declaration//GEN-END:variables
}
