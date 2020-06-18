package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mehmet
 */
public class DBConnect {
private static String url = "jdbc:mysql://localhost:3306/transfermarket";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "bja";
    private static Connection c;
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                c = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Connection could not be established."); 
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return c;
    }
    public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (Exception ex) {
		}
	}
}