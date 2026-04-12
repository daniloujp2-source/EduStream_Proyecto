package dao;

import config.Conexion;
import model.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM cursos";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
 while (rs.next()) {
    Curso c = new Curso();
    c.setIdCurso(rs.getInt("id_curso"));
    c.setNombre(rs.getString("nombre_curso")); 
    c.setDescripcion(rs.getString("descripcion"));
    c.setCreditos(rs.getInt("creditos")); 
    lista.add(c);
}
System.out.println(">>> total de cursos en la lista:  " + lista.size());
            
        } catch (Exception e) {
            System.err.println("error en CursoDAO: " + e.getMessage());
        }
        return lista;
    }
}