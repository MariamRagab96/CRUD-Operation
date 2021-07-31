/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory.doa.config;

import java.sql.*;

public class ConnectionDB {

    private static ConnectionDB instance = null;
    private Connection connection = null;

    private ConnectionDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mariam", "root", "root");
            System.out.println("get connection");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static synchronized ConnectionDB getInstance() {

        try {
            if (instance == null || instance.getConnection().isClosed()) {

                instance = new ConnectionDB();

                System.out.println("instance : " + instance);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instance;
    }

}
