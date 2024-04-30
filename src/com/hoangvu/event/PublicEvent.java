
package com.hoangvu.event;

/**
 *
 * @author Admin
 */
public class PublicEvent {
    
    private static PublicEvent instance;
    public EventLogin eventLogin;
    private EventImageView eventImageView;
    private EventChat eventChat;

    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() {

    }

    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }
    public void addEventChat(EventChat event) {
        this.eventChat = event;
    }

    public EventImageView getEventImageView() {
        return this.eventImageView;
    }
    public EventChat getEventChat(){
        return this.eventChat;
    }

    public EventLogin getEventLogin() {
        return eventLogin;
    }
}
