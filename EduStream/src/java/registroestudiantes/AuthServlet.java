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
        String pass = request.getParameter("txtPass");   

        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.validar(email, pass);

 if (user != null) {
    // se crea la sesion
    HttpSession session = request.getSession();
    
    // se guarda al usuario en la sesion para usar despues
session.setAttribute("usuario", user);
    
    // redirige a la pagina principal
    response.sendRedirect("principal.jsp");
} else {
    // mensaje de error por si falla al ingresar
    request.setAttribute(" error ️", "️ Credenciales incorrectas ️");
    request.getRequestDispatcher("index.jsp").forward(request, response);
}
    }
}