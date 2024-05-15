/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.hoangvu.component;


import com.hoangvu.connection.ServerConnection;
import com.hoangvu.event.PublicEvent;
import com.hoangvu.main.Client;
import com.hoangvu.model.ImageHandler;
import java.util.concurrent.ExecutionException;
import com.hoangvu.model.ModelSendMessage;
import com.hoangvu.model.ModelUser;
import com.hoangvu.swing.OptionButton;
import com.hoangvu.swing.ScrollBar;
import com.hoangvu.swing.WrapLayout;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PanelMore extends javax.swing.JPanel {
    private ArrayList<String> filePaths = new ArrayList<String>();
    private ModelUser user;

    public void setToUser(ModelUser toUser) {
        this.toUser = toUser;
    }

    private ModelUser toUser;
    public PanelMore(ModelUser user) {
        this.user = user;
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonFile());
        add(panelHeader, "w 100%, h 30!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));    //  use warp layout
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
        //  test color
        add(ch, "w 100%, h 100%");
    }
    private JButton getButtonFile() {
        OptionButton linkBt = new OptionButton();
        linkBt.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/com/hoangvu/icon/link.png"))));
        linkBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser ch = new JFileChooser();
                ch.setMultiSelectionEnabled(true);
                int result = ch.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = ch.getSelectedFiles();
                    for (File file : selectedFiles) {
                        String filePath = file.getAbsolutePath();
                        filePaths.add(filePath);
                    }
                    new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            handleSelectedFiles();
                            return null;
                        }
                        @Override
                        protected void done() {
                            try {
                                get();
                            } catch (InterruptedException | ExecutionException e) {
                                System.out.println("Error handling files: " + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }.execute();
                }
            }
        });
        return linkBt;
    }

    private void handleSelectedFiles() throws IOException {
        ModelSendMessage data;
        try {
            for (String filePath : filePaths) {
                if (filePath.toLowerCase().endsWith(".png") || filePath.toLowerCase().endsWith(".jpg")) {
                    data = new ModelSendMessage(user.getUserID(), toUser.getUserID(), ImageHandler.readImageFile(filePath));
                    ServerConnection.getInstance().getClient().emit("send-images", data.toJsonObject());
                    PublicEvent.getInstance().getEventChat().sendImage(data);
                    TimeUnit.MILLISECONDS.sleep(500);
                } else {
                    System.out.println("File ignored (unsupported format): " + filePath);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            data = null;
        }
    }

    public ArrayList<String> getSelectedFilePaths() {
        return filePaths;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private JPanel panelHeader;
    private JPanel panelDetail;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
