package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mehmet
 */
public abstract class DBConnect {

    private Connection connection;

    public Connection connect() throws SQLException  {

        if (this.connection == null || this.connection.isClosed()) {
            try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transfermarket?user=root&password=123");
                System.out.println("Connect Succesfull Database");

            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.connection;
    }
}
