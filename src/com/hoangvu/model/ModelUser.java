package com.hoangvu.model;

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

    public ModelUser() {
    }
    public  boolean isValidEmail() {
        if (email == null) {
            return false;
        }
        if (email.length() < 5) {
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
        for (int i = atIndex + 1; i < dotIndex; i++) {
            char ch = email.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != '-') {
                return false;
            }
        }
        char lastDomainChar = email.charAt(dotIndex + 1);
        if (!Character.isLetter(lastDomainChar)) {
            return false;
        }
        return true;
    }
    public boolean isValidUsername() {
        if (userName.length() < 6) {
            return false;
        }
        for (char ch : userName.toCharArray()) {
            if (!(Character.isLetter(ch) || ch == '.' || ch == '_' || Character.isDigit(ch))) {
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



    private int userID;
    private String userName;
    private String email;
    private String password;
    private String verifyCode;
}
