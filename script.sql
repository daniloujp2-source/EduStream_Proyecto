-- crear una base de datos
CREATE DATABASE IF NOT EXISTS db_sistema;
USE db_sistema;
-- crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- insertar los datos
INSERT INTO usuarios (nombre, email) VALUES ('?', 'admin@sistema.com');

-- con esto verificamos que se creo bien 
SELECT * FROM usuarios;