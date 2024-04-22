
package com.hoangvu.main;

import com.hoangvu.model.ModelUser;
import com.hoangvu.swing.ComponentResizer;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Client extends javax.swing.JFrame {
    private final ModelUser user;
    /**
     * Creates new form Home
     */
    public Client(ModelUser user) {

        initComponents();
        init();
        this.user = user;
        setTitle("Roomie - " + user.getUserName());
        ImageIcon icon = new ImageIcon("E:/Roomie Project/src/com/hoangvu/icon/logoBase.png");
        setIconImage(icon.getImage());
        jLabel1.setText("Roomie - "+user.getUserName());

    }
    public void init(){
        ComponentResizer comr = new ComponentResizer();
        comr.registerComponent(this);
        comr.setMinimumSize(new Dimension(800,500));
        comr.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        comr.setSnapSize(new Dimension(10,10));
        GradientPaint gradient = new GradientPaint(0, 0, Color.RED, getWidth(), getHeight(), Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        border = new javax.swing.JPanel();
        home = new com.hoangvu.form.Home();
        tittlePanel = new javax.swing.JPanel();
        minimizeBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        closeBt = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 0));
        setUndecorated(true);

        border.setBackground(new java.awt.Color(255, 255, 255));

        tittlePanel.setBackground(new java.awt.Color(204, 204, 204));
        tittlePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tittlePanelMouseDragged(evt);
            }
        });
        tittlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tittlePanelMousePressed(evt);
            }
        });

        minimizeBt.setBackground(new java.awt.Color(102, 102, 102));
        minimizeBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minimizeBt.setText("__");
        minimizeBt.setBorder(null);
        minimizeBt.setBorderPainted(false);
        minimizeBt.setContentAreaFilled(false);
        minimizeBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeBtMouseExited(evt);
            }
        });
        minimizeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(tittlePanel);
        jLabel1.setText("Roomie");

        closeBt.setBackground(new java.awt.Color(102, 102, 102));
        closeBt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        closeBt.setText("×");
        closeBt.setBorder(null);
        closeBt.setBorderPainted(false);
        closeBt.setContentAreaFilled(false);
        closeBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBt.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        closeBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtMouseExited(evt);
            }
        });
        closeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tittlePanelLayout = new javax.swing.GroupLayout(tittlePanel);
        tittlePanel.setLayout(tittlePanelLayout);
        tittlePanelLayout.setHorizontalGroup(
            tittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittlePanelLayout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addGap(233, 233, 233)
                .addComponent(minimizeBt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tittlePanelLayout.setVerticalGroup(
            tittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(minimizeBt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(closeBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tittlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        borderLayout.setVerticalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderLayout.createSequentialGroup()
                .addComponent(tittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeBtActionPerformed

    private void closeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeBtActionPerformed



    private int pX;
    private int pY;
    private void closeBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtMouseEntered
        closeBt.setBackground(new Color(253, 71, 71));
        closeBt.setOpaque(true);
    }//GEN-LAST:event_closeBtMouseEntered
    private void closeBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtMouseExited
        closeBt.setBackground(this.tittlePanel.getBackground());
        closeBt.setOpaque(true);
    }//GEN-LAST:event_closeBtMouseExited

    private void minimizeBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtMouseEntered
        minimizeBt.setBackground(new Color(114, 114, 114));
        minimizeBt.setOpaque(true);
    }//GEN-LAST:event_minimizeBtMouseEntered

    private void minimizeBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtMouseExited
        minimizeBt.setBackground(this.tittlePanel.getBackground());
        minimizeBt.setOpaque(true);
    }//GEN-LAST:event_minimizeBtMouseExited

    private void tittlePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tittlePanelMousePressed
        this.pX = evt.getX();
        this.pY = evt.getY();
    }//GEN-LAST:event_tittlePanelMousePressed

    private void tittlePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tittlePanelMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - this.pX,
            this.getLocation().y + evt.getY() - this.pY);
    }//GEN-LAST:event_tittlePanelMouseDragged
                                

    /**
     * @param args the command line arguments
     */
    public static void main(ModelUser user) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel border;
    private javax.swing.JButton closeBt;
    private com.hoangvu.form.Home home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton minimizeBt;
    private javax.swing.JPanel tittlePanel;
    // End of variables declaration//GEN-END:variables
}
