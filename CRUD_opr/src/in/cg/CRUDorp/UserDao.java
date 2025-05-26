package in.cg.CRUDorp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void insertUser(int id, String name, Long mob_number, String branch) {
        String sql = "INSERT INTO STUDENT(ID, NAME, MOB_NUMBER, BRANCH) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, id);
            p.setString(2, name);
            p.setLong(3, mob_number);
            p.setString(4, branch);
            int rows = p.executeUpdate();
            System.out.println("No. of rows inserted: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(); // Use proper logging in production
        }
    }

    public void updateUser( String name, String branch, int id) {
        String sql = "UPDATE STUDENT SET NAME = ?, BRANCH = ? WHERE ID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1, name);
//            p.setLong(2, mob_number);
            p.setString(2, branch);
            p.setInt(3, id);
            int rows = p.executeUpdate();
            System.out.println("No. of rows updated: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(); // Use proper logging in production
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM STUDENT WHERE ID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, id);
            int rows = p.executeUpdate();
            System.out.println("No. of rows deleted: " + rows);
        } catch (SQLException e) {
            e.printStackTrace(); // Use proper logging in production
        }
    }

    public void fetchAllUsers() {
        String sql = "SELECT * FROM STUDENT";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement p = conn.prepareStatement(sql);
             ResultSet resultSet = p.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt(1));
                System.out.println("Student Name: " + resultSet.getString(2));
                System.out.println("Student Mob_Number: " + resultSet.getLong(3));
                System.out.println("Student Branch: " + resultSet.getString(4));
                System.out.println("******");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Use proper logging in production
        }
    }
}
