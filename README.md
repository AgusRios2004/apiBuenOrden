# API Buen Orden - Sistema de Gestión de Clubes

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-5.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

> **API RESTful** diseñada para la administración integral de instituciones deportivas, gestionando el ciclo de vida de los socios, tesorería y categorización deportiva.

## 📖 Descripción del Proyecto

Este backend fue desarrollado para solucionar la problemática de gestión de pagos y seguimiento de jugadores en el **Club Buen Orden F.C.** Provee una arquitectura robusta para manejar la lógica de negocio administrativa, permitiendo un control histórico de categorías y un registro detallado de cuotas mensuales.

## ✨ Funcionalidades Principales

* **Gestión de Socios/Jugadores:** ABM (Alta, Baja, Modificación) completo de perfiles.
* **Control de Tesorería:** Registro de pagos mensuales, control de deudas y generación de estados de cuenta.
* **Historial Deportivo:** Seguimiento de la evolución de los jugadores a través de diferentes categorías y disciplinas.
* **Arquitectura Escalable:** Diseño modular basado en capas (Controller, Service, Repository) listo para futuras integraciones frontend.

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3+
* **Persistencia:** Spring Data JPA & Hibernate
* **Base de Datos:** MySQL / H2 (Entornos de prueba)
* **Build Tool:** Maven

## 🚀 Instalación y Ejecución

### Requisitos Previos
* Java JDK 17 o superior.
* Maven (Opcional, el proyecto incluye Wrapper).
* MySQL Server (Opcional para producción).

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/AgusRios2004/apiBuenOrden.git](https://github.com/AgusRios2004/apiBuenOrden.git)
    cd api-buen-orden
    ```

2.  **Configurar Base de Datos:**
    Edita el archivo `src/main/resources/application.properties`.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/buen_orden_db
    spring.datasource.username=root
    spring.datasource.password=tu_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Ejecutar la aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```

La API iniciará en: `http://localhost:8080`

---

## 🔌 Documentación de Endpoints

| Módulo | Método | Endpoint | Descripción |
| :--- | :---: | :--- | :--- |
| **Jugadores** | `GET` | `/players` | Listar todos los jugadores activos. |
| | `POST` | `/players` | Registrar un nuevo jugador. |
| **Pagos** | `POST` | `/payments` | Registrar el pago de una cuota. |
| | `GET` | `/payments/player/{id}` | Ver historial de pagos de un jugador. |
| **Categorías** | `PUT` | `/categories/{id}` | Actualizar información de categoría. |

> **Nota:** Se recomienda utilizar **Postman** o **Insomnia** para probar las peticiones.

## 👤 Autor

**Agustín Rios** - *Backend Developer*
* [LinkedIn](https://www.linkedin.com/in/agustin-rios)
* [GitHub Profile](https://github.com/AgusRios2004)

---
*Desarrollado con ❤️ para la gestión deportiva eficiente.*
