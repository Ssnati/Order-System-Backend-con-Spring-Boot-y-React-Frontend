# **E-Commerce Backend con Spring Boot y React Frontend**

Este proyecto implementa el backend para una aplicación de e-commerce utilizando **Spring Boot** y un frontend desarrollado en **React**. La aplicación permite la gestión de clientes, productos y órdenes, proporcionando una API REST para las operaciones CRUD. Además, maneja la integración con un frontend React, donde las peticiones se realizan a través de Axios. Se han habilitado las configuraciones necesarias para permitir **CORS**, asegurando que ambas capas se conecten correctamente.

## **Descripción**

El backend está construido utilizando Spring Boot y ofrece una estructura robusta para la gestión de entidades como **clientes**, **productos** y **órdenes**. A través de los **DTOs** (Data Transfer Objects), las entidades se manejan de manera eficiente, mientras que los **Mappers** transforman las clases entre su representación de entidad y DTO.

El sistema admite operaciones como la creación de nuevas órdenes, la asignación de productos a una orden, y el cálculo del total de una orden, todo gestionado a través de servicios y controladores REST.

La interacción entre el frontend y el backend se gestiona mediante Axios, una biblioteca popular en React para hacer peticiones HTTP. El frontend permite a los usuarios crear y gestionar sus pedidos, mientras que el backend responde con datos que se renderizan en la interfaz.

### **Principales características**

- Gestión de entidades de **Clientes**, **Productos** y **Órdenes**.
- Peticiones HTTP asíncronas desde el frontend con Axios.
- Habilitación de **CORS** para permitir la comunicación entre dominios.
- Uso de **JUnit** para pruebas unitarias en el backend.
- Documentación de la API REST mediante **Swagger**.

## **Tecnologías Utilizadas**

### **Backend**
- **Java 17**
- **Spring Boot 3.3.4**
- **JUnit 5** para pruebas unitarias.
- **Maven** para la gestión de dependencias.
- **MySQL/PostgreSQL** como base de datos.

### **Frontend**
- **React** para el desarrollo de la interfaz de usuario.
- **Axios** para la gestión de peticiones HTTP.
- **Bootstrap/Material-UI** para el estilo de componentes.

## **Instalación y Configuración**

1. Clonar el repositorio:
    ```bash
    git clone https://github.com/usuario/nombre-repositorio.git
    ```

2. Configurar el backend:
    - Crear una base de datos en MySQL/PostgreSQL.
    - Configurar las credenciales de la base de datos en el archivo `application.properties` o `application.yml`.

3. Ejecutar la aplicación Spring Boot:
    ```bash
    ./mvnw spring-boot:run
    ```

4. Configurar el frontend:
    - Navegar al directorio del frontend.
    - Instalar las dependencias con npm:
    ```bash
    npm install
    ```
    - Ejecutar la aplicación React:
    ```bash
    npm start
    ```

## **Contribución**

Si deseas contribuir, por favor sigue los siguientes pasos:

1. Haz un **fork** de este repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios necesarios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Envía los cambios a tu repositorio (`git push origin feature/nueva-funcionalidad`).
5. Abre un **pull request** para revisión.

## **Licencia**

Este proyecto está bajo la licencia **MIT**. Consulta el archivo `LICENSE` para más información.
