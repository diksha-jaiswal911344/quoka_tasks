package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/user_db"; // Change to your DB name
    private static final String USER = "postgres"; // Your pgAdmin username
    private static final String PASSWORD = "diksha@1234"; // Your pgAdmin password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connected to PostgreSQL successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
