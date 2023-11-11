package model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public interface DBConnect {

    public static String serverName = "localhost";
    public static String dbName = "vh_express";
    public static String portNumber = "3306";
    public static String userID = "root";
    public static String password = "1234";

    public static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Sử dụng MySQL JDBC Driver

            // Kết nối đến MySQL bằng tên người dùng và mật khẩu
            return DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException, which may occur when loading the driver
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
            throw new SQLException("Failed to load the MySQL driver");
        } catch (SQLException e) {
            // Handle SQLException, which may occur when connecting to the database
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Re-throw the exception to let the caller handle it
        }
    }

    // Test connection
    public static void main(String[] args) {
        try {
            Connection connection = DBConnect.getConnection();
            if (connection != null) {
                System.out.println("Connected successfully!");
                // Don't forget to close the connection when done
                connection.close();
            } else {
                System.out.println("Connection failed!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
