package com.example.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EstudianteServlet")
public class EstudianteServlet extends HttpServlet {
    
    String url = "jdbc:mysql://localhost:3306/db_sistema";
    String userDB = "root";
    String passDB = "123456"; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("delete")) {
            eliminarEstudiante(request, response);
        } else {
            listarEstudiantes(request, response);
        }
    }

    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userDB, passDB);
            
            String query = "SELECT * FROM usuarios";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            request.setAttribute("listaUsuarios", rs); 
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Connection con = DriverManager.getConnection(url, userDB, passDB);
            String query = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            response.sendRedirect("EstudianteServlet?action=list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}