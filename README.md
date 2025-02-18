# **Online University System**

This is a **microservice-based Online University System** built using **Spring Boot**. The system is designed to manage various aspects of university operations, including student and teacher data, clubs, library, authentication, and user management, with a focus on scalability and modularity.

## **Project Modules Overview**

### 1. **eureka-server**
   - **Purpose**: Centralized service discovery for microservices.
   - **Technology**:
     - Spring Cloud Netflix Eureka
   - **Description**: Enables services to register themselves and discover other services dynamically.

---

### 2. **club-server**
   - **Purpose**: Manages club data, including CRUD operations for clubs.
   - **Technology**:
     - Spring Boot
     - Spring Data JPA
     - MySQL
   - **Description**: Allows users to create, read, update, and delete club-related data.

---

### 3. **etudiant-service**
   - **Purpose**: Manages student data, including enrollment and grades.
   - **Technology**:
     - Spring Boot
     - Spring Data JPA
     - MySQL
   - **Description**: Handles student registration, course enrollment, and grade tracking.

---

### 4. **enseignant-service**
   - **Purpose**: Manages teacher data, including course assignments and schedules.
   - **Technology**:
     - Spring Boot
     - Spring Data JPA
     - MySQL
   - **Description**: Allows for managing teacher profiles, course assignments, and scheduling.

---

### 5. **bibliotheque-service**
   - **Purpose**: Manages library data, including books and borrowing information.
   - **Technology**:
     - Spring Boot
     - Spring Data JPA
     - MySQL
   - **Description**: Handles the library's book catalog, borrowing system, and availability.

---

### 6. **user-service**
   - **Purpose**: Manages user authentication and role-based access control.
   - **Technology**:
     - Spring Security
     - Spring Boot
     - JWT (JSON Web Tokens)
   - **Description**: Provides secure login, user registration, and authorization via JWT.

---

### 7. **group-service**
   - **Purpose**: Manages user groups and roles.
   - **Technology**:
     - Spring Boot
     - Spring Security
   - **Description**: Organizes users into groups (e.g., students, teachers, administrators) and assigns roles for access control.

---

### 8. **api-gateway**
   - **Purpose**: Acts as a reverse proxy to route requests to the appropriate microservices, with security filtering.
   - **Technology**:
     - Spring Cloud Gateway
   - **Description**: Routes requests to the relevant microservices, enabling a unified API entry point and managing security.

---

## **Key Technologies**
- **Spring Boot**: Core framework for building backend services.
- **Spring Cloud Eureka**: Provides service discovery for microservices.
- **Spring Cloud Gateway**: Handles API routing and load balancing.
- **Spring Data JPA**: Simplifies database interactions with MySQL.
- **JWT (JSON Web Tokens)**: Handles authentication and authorization for secure, stateless communication.
- **MySQL**: Relational database management system for storing persistent data.

---

## **Architecture Overview**

This project follows a **microservices architecture**, with each module being a standalone service that performs a specific role within the university system. These services communicate via **RESTful APIs**, and Spring Cloud components (such as Eureka and Gateway) manage routing, service discovery, and load balancing.

The system is designed to be **scalable**, with each service being independently deployable and maintainable. The **API Gateway** serves as a single entry point for all external requests, ensuring secure communication with internal services.

---

## **How it Works**

1. **Service Discovery**: The **Eureka Server** acts as a registry for microservices, enabling services to register themselves and discover others.
2. **Authentication & Authorization**: The **User Service** provides secure authentication via **JWT tokens**, while the **Group Service** manages user roles and access control.
3. **Data Management**: Each service (e.g., **Club Service**, **Student Service**, etc.) uses **Spring Data JPA** to interact with the **MySQL** database for storing and retrieving data.
4. **Routing**: The **API Gateway** routes requests to the appropriate service, ensuring that users interact with the system via a unified API endpoint.

---

## **Conclusion**

This **Online University System** project leverages **Spring Boot** and **Spring Cloud** to build a **scalable**, **modular** platform for managing university operations. By using a **microservice architecture**, each aspect of the system is isolated and can be independently scaled, ensuring flexibility and maintainability.

This project offers a robust foundation for university management systems, with room for further expansion to include additional features such as scheduling, notifications, and more.

---

### **Installation**

To set up the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/online-university.git
