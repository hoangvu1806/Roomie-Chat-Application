
package com.hoangvu.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelSendMessage {

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String text) {
        this.message = text;
    }
    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public ModelSendMessage(int fromUserID, int toUserID, String text) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.message = text;
    }
    public ModelSendMessage(int fromUserID, int toUserID, Object image) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.image = image;
    }

    public ModelSendMessage() {
    }


    private Object image;
    private Object file;
    private int fromUserID;
    private int toUserID;
    private String message;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("toUserID", toUserID);
            json.put("message", message);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
