<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login - EduStream</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light" style="display: flex; align-items: center; height: 100vh;">
    <div class="container border shadow-sm p-4 bg-white rounded" style="max-width: 400px;">
        <h3 class="text-center mb-4">EduStream Login</h3>
        
        <% if(request.getParameter("error") != null) { %>
            <div class="alert alert-danger">Credenciales incorrectas</div>
        <% } %>

        <form action="Auth" method="POST">
            <div class="mb-3">
                <label class="form-label">Correo Electrónico</label>
                <input type="email" name="txtEmail" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Contraseña</label>
                <input type="password" name="txtPass" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Ingresar</button>
        </form>
    </div>
</body>
</html>