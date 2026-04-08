<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTY
    PE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>web app - registro usuario</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="center-box">
        <h2>inicio de sesion</h2>
        <form action="auth" method="post">
            <label for="username">usuario</label>
            <input type="text" name="username" required><br><br>

            <label for="password">contrasenia</label>
            <input type="password" name="password" required><br><br>

            <button type="submit">ingresar</button>
        </form>
        <p>no tienes cuenta? <a href="register.jsp">registrate aqui</a></p>
    </div>
</body>
</html>