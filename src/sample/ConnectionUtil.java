package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    Connection conn = null;

    public static Connection conDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "cde3nji9";
            String schemaName = "dbsdemo3";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+schemaName, username, password);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : " + ex.getMessage());
            return null;
        }
    }
}
