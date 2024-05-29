package com.ironman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionCore {

    public Connection getConnection() {
        //Attributes
        String hostName = "dpg-cpa0r9tds78s73cp2ueg-a.oregon-postgres.render.com";
        String port = "5432";
        String dbName = "restaurant_management_db";
        String userName = "developer";
        String password = "Uj65aOw7qX1OqalviBjSpn4EPiubf468";

        //process


        // Load driver
        try {

            Class.forName("org.postgresql.Driver");


            // urlñ connection

            String url ="jdbc:postgresql://" + hostName + ":" + port + "/" + dbName;

            //result
            return DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            System.out.println("ConnectionCore::getConnection::Error: " + e.getMessage());
        }

        return null;

    }

}