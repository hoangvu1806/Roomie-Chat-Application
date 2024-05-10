package com.hoangvu.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelReceiveMessage {

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Object getImage() {
        return image;
    }
    public void setImage(Object image) {
        this.image = image;
    }


    public ModelReceiveMessage(int fromUserID, String message) {
        this.fromUserID = fromUserID;
        this.message = message;
    }
    public ModelReceiveMessage(int fromUserID, String message, Object image) {
        this.fromUserID = fromUserID;
        this.message = message;
        this.image = image;
    }

    public ModelReceiveMessage(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            fromUserID = obj.getInt("fromUserID");
            message = obj.getString("message");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    private Object image;
    private Object file;
    private int fromUserID;
    private String message;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("message", message);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
