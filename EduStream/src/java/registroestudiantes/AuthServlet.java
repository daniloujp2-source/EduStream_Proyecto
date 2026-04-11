package registroestudiantes;

import dao.UsuarioDAO;
import model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = {"/Auth"})
public class AuthServlet extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String email = request.getParameter("txtEmail"); 
    String pass = request.getParameter("txtPass");   // 

        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.validar(email, pass);

        if (user != null) {
            request.getSession().setAttribute("usuario", user);
            response.sendRedirect("principal.jsp");
        } else {
 
            response.sendRedirect("index.jsp?error=1");
        }
    }
}