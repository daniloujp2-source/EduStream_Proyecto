<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>registro de usuarios</title>
    </head>
    <body>
        <h2>registrar un nuevo usuario</h2>
        <form action="RegistroServlet" method="POST">
            Nombre: <input type="text" name="txtNombre"><br>
            Email: <input type="text" name="txtEmail"><br>
            <input type="submit" value="registrar estudiante">
        </form>
    </body>
</html>