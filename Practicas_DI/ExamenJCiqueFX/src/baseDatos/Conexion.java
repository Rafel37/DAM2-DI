package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection dbConnector() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String host = "localhost";
        String dbname = "bdexamen";
        String url = "jdbc:mysql://" + host + "/" + dbname;
        String username = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}