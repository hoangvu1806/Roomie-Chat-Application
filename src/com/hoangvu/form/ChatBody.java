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
        String img[] = {"LRMj,K-:?G9G_JIon}WqD~ITRPs,", "LCGlO@00.R~o.9DOO[%L02?aJ7D*"};
        addItemLeft("hello\nerererew\newewe", "Dara", img);
        addItemRight("qưueyhsbasadnjas","Vũ Hoàng",new ImageIcon(getClass().getResource("/com/hoangvu/icon/logoAI.png")));
        addItemRight("qưueyhsbasadnjas","Vũ Hoàng");
        addDate("Today");
        addItemLeft("adwaiwbawjwna","Thanh Trà");
        addItemLeft("  ","Thanh Trà",new ImageIcon(getClass().getResource("/com/hoangvu/icon/bb.png")));
        addDate("-- 04/12/2024 --");
        addItemLeft("\t\n\t\n  ","Thanh Trà");
        addItemLeft("adwaiwbawdaibbbbbbbbbbbbbbbbbbbbbbbwydgaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajwna","Thanh Trà");
    }

    public void addItemLeft(String text,String user, Icon... image){
        ChatLeftInfo itemLeft = new ChatLeftInfo();
        itemLeft.setText(text);
        itemLeft.setImage(image);
        itemLeft.setTime("10:00 PM",new Color(98, 0, 56) );
        itemLeft.setUserProfile(user);
        body.add(itemLeft,"wrap, w ::75%");
        body.repaint();
        body.revalidate();
    }

    public void addItemLeft(String text,String user, String [] image){
        ChatLeftInfo itemLeft = new ChatLeftInfo();
        itemLeft.setText(text);
        itemLeft.setImage(image);
        itemLeft.setTime("10:00 PM",new Color(98, 0, 56) );
        itemLeft.setUserProfile(user);
        body.add(itemLeft,"wrap, w ::75%");
        body.repaint();
        body.revalidate();
    }
    public void addItemRight(String text, String user, Icon ... image){
        ChatRightInfo itemRight = new ChatRightInfo();
        itemRight.setText(text);
        itemRight.setImage(image);
        itemRight.setTime("10:00 PM",new Color(0, 79, 131, 255));
        itemRight.setUserProfile(user);
        body.add(itemRight,"wrap, al right,w ::75%");
        body.repaint();
        body.revalidate();
    }
    public void addItemRight(String text, String user, String [] image){
        ChatRightInfo itemRight = new ChatRightInfo();
        itemRight.setText(text);
        itemRight.setImage(image);
        itemRight.setTime("10:00 PM",new Color(0, 79, 131, 255));
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
        sp.setName(""); // NOI18N

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
