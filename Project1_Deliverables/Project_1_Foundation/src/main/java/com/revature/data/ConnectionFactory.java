package com.revature.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static Connection connection = null;

    private ConnectionFactory() {

    }
    public static Connection getConnection() {
        if(connection == null) {
            System.out.println("Connection is being created");


            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");

            String url = bundle.getString("url");
            String user = bundle.getString("username");
            String password = bundle.getString("password");
            try{
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Something went wrong when creating the connection");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
