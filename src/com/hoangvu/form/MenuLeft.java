
package com.hoangvu.form;

import com.hoangvu.swing.ScrollBar;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Admin
 */
public class MenuLeft extends javax.swing.JPanel {

    /**
     * Creates new form MenuLeft
     */
    public MenuLeft() {
        initComponents();
        init();

    }
    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        this.menuList.setLayout(new MigLayout("fillx","0[]0","0[]0"));
        sp.getVerticalScrollBar().setUnitIncrement(20);
        showMessage(100);
    }
    public void showMessage(int num){
        this.menuList.removeAll();
        // test data
        for(int i = 0; i < num; i++){
            this.menuList.add(new ItemObject("User "+ (i+1)),"wrap");
        }
    }

    public void showGroup(int num){
        this.menuList.removeAll();
        // test data
        for(int i = 0; i < num; i++){
            this.menuList.add(new ItemObject("User "+ (i+1)),"wrap");
        }
        refreshMenuList();
    }

    public void refreshMenuList(){
        menuList.repaint();
        menuList.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        this.menuList = new javax.swing.JLayeredPane();

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 16)); // NOI18N
        jLabel1.setText("Chats");

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        this.menuList.setBackground(new java.awt.Color(255, 255, 255));
        this.menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(this.menuList);
        this.menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        sp.setViewportView(this.menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
