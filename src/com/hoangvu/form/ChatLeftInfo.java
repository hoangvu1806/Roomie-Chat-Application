
package com.hoangvu.form;

import java.awt.Color;

public class ChatLeft extends javax.swing.JLayeredPane {

    public ChatLeft() {
        initComponents();
        txt.setBackground(new Color(203, 20, 122));
        txt.setForeground(new Color(255,255,255));
        txt.setSelectionColor(new Color(49, 170, 224));

    }

    public void setText(String text) {
        txt.setText(text);
        txt.setTime("11:05 PM", new Color(98, 0, 56));    //  Testing
        txt.sendSuccess();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.hoangvu.form.ChatItem();

        txt.setBackground(new java.awt.Color(255, 255, 255));

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
