
package com.hoangvu.form;

import com.hoangvu.event.EventChat;
import com.hoangvu.event.PublicEvent;
import com.hoangvu.model.ModelReceiveMessage;
import com.hoangvu.model.ModelSendMessage;
import com.hoangvu.model.ModelUser;
import net.miginfocom.swing.MigLayout;

public class Chat extends javax.swing.JPanel {
    private ChatTittle chatTittle;
    private ChatBody chatBody;
    private ChatBottom chatBottom;
    private ModelUser user;
    private ModelUser toUser;

    public Chat(ModelUser user) {
        this.user = user;
        initComponents();
        init();
    }
    public void init() {
        setLayout(new MigLayout("fillx","0[fill]0","0[]0[100%, bottom]0[shrink 0]1"));
        chatTittle = new ChatTittle(user);
        chatBody = new ChatBody();
        chatBottom = new ChatBottom(user);
        PublicEvent.getInstance().addEventChat(new EventChat(){
            @Override
            public void sendMessage(ModelSendMessage data){
                chatBody.addItemRight(data);
            }

            @Override
            public void receiveMessage(ModelReceiveMessage data) {
                chatBody.addItemLeft(data);
            }
        });
        add(chatTittle,"wrap");
        add(chatBody,"wrap");
        add(chatBottom,"h ::50%");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setUser(ModelUser toUser) {
        chatTittle.setToUserName(toUser);
        chatBottom.setToUser(toUser);
    }
    public void updateUser(ModelUser toUser) {
        chatTittle.updataUser(toUser);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
