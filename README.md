# ProyectoFinalIntegracion

**Reporte Técnico**

Este documento detalla la implementación de servicios RESTful en nuestra aplicación de registro de usuarios, junto con su documentación mediante Swagger. La aplicación expone dos servicios principales: gestión de usuarios y autenticación/seguridad, implementados con Spring Boot y documentados mediante OpenAPI 3.0 (Swagger).

**Arquitectura del Sistema**
Componentes Principales
La aplicación sigue una arquitectura en capas con los siguientes componentes:

com.registro.usuarios
├── configuracion
│   ├── PasswordEncoderConfig.java
│   └── SwaggerConfig.java
├── controlador
│   ├── RegistroControlador.java
│   └── rest
│       ├── UsuarioRestController.java
│       └── EncriptacionRestController.java
├── dto
│   ├── PasswordDTO.java
│   ├── UsuarioRegistroDTO.java
│   └── VerificarPasswordDTO.java
├── modelo
│   ├── Rol.java
│   └── Usuario.java
├── repositorio
│   └── UsuarioRepositorio.java
├── seguridad
│   └── SecurityConfiguration.java
└── servicio
│   ├── EncriptacionServicio.java
│   ├── EncriptacionServicioImpl.java
│   ├── UsuarioServicio.java
│   └── UsuarioServicioImpl.java
└── resources
    ├── EncriptacionServicio.java
    │   ├── Index.html
    │   ├── login.html
    │   └── registro.html
    └── applicaton.properties

**Servicios Implementados**

**Servicio 1: Gestión de Usuarios**
Registro de nuevos usuarios
Listado de usuarios existentes
Consulta de usuario por email

**Servicio 2: Autenticación y Seguridad**
Encriptación y verificación de contraseñas
Configuración de políticas de seguridad
Autenticación de usuarios

**API de Usuarios**
------------------------------------------------------------
| Método | Endpoint                  | Descripción                  | Parámetros            | Respuesta               |
|--------|----------------------------|-------------------------------|-----------------------|-------------------------|
| GET    | /api/usuarios               | Lista todos los usuarios      | Ninguno               | Array de usuarios (200 OK) |
| POST   | /api/usuarios/registro      | Registra un nuevo usuario     | UsuarioRegistroDTO    | Usuario creado (201 Created) |
| GET    | /api/usuarios/{email}       | Obtiene usuario por email     | email (path)          | Usuario (200 OK) o 404 Not Found |
------------------------------------------------------------

**API de Encriptación**
------------------------------------------------------------
| Método | Endpoint                          | Descripción               | Parámetros             | Respuesta           |
|--------|------------------------------------|----------------------------|------------------------|---------------------|
| POST   | /api/encriptacion/encriptar         | Encripta una contraseña    | PasswordDTO            | String encriptado (200 OK) |
| POST   | /api/encriptacion/verificar         | Verifica una contraseña    | VerificarPasswordDTO   | Boolean (200 OK)    |
------------------------------------------------------------

**Configuración de Seguridad**
Se ha implementado la siguiente configuración de seguridad:

Acceso público a endpoints de registro y recursos estáticos
Protección de endpoints privados con autenticación
Desactivación de CSRF para APIs REST
Configuración de login mediante formulario


**Acceso a la Documentación Swagger:**

Swagger UI se encuentra disponible en http://localhost:8080/swagger-ui/index.html. 
Para poder consumir los endpoints protegidos, es necesario registrarse o autenticarse previamente.

**Notas de uso**

applicaton.properties
Es importante cambiar la contraseña de la base da datos para ligarla a tu propia base de datos:
spring.datasource.password= **tu contraseña**
tambien es importante crear la base de datos antes, en workbench mySQL.

**Encender los servicios"**
Teniendo en cuenta lo anterior solo debes dirigirte a: 
RegistroUsuariosApplication.java y ejecutarlo.

        
