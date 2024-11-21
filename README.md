# Tienda de Ventas y Stock

## Descripción

La aplicación **Tienda de Ventas y Stock** fue diseñada para gestionar las ventas y el stock de productos de un negocio. Permite registrar ventas, gestionar productos y controlar el inventario en tiempo real. La aplicación se construye como una API RESTful, implementada en **Spring Boot**, y utiliza **MySQL** para almacenar los productos, ventas y clientes.

## Funcionalidades principales

- **Gestión de Productos**: Permite registrar, editar, eliminar y consultar productos en el inventario. Cada producto tiene atributos como código, nombre, marca, costo y cantidad disponible.
- **Gestión de Ventas**: Registra las ventas realizadas, asociando una lista de productos vendidos a cada transacción.
- **Gestión de Clientes**: Permite gestionar la información de los clientes, como nombre y DNI.
- **Control de Stock**: Actualiza las cantidades de los productos automáticamente después de cada venta, para asegurar un control eficiente del inventario.

## Modelado de la Aplicación

El sistema se basa en tres entidades principales:

1. **Producto**: Contiene información sobre los productos disponibles en el inventario.
2. **Venta**: Registra las transacciones de venta, con detalles como los productos vendidos y el monto total.
3. **Cliente**: Registra los datos de los clientes, tales como nombre, apellido y DNI.

## Arquitectura de la Aplicación

La aplicación está basada en una arquitectura monolítica con varias capas. Las interacciones entre las entidades son manejadas de forma eficiente usando **JPA** y **Hibernate** para la persistencia de datos.

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **Framework**: Spring Boot (para crear la API)
- **Base de Datos**: MySQL (para almacenamiento de productos, ventas y clientes)
- **JPA / Hibernate** (para el manejo de la persistencia de datos)
- **Docker** (para contenerización y facilitar el despliegue)
- **Postman** (para realizar pruebas de la API)
- **Git y GitHub** (para control de versiones y colaboración)

## Endpoints Principales

A continuación se describen los principales endpoints de la API:

### Productos
- **GET /productos**: Lista todos los productos disponibles en el inventario.
- **POST /productos/crear**: Crea un nuevo producto en el inventario.
- **PUT /productos/editar**: Edita los detalles de un producto.
- **DELETE /productos/eliminar/{codigoProducto}**: Elimina un producto del inventario por su ID.

### Ventas
- **GET /ventas**: Lista todas las ventas registradas.
- **POST /ventas/crear**: Registra una nueva venta, asociando productos y un cliente.
  
### Clientes
- **GET /clientes**: Lista todos los clientes registrados.
- **POST /clientes/crear**: Registra un nuevo cliente.
