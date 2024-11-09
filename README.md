# Aplicación de Gestión de Ventas y Stock para un Bazar

## Descripción

Esta aplicación fue desarrollada para ayudar a un bazar que ha experimentado un incremento significativo en sus ventas. La dueña del bazar necesitaba una solución para gestionar las ventas y el stock de productos de manera automatizada, dado que el manejo manual ya no era viable. La aplicación permite registrar ventas, gestionar productos y controlar el inventario de manera eficiente.

El sistema está diseñado como una API RESTful.

### Funcionalidades principales

1. **Gestión de Productos**: Permite registrar, editar, eliminar y consultar los productos disponibles en el bazar, con información detallada como código, nombre, marca, costo y cantidad disponible.
2. **Gestión de Ventas**: Permite registrar ventas, asociar una lista de productos a cada venta y calcular el total de la transacción. Cada venta está asociada a un cliente.
3. **Gestión de Clientes**: Permite registrar y consultar la información de los clientes, incluyendo nombre, apellido y DNI.
4. **Control de Stock**: La aplicación actualiza automáticamente las cantidades de productos disponibles, asegurando un control de inventario preciso y en tiempo real.

## Modelado de la Aplicación

El sistema está basado en tres entidades principales:

- **Producto**: Contiene detalles sobre los productos que el bazar vende, incluyendo su código, nombre, marca, costo y cantidad disponible.
- **Venta**: Cada venta contiene una lista de productos vendidos y está asociada a un cliente. La venta también registra la fecha y el monto total de la transacción.
- **Cliente**: Registra los datos de los clientes, incluyendo su ID, nombre, apellido y DNI.

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **Framework**: Spring Boot (para crear la API)
- **Base de Datos**: MySQL (para almacenamiento de productos, ventas y clientes)
- **JPA** (Java Persistence API) y **Hibernate** (para el manejo de la persistencia de datos)
- **Docker** (para contenerización y facilitar el despliegue)
- **Postman** (para realizar pruebas de la API)
- **Git** y **GitHub** (para control de versiones y colaboración)

### Endpoints Principales
- GET /productos: Lista todos los productos disponibles en el bazar.
- POST /productos/crear: Crea un nuevo producto.
- PUT /productos/editar: Edita los detalles de un producto.
- DELETE /productos/eliminar/{id}: Elimina un producto por su ID.
- GET /ventas: Lista todas las ventas registradas.
- POST /ventas/crear: Registra una nueva venta.
- GET /clientes: Lista todos los clientes registrados.
- POST /clientes/crear: Registra un nuevo cliente.


