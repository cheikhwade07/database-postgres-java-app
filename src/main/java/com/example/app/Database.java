package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() throws SQLException {
        // Read from env vars
        String url  = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASSWORD");

        if (url == null || user == null || pass == null) {
            throw new IllegalStateException("DB_URL / DB_USER / DB_PASSWORD env vars are not set.");
        }

        // explicit driver load (modern JDBC auto-loads)
        try { Class.forName("org.postgresql.Driver"); } catch (ClassNotFoundException ignored) {}

        return DriverManager.getConnection(url, user, pass);
    }

}
