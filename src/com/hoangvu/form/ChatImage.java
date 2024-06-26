
package com.hoangvu.form;

import com.hoangvu.event.PublicEvent;
import com.hoangvu.swing.PictureBox;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class ChatImage extends javax.swing.JLayeredPane {

    public ChatImage(boolean right) {
        initComponents();
        setLayout(new MigLayout("", "0[" + (right ? "right" : "left") + "]0", "3[]3"));
    }

    public void addImage(Icon image) {
        PictureBox pic = new PictureBox();
        pic.setPreferredSize(getAutoSize(image, 200, 200));
        pic.setImage(image);
        addEvent(pic, image);
        add(pic, "wrap");
    }
    public void addImage(String[] images) {
        for (String  image : images) {
            ImageItem pic = new ImageItem();
//            pic.setPreferredSize(getAutoSize(image, 200, 200));
            pic.setImage(image);
//            addEvent(pic, image);
            add(pic, "wrap");
        }
    }
    private void addEvent(Component com, Icon image) {
        com.setCursor(new Cursor(Cursor.HAND_CURSOR));
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    PublicEvent.getInstance().getEventImageView().viewImage(image);
                }
            }
        });
    }

    private Dimension getAutoSize(Icon image, int w, int h) {
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.min(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        return new Dimension(width, height);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
