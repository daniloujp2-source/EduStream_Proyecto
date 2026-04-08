package modelo; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/db_sistema";
    private static final String USER = "root"; 
    private static final String PASS = "123456"; 

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ ¡conexion exitosa a MySQL!");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
System.out.println("*** usuario encontrado: " + rs.getString("nombre") + " (" + rs.getString("email") + ") ***");            }
            con.close();
        } catch (Exception e) {
            System.out.println("❌ detalle del error:");
            e.printStackTrace();
        }
    }
}