package com.example.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        String url = "jdbc:mysql://localhost:3306/db_sistema";
        String userDB = "root";
        String passDB = "123456"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userDB, passDB);

          
            String query = "SELECT * FROM usuarios WHERE nombre = ? AND email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", userName);
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("index.jsp?error=invalid_credentials");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=server_error");
        }
    }
}