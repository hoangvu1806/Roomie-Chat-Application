
package com.hoangvu.form;
import com.hoangvu.model.ModelUser;
import net.miginfocom.swing.MigLayout;

import java.util.ArrayList;

public class Home extends javax.swing.JLayeredPane {

    public Home(ArrayList<ModelUser> listUsers,ModelUser user) {
        initComponents();
        init(listUsers,user);
    }
    private void init(ArrayList<ModelUser> listUsers, ModelUser user) {
        this.menuLeft = new MenuLeft(listUsers);
        this.menuRight = new MenuRight();
        this.chat = new Chat(user);
        this.toolBar = new LeftToolBar(this.menuLeft,listUsers);
        setLayout(new MigLayout("fillx, filly", "0[44!]2[200!]2[fill, 100%]2[0!]0", "0[fill]0"));
        this.add(this.toolBar);
        this.add(this.menuLeft);
        this.add(chat);
        this.add(this.menuRight);
        chat.setVisible(false);
    }
    public void setToUser(ModelUser toUser) {
        chat.setToUser(toUser);
        chat.setVisible(true);
    }
    public void updataUser(ModelUser user) {
        chat.updateUser(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private Chat chat;
    private MenuLeft menuLeft;
    private LeftToolBar toolBar;
    private MenuRight menuRight;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
