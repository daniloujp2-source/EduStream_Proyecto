package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // datos de la bd en MySQL Workbench
    private static final String URL = "jdbc:mysql://localhost:3306/edustream_db";
    private static final String USER = "root"; 
    private static final String PASS = "123456"; 

    public static Connection getConexion() throws SQLException {
        try {
            // driver agregado
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("error: no se encontro el Driver de MySQL", e);
        }
    }
}