
package com.hoangvu.form;

import javax.swing.*;
import java.awt.Color;

public class ChatRightInfo extends javax.swing.JLayeredPane {

    public ChatRightInfo() {
        initComponents();
        txt.setBackground(new Color(160, 214, 248, 255));
        txt.setSelectionColor(new Color(166, 1, 80));
    }
    public void setUserProfile(String user){
        txt.setUserProfile(user);
    }

    public void showTime(Color color) {
        txt.showTime(color);
    }
    public void setImage(String [] image) {
        txt.setImage(false, image);
    }

    public void setImage(Icon... image) {
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

        txt = new com.hoangvu.form.ChatItem();

        txt.setBackground(new java.awt.Color(255, 255, 255));

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hoangvu.form.ChatItem txt;
    // End of variables declaration//GEN-END:variables
}
