package com.hoangvu.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    private DatabaseConnection() {
    }

    public void connectToDatabase() {
        String server = "127.0.0.1";
        String port = "3306";
        String database = "roomiedb";
        String userName = "root";
        String password = "1806";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, userName, password);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Đóng kết nối không thành công!");
                e.printStackTrace();
            }
        }
    }
}