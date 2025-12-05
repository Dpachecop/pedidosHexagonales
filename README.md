# 📦 Pedidos Hexagonales

> **API RESTful para la gestión de pedidos y usuarios implementada con Arquitectura Hexagonal (Puertos y Adaptadores).**

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.11-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-In_Memory-blue?style=for-the-badge&logo=h2&logoColor=white)


## Descripción

Este proyecto es un ejemplo práctico de cómo desacoplar la lógica de negocio de los detalles de infraestructura utilizando **Arquitectura Hexagonal**. El dominio (núcleo) no depende de frameworks externos ni de la base de datos, garantizando un código mantenible y testeable.

### Características Principales

* **Gestión de Usuarios:** Registro, autenticación (Login) y administración de perfiles.
* **Gestión de Pedidos:** Creación, listado y actualización de estados de pedidos.
* **Seguridad:** Implementación básica con Spring Security y `UserDetailsService` personalizado.
* **Documentación Viva:** Integración con Swagger UI (OpenAPI).
* **Base de Datos en Memoria:** H2 para prototipado rápido.

## Arquitectura del Proyecto

El código está organizado siguiendo estrictamente las capas de la arquitectura hexagonal:

```text
src/main/java/com/daniel/pedidosHexagonales
├── core                   # NÚCLEO (Dominio y Puertos)
│   ├── domain             # Entidades puras (Usuario, Pedido)
│   ├── port               # Interfaces (Puertos de Entrada y Salida)
│   └── service            # Lógica de negocio
├── adapter                # ADAPTADORES (Infraestructura)
│   ├── databases          # Adaptadores de Base de Datos (JPA, SQL)
│   └── security           # Configuración de Spring Security
└── entrypoint             # PUNTOS DE ENTRADA
    └── rest               # Controladores REST y DTOs



