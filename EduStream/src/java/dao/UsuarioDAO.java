package dao;

import config.Conexion;
import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
public Usuario validar(String email, String pass) {
    Usuario user = null;
    
    String sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?"; 
    
    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
         
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            user = new Usuario();
             
            user.setId(rs.getInt("id_usuario")); 
            user.setEmail(rs.getString("email"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    return user;
}
}