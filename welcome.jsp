<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>gestion de estudiantes</title>
</head>
<body>
    <h2>lista de estudiantes registrados</h2>
    <table border="1">
        <tr>
            <th>id</th>
            <th>nombre</th>
            <th>email</th>
            <th>acciones</th>
        </tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("listaUsuarios");
            if(rs != null) {
                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("nombre") %></td>
            <td><%= rs.getString("email") %></td>
            <td>
                <a href="EstudianteServlet?action=delete&id=<%= rs.getInt("id") %>">Eliminar</a>
            </td>
        </tr>
        <% 
                }
            }
        %>
    </table>
    <br>
    <a href="register.jsp">Registrar Nuevo</a>
</body>
</html>