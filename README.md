# API Buen Orden: Sistema de Gestión de Pagos

¡Bienvenido/a al repositorio de la **API Buen Orden**! Este proyecto es una API RESTful diseñada para gestionar los pagos, jugadores, disciplinas y categorías dentro de una organización, como un club deportivo o una academia.

## 🚀 Tecnologías Principales

Esta API está construida principalmente con:

* **Java ☕**
* **Spring Boot**: Framework principal para el desarrollo de la aplicación.
* **Maven**: Herramienta de gestión y construcción del proyecto.
* **Spring Data JPA**: Para la capa de acceso a datos y ORM.

## 📁 Estructura del Proyecto

El proyecto sigue una estructura estándar de **Maven** y el patrón **Model-View-Controller (MVC)**, típico de las aplicaciones Spring Boot
## 🛠️ Configuración y Ejecución

### Requisitos Previos

Asegúrate de tener instalado:

* **Java Development Kit (JDK) 17+** (o la versión especificada en `pom.xml`).
* **Maven** (opcional, se incluye `mvnw`).

### Configuración del Entorno

1.  **Clona el repositorio:**
    ```bash
    git clone [URL_DE_TU_REPOSITORIO]
    cd api-buen-orden
    ```
2.  **Configuración de la Base de Datos:**
    Edita el archivo `src/main/resources/application.properties` con tus credenciales y detalles de conexión a la base de datos (por ejemplo, PostgreSQL, MySQL, H2):

    ```properties
    # Ejemplo de configuración para H2 (base de datos en memoria para desarrollo)
    # spring.datasource.url=jdbc:h2:mem:testdb
    # spring.datasource.driverClassName=org.h2.Driver
    # spring.datasource.username=sa
    # spring.datasource.password=
    
    # Ejemplo de configuración para PostgreSQL (si es el caso)
    # spring.datasource.url=jdbc:postgresql://localhost:5432/mibasedatos
    # spring.datasource.username=user
    # spring.datasource.password=password
    
    spring.jpa.hibernate.ddl-auto=update
    # ... otras configuraciones de Spring Boot
    ```

### Ejecución de la Aplicación

Puedes iniciar la aplicación usando el **Maven Wrapper** incluido:

1.  **Compilar y empaquetar:**
    ```bash
    ./mvnw clean install
    ```
    *(Usa `mvnw.cmd` en Windows)*

2.  **Ejecutar la aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```
    Alternativamente, puedes ejecutar el archivo JAR generado en el directorio `target/`:
    ```bash
    java -jar target/[nombre-del-archivo].jar
    ```

La API estará disponible en `http://localhost:[PUERTO]` (el puerto por defecto es **8080** a menos que se configure en `application.properties`).

---

## 🌐 Endpoints Principales (Ejemplos)

La API proporciona acceso a la gestión de las siguientes entidades:

| Entidad | Controlador Asociado | Endpoints Típicos |
| :--- | :--- | :--- |
| **Jugadores** | `PlayerController` | `/players`, `/players/{id}` |
| **Pagos Mensuales** | `MonthlyPaymentController` | `/payments`, `/payments/{id}` |
| **Categorías** | `CategoryController` | `/categories`, `/categories/{id}` |
| **Disciplinas** | `DisciplineController` | `/disciplines`, `/disciplines/{id}` |
| **Períodos** | `PeriodController` | `/periods`, `/periods/{id}` |
| **Historial de Categoría de Jugador** | `PlayerCategoryHistoryController` | `/player-category-history` |
| **Estados** | `StateController` | `/states`, `/states/{id}` |

### Ejemplo: Obtener todos los Jugadores

**GET** `/players`
**Cuerpo de la Respuesta (Ejemplo):**
```json
{
    "status": "OK",
    "data": [
        {
            "id": 1,
            "name": "Lionel",
            "lastName": "Messi",
        }
    ]
}
