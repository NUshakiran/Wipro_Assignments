package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	    public static Connection getConnection() {
	        String url = "jdbc:mysql://localhost:3306/wipro";
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(url, "root", "usha");
	        } catch (ClassNotFoundException | SQLException e) {
	            throw new RuntimeException("Database connection failed: " + e.getMessage());
	        }
	    }
}
