# Demo App Reactiva

Esta es una aplicación básica desarrollada con **Spring Boot WebFlux** y **R2DBC** (Programación Reactiva), diseñada para gestionar un catálogo simple de productos. La aplicación se conecta de manera asíncrona y no bloqueante a una base de datos MySQL.

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot** (Starter WebFlux, Starter Data R2DBC)
- **MySQL** (Driver R2DBC para MySQL)
- **Lombok** (Para reducir código boilerplate)
- **Maven** como gestor de dependencias

## Requisitos Previos

- Tener instalado [Java 21](https://jdk.java.net/21/).
- Tener instalado [Maven](https://maven.apache.org/) (o puedes usar el Wrapper inclúido `./mvnw`).
- Tener un servidor [MySQL](https://www.mysql.com/) en ejecución en el puerto `3306`.

## Configuración de la Base de Datos

1. Abre tu cliente MySQL favorito (como MySQL Workbench o DBeaver).
2. Ejecuta el script SQL que se encuentra en el archivo `.sql` en la raíz del proyecto para crear la base de datos `tienda_reactiva`, la tabla `productos` y cargar algunos datos iniciales:

```sql
CREATE DATABASE tienda_reactiva;
USE tienda_reactiva;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DOUBLE
);

-- Datos de prueba
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
```

3. Verifica que las credenciales en `src/main/resources/application.properties` coincidan con tu servidor MySQL:

```properties
spring.r2dbc.url=r2dbc:mysql://localhost:3306/tienda_reactiva
spring.r2dbc.username=tu_usuario
spring.r2dbc.password=tu_contraseña
```
*(Nota: Por defecto el proyecto usa usuario `root` y contraseña `753159852`)*

## Ejecución de la Aplicación

Para levantar y ejecutar la aplicación de forma local, puedes usar el Wrapper de Maven desde la terminal en la raíz del proyecto:

En **Windows**:
```cmd
mvnw.cmd spring-boot:run
```

En **Linux / macOS**:
```bash
./mvnw spring-boot:run
```

La aplicación se levantará y estará lista para aceptar peticiones reactivas.

## Endpoints Disponibles

La API expone las siguientes rutas bajo el prefijo `/api/v1/productos`:

### 1. Obtener todos los productos (Server-Sent Events)
- **URL**: `/api/v1/productos`
- **Method**: `GET`
- **Response**: Devuelve un **Flujo (Flux)** de productos en formato `text/event-stream`.
- **Ejemplo con cURL**:
  ```bash
  curl -X GET http://localhost:8080/api/v1/productos
  ```

### 2. Registrar un nuevo producto
- **URL**: `/api/v1/productos`
- **Method**: `POST`
- **Body**: JSON usando el `ProductoDTO`.
  ```json
  {
      "nombre": "Nuevo Producto",
      "precio": 150.50
  }
  ```
- **Ejemplo con cURL**:
  ```bash
  curl -X POST http://localhost:8080/api/v1/productos \
  -H "Content-Type: application/json" \
  -d '{"nombre": "Nuevo Producto", "precio": 150.50}'
  ```

## Estructura del Proyecto

- `models/`: Contiene las entidades (como `Producto`) y los DTOs (como `ProductoDTO`).
- `repository/`: Contiene el repositorio reactivo (ej. heredando de `ReactiveCrudRepository`).
- `services/`: Contiene la lógica de negocio y consumo del repositorio retornando `Mono` y `Flux`.
- `controllers/`: Expone los endpoints HTTP.
