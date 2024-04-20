
package com.hoangvu.form;
import net.miginfocom.swing.MigLayout;

public class Home extends javax.swing.JLayeredPane {

    public Home() {
        initComponents();
        init();
    }
    private void init(){
        this.menuLeft = new MenuLeft();
        this.menuRight = new MenuRight();
        this.toolBar = new ToolBar(this.menuLeft);
        this.chat = new Chat();
        setLayout(new MigLayout("fillx, filly", "0[44!]0[200!]5[fill, 100%]5[200!]5", "0[fill]0"));
        this.add(this.toolBar);
        this.add(this.menuLeft);
        this.add(this.chat);
        this.add(this.menuRight);
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
            .addGap(0, 512, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private Chat chat;
    private MenuLeft menuLeft;
    private ToolBar toolBar;
    private MenuRight menuRight;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
