<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%
    HttpSession sesion = request.getSession();
    Usuario user = (Usuario) sesion.getAttribute("usuario");
    if (user == null) {
        response.sendRedirect("index.jsp"); 
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido - EduStream</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <div class="p-5 mb-4 bg-light rounded-3">
        <h1>¡Bienvenido, <%= user.getEmail() %>!</h1>
        <p>Has ingresado correctamente al sistema EduStream.</p>
        <hr>
        <a href="index.jsp" class="btn btn-danger">Cerrar Sesión</a>
    </div>
</body>
</html>