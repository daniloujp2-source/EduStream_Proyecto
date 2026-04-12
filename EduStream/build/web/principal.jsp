<%@page import="java.util.List"%>
<%@page import="model.Curso"%>
<%@page import="model.Usuario"%>
<%@page import="dao.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
     HttpSession sesion = request.getSession();
    Usuario user = (Usuario) sesion.getAttribute("usuario");

    if (user == null) {
        response.sendRedirect("index.jsp?error=sesion_invalida");
        return;
    }
    CursoDAO dao = new CursoDAO();
    List<Curso> lista = dao.listar();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido - EduStream</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <div class="p-5 mb-4 bg-light rounded-3 shadow">
        <h1>¡Bienvenido, <%= user.getNombre() %>!</h1>
        <p class="lead">Has ingresado correctamente al sistema <strong>EduStream</strong>.</p>
        <p>Tu correo registrado es: <%= user.getEmail() %></p>
        <hr>
        <a href="LogoutServlet" class="btn btn-danger">Cerrar Sesión Segura</a>
    </div>

    <div class="mt-5">
        <h3>Mis Cursos Registrados</h3>
        <table class="table table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre del Curso</th>
                    <th>Descripción</th>
                    <th>Créditos</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (lista != null) {
                        for (Curso c : lista) {
                %>
                <tr>
                    <td><%= c.getIdCurso() %></td>
                    <td><%= c.getNombre() %></td>
                    <td><%= c.getDescripcion() %></td>
                    <td><span class="badge bg-primary"><%= c.getCreditos() %></span></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>