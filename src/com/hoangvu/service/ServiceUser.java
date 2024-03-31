package com.hoangvu.service;

import com.hoangvu.connection.DatabaseConnection;
import com.hoangvu.model.BCrypt;
import com.hoangvu.model.ModelLogin;
import com.hoangvu.model.ModelUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class ServiceUser {
    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        try {
            PreparedStatement p = con.prepareStatement("SELECT UserId, UserName, Email, Password FROM `usermanager` WHERE BINARY(Email)=? AND `Status`='Verified' limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            p.setString(1, login.getEmail());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                int userID = r.getInt(1);
                String userName = r.getString(2);
                String email = r.getString(3);
                String hashedPassword = r.getString(4);
                if ((login.getPassword() == hashedPassword) || (BCrypt.checkpw(login.getPassword(), hashedPassword))) {
                    data = new ModelUser(userID, userName, email, "");
                }
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void insertUser(ModelUser user) throws SQLException {

        PreparedStatement p = con.prepareStatement(" insert into `usermanager` (UserName, Email, Password, VerifyCode, Permission) values(?,?,?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS);
        String verifycode = generateVerifyCode();
//        System.out.println("Verify code of " + user.getUserName() + ": " + verifycode);
        String passHashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4));
        p.setString(1, user.getUserName());
        p.setString(2, user.getEmail());
        p.setString(3, passHashed);
        p.setString(4, verifycode);
        p.setString(5, "user");
        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.first();
        int userID = r.getInt(1);
        r.close();
        p.close();
        user.setUserID(userID);
        user.setVerifyCode(verifycode);
    }

    public String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String verifyCode = df.format(ran.nextInt(1000000));
        while (checkDuplicateCode(verifyCode)) {
            verifyCode = df.format(ran.nextInt(1000000));
        }
        return verifyCode;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = con.prepareStatement("UPDATE `usermanager` SET VerifyCode = '', Status = 'verified' WHERE UserID=? limit 1");
        p.setInt(1, userID);
        p.executeUpdate();
        p.close();
    }

    private boolean checkDuplicateCode(String verifyCode) throws SQLException {
        boolean duplicate = false;
        try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `usermanager` WHERE VerifyCode=? LIMIT 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            p.setString(1, verifyCode);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }

    public boolean checkDuplicateUser(String userName) throws SQLException {
        boolean duplicate = false;
        try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `usermanager` WHERE UserName=? AND `Status` = 'verified'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            p.setString(1, userName);
            try (ResultSet r = p.executeQuery()) {
                if (r.first()) {
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean duplicate = false;
        try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `usermanager` WHERE Email=? AND `Status` = 'verified'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            p.setString(1, email);
            try (ResultSet r = p.executeQuery()) {
                if (r.first()) {
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }

    public boolean verifyCodeWithUser(int userID, String verifyCode) throws SQLException {
        boolean verify = false;
        try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `usermanager` WHERE UserID=? AND VerifyCode=? LIMIT 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            p.setInt(1, userID);
            p.setString(2, verifyCode);
            try (ResultSet r = p.executeQuery()) {
                if (r.first()) {
                    verify = true;
                }
            }
        }
        return verify;
    }
}
