
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mehmet
 */
public class DBConnect {
    
   public Connection connect(){
        Connection con = null ;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transfermarket?user=root&password=123");
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        
        
        return con;
    }
}
