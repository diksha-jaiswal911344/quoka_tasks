package org.example.dao;

import org.example.config.DatabaseConnection;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Insert User
    public void insertUser(User user) {
        String query = "INSERT INTO users (fname, lname, address, contact) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getContact());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ User added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve User by ID
    public User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("address"),
                        rs.getString("contact")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Retrieve All Users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("address"),
                        rs.getString("contact")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update User
    public void updateUser(User user) {
        String query = "UPDATE users SET fname = ?, lname = ?, address = ?, contact = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getContact());
            pstmt.setInt(5, user.getId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ User updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete User
    public void deleteUser(int userId) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ User deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
