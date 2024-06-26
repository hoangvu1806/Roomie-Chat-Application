package com.hoangvu.form;

import com.hoangvu.model.GetTime;
import com.hoangvu.model.ImageHandler;
import com.hoangvu.model.ModelReceiveMessage;
import com.hoangvu.model.ModelSendMessage;
import com.hoangvu.swing.ScrollBar;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.Objects;

public class ChatBody extends javax.swing.JPanel {

    public ChatBody() {
        initComponents();
        init();
        showChat();
    }

    private void init() {
        body.setLayout(new MigLayout("fillx", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(new Color(255, 255, 255));
    }

    private void showChat() {
//        addItemRight("Hello, what up?");
//        addDate("-- 04/12/2024 --");
//        addItemLeft("adwaiwbawjwna","Thanh Trà");
//        String img[] = {"LRMj,K-:?G9G_JIon}WqD~ITRPs,", "LCGlO@00.R~o.9DOO[%L02?aJ7D*"};
//        addItemLeft("hello\nerererew\newewe", "Dara", img);
        addItemRight("hey!", new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/hoangvu/icon/logoAI.png"))));
//        addItemRight("qưueyhsbasadnjas");
//        addDate("Today");
//        addItemLeft("adwaiwbawjwna","Thanh Trà");
//        addItemLeft("  ","Thanh Trà",new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/hoangvu/icon/bb.png"))));
//        addItemLeft("\t\n\t\n  ","Thanh Trà");
//        addItemLeft("adwaiwbawdaibbbbbbbbbbbbbbbbbbbbbbbwydgaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajwna","Thanh Trà");
//        addItemFile("","Thanh Trà","game.exe","10 MB");
//        addItemFile("Tải về mà sài","Máy lạnh.exe","2 GB");
//        addItemFile(" ","gameduaxelan.exe","1.2 GB");
    }

    public void addItemLeft(String text, String user, Icon image) {
        ChatLeftInfo itemLeft = new ChatLeftInfo();
        itemLeft.setText(text);
        itemLeft.setImage(image);
        itemLeft.showTime(new Color(98, 0, 56));
        itemLeft.setUserProfile(user);
        body.add(itemLeft, "wrap, w ::75%");
        body.repaint();
        body.revalidate();
        scrollToBottom();
    }

    public void addItemRight(ModelSendMessage data) {
        ChatRight itemRight = new ChatRight();
        itemRight.setText(data.getMessage());
        itemRight.showTime(new Color(0, 79, 131, 255));
        body.add(itemRight, "wrap, al right,w ::75%");
        repaint();
        revalidate();
        scrollToBottom();
    }

    public void addItemLeft(ModelReceiveMessage data) {
        ChatLeft itemLeft = new ChatLeft();
        itemLeft.setText(data.getMessage());
        itemLeft.showTime(new Color(98, 0, 56));
        body.add(itemLeft, "wrap, w ::75%");
        repaint();
        revalidate();
        scrollToBottom();
    }

    public void addImageRight(ModelSendMessage data) throws IOException {
        Icon image = ImageHandler.decodeImage(data.getImage());
        ChatRight itemRight = new ChatRight();
        itemRight.setImage(image);
        itemRight.showTime(new Color(0, 79, 131, 255));
        body.add(itemRight, "wrap, al right,w ::75%");
        repaint();
        revalidate();
        scrollToBottom();
    }

    public void addImageLeft(ModelReceiveMessage data) throws IOException {
        ChatLeft itemLeft = new ChatLeft();
        Icon image = ImageHandler.decodeImage(data.getImage());
        itemLeft.setText(data.getMessage());
        itemLeft.setImage(image);
        itemLeft.showTime(new Color(98, 0, 56));
        body.add(itemLeft, "wrap, w ::75%");
        repaint();
        revalidate();
        scrollToBottom();
    }

    public void addItemRight(String text, Icon image) {
        ChatRightInfo itemRight = new ChatRightInfo();
        itemRight.setText(text);
        itemRight.setImage(image);
        itemRight.showTime(new Color(0, 79, 131, 255));
        body.add(itemRight, "wrap, al right,w ::75%");
        body.repaint();
        body.revalidate();
        scrollToBottom();
    }

    public void addItemFile(String text, String user, String fileName, String fileSize) {
        ChatLeftInfo itemLeft = new ChatLeftInfo();
        itemLeft.setText(text);
        itemLeft.setFile(fileName, fileSize);
        itemLeft.showTime(new Color(98, 0, 56));
        itemLeft.setUserProfile(user);
        body.add(itemLeft, "wrap, w 100::75%");
        body.repaint();
        body.revalidate();
        scrollToBottom();
    }

    public void addItemFile(String text, String fileName, String fileSize) {
        ChatRightInfo itemRight = new ChatRightInfo();
        itemRight.setText(text);
        itemRight.setFile(fileName, fileSize);
        itemRight.showTime(new Color(0, 79, 131, 255));
        body.add(itemRight, "wrap, al right,w ::75%");
        body.repaint();
        body.revalidate();
        scrollToBottom();
    }

    public void addDate(String date) {
        ChatDate dateItem = new ChatDate();
        dateItem.setDate(date);
        body.add(dateItem, "wrap, al center");
        body.repaint();
        body.revalidate();
        scrollToBottom();
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

    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }

    public void clearChat() {
        body.removeAll();
        repaint();
        revalidate();
        scrollToBottom();
        addDate("----------------------- " + GetTime.getCurrentTimeDay() + " -----------------------");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
