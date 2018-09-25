package com.tedu.utils;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;
    private static Properties properties;
    private static String url;
    private static String username;
    private static String password;
    private static String driver;


    static {
        properties = new Properties();
        try {
            properties.load(DBConnection.class.getResourceAsStream("../db.properties"));
            url = (String) properties.get("url");
            username = (String) properties.get("username");
            password = (String) properties.get("password");
            driver = (String) properties.get("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void rollBack() throws SQLException {
        connection.rollback();
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
