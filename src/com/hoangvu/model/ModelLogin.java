
package com.hoangvu.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelLogin {
    public ModelLogin(){

    }
    public ModelLogin(String email, String password){
        this.email = email;
        this.password = password;
    }
    public JSONObject toJsonObject() throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
            jsonObject.put("password", password);
            return jsonObject;
        } catch (JSONException je){
            System.out.println(je);
            return null;
        }
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    private String email;
    private String password;
}
