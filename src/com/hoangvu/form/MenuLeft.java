
package com.hoangvu.form;

import com.hoangvu.event.EventMenuLeft;
import com.hoangvu.event.PublicEvent;
import com.hoangvu.model.ModelUser;
import com.hoangvu.swing.ScrollBar;
import net.miginfocom.swing.MigLayout;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MenuLeft extends javax.swing.JPanel {

    /**
     * Creates new form MenuLeft
     */
    public MenuLeft(ArrayList<ModelUser> listUsers) {
        initComponents();
        init(listUsers);
    }

    private void init(ArrayList<ModelUser> listUsers){
        sp.setVerticalScrollBar(new ScrollBar());
        this.menuList.setLayout(new MigLayout("fillx","0[]0","0[]0"));
        sp.getVerticalScrollBar().setUnitIncrement(20);
        showUser(listUsers);
    }
    public void showMessage(int num){
        this.menuList.removeAll();
        // test data
        for(int i = 0; i < num; i++){
            this.menuList.add(new ItemObject(null),"wrap");
        }
    }

    public void showGroup(int num){
        this.menuList.removeAll();
        // test data
        for(int i = 0; i < num; i++){
            this.menuList.add(new ItemObject(null),"wrap");
        }
        refreshMenuList();
    }
    public void showUser(ArrayList<ModelUser> listUsers){
        this.menuList.removeAll();
        // test data
        for(ModelUser user : listUsers){
            this.menuList.add(new ItemObject(user),"wrap");
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
        menuList = new javax.swing.JLayeredPane();

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 16)); // NOI18N
        jLabel1.setText("Chats");

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(242, 242, 242));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

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
    javax.swing.JLayeredPane menuList;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
