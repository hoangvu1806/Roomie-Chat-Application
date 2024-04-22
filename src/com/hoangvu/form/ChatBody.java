package com.hoangvu.form;

import com.hoangvu.swing.ScrollBar;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ChatBody extends javax.swing.JPanel {
    public ChatBody() {
        initComponents();
        init();
    }

    private void init(){
        body.setLayout(new MigLayout("fillx","5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(new Color(255,255,255));
        addItemRight("qưueyhsbasadnjas","Vũ Hoàng");
        addDate("-- 04/12/2024 --");
        addItemLeft("adwaiwbawjwna","Thanh Trà");
        addItemRight("qưueyhsbasadnjas","Vũ Hoàng");
        addItemRight("qưueyhsbasadnjas","Vũ Hoàng");
        addDate("Today");
        addItemLeft("adwaiwbawjwna","Thanh Trà");
        addItemLeft("  ","Thanh Trà");
        addDate("-- 04/12/2024 --");
        addItemLeft("adwaiwbawdaibbbbbbbbbbbbbbbbbbbbbbbwydgaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajwna","Thanh Trà");
    }

    public void addItemLeft(String text,String user){
        ChatLeftInfo itemLeft = new ChatLeftInfo();
        itemLeft.setText(text);
        itemLeft.setUserProfile(user);
        body.add(itemLeft,"wrap, w ::75%");
        body.repaint();
        body.revalidate();
    }
    public void addItemRight(String text, String user){
        ChatRightInfo itemRight = new ChatRightInfo();
        itemRight.setText(text);
        itemRight.setUserProfile(user);
        body.add(itemRight,"wrap, al right,w ::75%");
        body.repaint();
        body.revalidate();
    }

    public void addDate(String date){
        ChatDate dateItem = new ChatDate();
        dateItem.setDate(date);
        body.add(dateItem,"wrap, al center");
        body.repaint();
        body.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
