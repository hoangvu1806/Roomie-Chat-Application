
package com.hoangvu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONException;
import org.json.JSONObject;

//@JsonIgnoreProperties(ignoreUnknown = true)
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ModelSendMessage(int fromUserID, int toUserID, String message) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.message = message;
        this.image = null;
    }

    public ModelSendMessage(int fromUserID, int toUserID, byte[] image) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.image = image;
        this.message = "";
    }

    public ModelSendMessage(int fromUserID, int toUserID, byte[] image, String message) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.image = image;
        this.message = message;
    }

    public ModelSendMessage() {
    }


    private byte[] image;
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
            json.put("image", image);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
