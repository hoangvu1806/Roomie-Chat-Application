
package com.hoangvu.event;

/**
 *
 * @author Admin
 */
public class PublicEvent {
    
    private static PublicEvent instance;



    private EventMain eventMain;
    public EventLogin eventLogin;
    private EventImageView eventImageView;
    private EventChat eventChat;
    private EventMenuLeft eventMenuLeft;

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
    public void addEventMenuLeft(EventMenuLeft event) {
        this.eventMenuLeft = event;
    }
    public EventChat getEventChat(){
        return this.eventChat;
    }

    public EventLogin getEventLogin() {
        return eventLogin;
    }
    public EventImageView getEventImageView() {
        return eventImageView;
    }
    public EventMenuLeft getEventMenuLeft() {
        return eventMenuLeft;
    }
    public EventMain getEventMain() {
        return eventMain;
    }
    public void addEventMain(EventMain event) {
        this.eventMain = event;
    }
}
