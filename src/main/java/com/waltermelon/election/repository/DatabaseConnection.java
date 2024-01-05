package com.waltermelon.election.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_HOST = System.getenv("DB_HOST");
    private static final String DB_PORT = System.getenv("DB_PORT");
    private static final String POSTGRES_DB = System.getenv("POSTGRES_DB");
    private static final String POSTGRES_USER = System.getenv("POSTGRES_USER");
    private static final String POSTGRES_PASSWORD = System.getenv("POSTGRES_PASSWORD");

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            final String JDBC_URL = String.format("jdbc:postgresql://%s:%s/%s", DB_HOST, DB_PORT, POSTGRES_DB);
            return DriverManager.getConnection(JDBC_URL, POSTGRES_USER, POSTGRES_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.exit(1);
            return null;
        } catch (SQLException e) {
            throw new IllegalStateException("connect database fail:" + e.getMessage());
        }
    }
}
