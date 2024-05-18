package com.hoangvu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//@JsonIgnoreProperties(ignoreUnknown = true)
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
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }


    public ModelReceiveMessage(int fromUserID, String message) {
        this.fromUserID = fromUserID;
        this.message = message;
    }

    public ModelReceiveMessage(int fromUserID, byte[] image) {
        this.fromUserID = fromUserID;
        this.message = "";
        this.image = image;
    }
    public ModelReceiveMessage(int fromUserID, String message, byte[] image) {
        this.fromUserID = fromUserID;
        this.message = message;
        this.image = image;
    }

    public ModelReceiveMessage(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            fromUserID = obj.getInt("fromUserID");
            message = obj.getString("message");
            // Chuyển đổi JSONArray thành mảng byte
            if (obj.has("image") && obj.get("image") instanceof JSONArray) {
                JSONArray jsonArray = obj.getJSONArray("image");
                image = new byte[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    image[i] = (byte) jsonArray.getInt(i);
                }
            } else {
                image = null; // hoặc xử lý phù hợp nếu không có dữ liệu hình ảnh
            }
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    private byte[] image;
    private Object file;
    private int fromUserID;
    private String message;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", fromUserID);
            json.put("message", message);
            json.put("image", image);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
