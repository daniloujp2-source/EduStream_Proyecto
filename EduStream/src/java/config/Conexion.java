package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
private static final String URL = "jdbc:mysql://localhost:3306/edustream_db?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
    private static final String PASS = "123456"; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace(); 
    throw new SQLException(e);
}
    }
}