<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registro de usuario</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="center-box">
        <h2>registro de usuario</h2>
        <form action="RegistroServlet" method="POST">
            <label for="username">usuario</label>
            <input type="text" name="username" required><br><br>

            <label for="password">contrasenia</label>
            <input type="password" name="password" required><br><br>

            <label for="email">correo electronico</label>
            <input type="email" name="email" required><br><br>

            <button type="submit">agregar</button>
        </form>
    </div>
</body>
</html>