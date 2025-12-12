# API - Club Management System

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

> **RESTful API** designed for the comprehensive administration of sports institutions, managing member lifecycles, treasury, and sports categorization.

## 📖 Project Description

This backend solution was developed to address payment management and player tracking challenges for **Club Buen Orden F.C.** It provides a robust architecture to handle administrative business logic, enabling historical control of categories and detailed recording of monthly fees.

## ✨ Key Features

* **Member/Player Management:** Complete CRUD (Create, Read, Update, Delete) for profiles.
* **Treasury Control:** Registration of monthly payments, debt tracking, and account statement generation.
* **Sports History:** Tracking of player evolution across different categories and disciplines.
* **Scalable Architecture:** Modular design based on layers (Controller, Service, Repository), ready for future frontend integrations.

## 🛠️ Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 3+
* **Persistence:** Spring Data JPA & Hibernate
* **Database:** MySQL / H2 (Test environments)
* **Build Tool:** Maven

## 🚀 Installation & Execution

### Prerequisites
* Java JDK 17 or higher.
* Maven (Optional, Wrapper included).
* MySQL Server (Optional for production).

### Steps

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/AgusRios2004/apiBuenOrden.git](https://github.com/AgusRios2004/apiBuenOrden.git)
    cd api-buen-orden
    ```

2.  **Configure Database:**
    Edit `src/main/resources/application.properties`.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/buen_orden_db
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

The API will start at: `http://localhost:8080`

---

## 🔌 Endpoints Documentation

| Module | Method | Endpoint | Description |
| :--- | :---: | :--- | :--- |
| **Players** | `GET` | `/players` | List all active players. |
| | `POST` | `/players` | Register a new player. |
| **Payments** | `POST` | `/payments` | Register a fee payment. |
| | `GET` | `/payments/player/{id}` | View player payment history. |
| **Categories** | `PUT` | `/categories/{id}` | Update category information. |

> **Note:** Using **Postman** or **Insomnia** is recommended for testing requests.

## 👤 Author

**Agustín Rios** - *Backend Developer*
* [LinkedIn](https://www.linkedin.com/in/agustin-rios)
* [GitHub Profile](https://github.com/AgusRios2004)

---
*Developed with ❤️ for efficient sports management.*
