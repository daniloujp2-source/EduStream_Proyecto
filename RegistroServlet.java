package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("txtNombre");
        String email = request.getParameter("txtEmail");

        String url = "jdbc:mysql://localhost:3306/db_sistema";
        String user = "root";
        String pass = "123456"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, email);

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                response.getWriter().println("✅ ¡usuario " + nombre + " registrado con éxito!");
            }
            
            con.close();
        } catch (Exception e) {
            response.getWriter().println("❌ error: " + e.getMessage());
        }
    }
}