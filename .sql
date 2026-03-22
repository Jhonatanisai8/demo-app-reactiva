CREATE DATABASE tienda_reactiva;
USE tienda_reactiva;
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DOUBLE
);

show tables;
INSERT INTO productos (nombre, precio) VALUES
('Laptop Lenovo', 2500.99),
('Mouse Inalámbrico', 45.50),
('Teclado Mecánico', 180.00),
('Monitor 24 Pulgadas', 899.99),
('Audífonos Bluetooth', 120.75),
('Disco Duro 1TB', 320.40),
('Memoria USB 64GB', 35.90),
('Silla Gamer', 650.00),
('Webcam HD', 210.30),
('Parlantes USB', 95.60);
