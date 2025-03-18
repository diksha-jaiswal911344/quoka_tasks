package service;

import org.example.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private final Connection connection;

    public UserService() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed!");
        }    }

    // Insert a new user
    public void insertUser(String fname, String lname, String address, String contact) {
        String query = "INSERT INTO users (fname, lname, address, contact) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, address);
            pstmt.setString(4, contact);
            pstmt.executeUpdate();
            System.out.println(" User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public synchronized void insertUser(String fname, String lname, String address, String contact) throws SQLException {
//        connection.setAutoCommit(false);  // Start transaction
//
//        String getLastIdQuery = "SELECT COALESCE(MAX(id), 0) + 1 FROM users FOR UPDATE"; // Lock for update
//        int newId = 1;
//
//        try (PreparedStatement ps = connection.prepareStatement(getLastIdQuery);
//             ResultSet rs = ps.executeQuery()) {
//            if (rs.next()) {
//                newId = rs.getInt(1);
//            }
//        }
//
//        // Insert new user
//        String insertQuery = "INSERT INTO users (id, fname, lname, address, contact) VALUES (?, ?, ?, ?, ?)";
//        try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
//            ps.setInt(1, newId);
//            ps.setString(2, fname);
//            ps.setString(3, lname);
//            ps.setString(4, address);
//            ps.setString(5, contact);
//            ps.executeUpdate();
//        }
//
//        connection.commit(); // Commit transaction
//        connection.setAutoCommit(true);  // Reset auto-commit
//        System.out.println("User inserted successfully!");
//    }



    // Update user details
    public void updateUser(int id, String fname, String lname, String address, String contact) {
        String query = "UPDATE users SET fname = ?, lname = ?, address = ?, contact = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, address);
            pstmt.setString(4, contact);
            pstmt.setInt(5, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("No user found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete user manually
    public void deleteUser(int id) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the user ID to delete: ");
//        int id = scanner.nextInt();

        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" User deleted successfully!");
            } else {
                System.out.println(" No user found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display all users
    public void displayUsers() {
        String query = "SELECT * FROM users";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("|        ID|        First Name|        Last Name|        Address|               Contact|");
            System.out.println("----------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("|%9s |%17s |%16s |%14s |     %16s |\n",rs.getInt("id"),rs.getString("fname"), rs.getString("lname"), rs.getString("address"),
                        rs.getString("contact"));
                System.out.println("----------------------------------------------------------------------------------------");

//                System.out.println(rs.getInt("id") + " | " +
//                        rs.getString("fname") + " | " +
//                        rs.getString("lname") + " | " +
//                        rs.getString("address") + " | " +
//                        rs.getString("contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}