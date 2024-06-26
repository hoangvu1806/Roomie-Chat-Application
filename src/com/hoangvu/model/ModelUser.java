package com.hoangvu.model;

import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public boolean isActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(boolean activateStatus) {
        this.activateStatus = activateStatus;
    }

    public boolean activateStatus;



    public ModelUser(int userID, String userName, String email, String password, String verifyCode) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public ModelUser(String jsonString) {
        try {
            JSONObject js = new JSONObject(jsonString);
            userID = js.getInt("userID");
            userName = js.getString("userName");
            email = js.getString("email");
            password = js.getString("password");
            if (js.has("verifyCode")) {
                verifyCode = js.getString("verifyCode");
            } else {
                verifyCode = null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ModelUser(Object json) throws JSONException {
        if (json instanceof JSONObject) {
            JSONObject js = (JSONObject) json;
            try {
                userID = js.getInt("userID");
                userName = js.getString("userName");
                email = js.getString("email");
                password = js.getString("password");
            } catch (JSONException je) {
                System.err.println(je);
            }
        } else {
            throw new JSONException("Invalid JSON object");
        }
    }


    public ModelUser() {
    }
    public boolean isValidEmail() {
        if (email == null || email.length() < 5) {
            return false;
        }
        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex == 0 || atIndex == email.length() - 1) {
            return false;
        }
        int dotIndex = email.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex < atIndex + 2 || dotIndex == email.length() - 1) {
            return false;
        }
        for (int i = dotIndex + 1; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidUsername() {
        if (userName.length() < 6 || userName.length() > 40) {
            return false;
        }
        for (char ch : userName.toCharArray()) {
            if (ch == '@' || ch == '%' || ch == '^' || ch == '$' || ch == '#' || ch == '*' || ch == '!' || ch == ')' || ch == '(' || ch == '+' || ch == '=') {
                return false;
            }
        }
        return true;
    }
    public boolean isValidPassword() {
        if (password.length() < 8) {
            return false;
        }
        int countLowercase = 0;
        int countUppercase = 0;
        int countDigit = 0;
        int countSpecial = 0;
        for (char c : password.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                countLowercase++;
            }
            if (c >= 'A' && c <= 'Z') {
                countUppercase++;
            }
            if (c >= '0' && c <= '9') {
                countDigit++;
            }
        }
        return countLowercase >= 1 && countUppercase >= 1 && countDigit >= 1;
    }

    public JSONObject toJsonObject() throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userID", userID);
            jsonObject.put("userName", userName);
            jsonObject.put("email", email);
            jsonObject.put("password", password);
            jsonObject.put("verifyCode", verifyCode);
            return jsonObject;
        } catch (JSONException je){
            System.out.println(je);
            return null;
        }
    }
    public String showUser(){
        return "User ID: " + userID + "\n" +
                "User Name: " + userName + "\n" +
                "Email: " + email + "\n" +
                "Password: " + password + "\n";
    }

    private int userID;
    private String userName;
    private String email;
    private String password;
    private String verifyCode;
    private String avatarImage;
}
