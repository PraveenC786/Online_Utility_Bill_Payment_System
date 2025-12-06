# 🚀 Online Utility Bill Payment -- Backend (Spring Boot)

![Backend](https://img.shields.io/badge/Backend-SpringBoot-brightgreen)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-orange)
![Java](https://img.shields.io/badge/Java-17-orange)
![JPA](https://img.shields.io/badge/Spring-DataJPA-yellow) 
![REST API](https://img.shields.io/badge/API-REST-orange)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Postman](https://img.shields.io/badge/API_Testing-Postman-critical)
![Maven](https://img.shields.io/badge/Build-Maven-purple)

A **RESTful backend service** for managing utility bills, payments, and
user accounts.

------------------------------------------------------------------------

## 🎯 Objective
Spring Boot REST backend for enable users to pay bills online efficiently & allow admins to manage bills and track payments.

- Built a RESTful Spring Boot backend with MySQL, Spring Data JPA
- Users can register, view bills, and make payments.
- Admins can generate bills and monitor users, bills, and payments.

------------------------------------------------------------------------

## 🛠️ Technologies Used


| Technology       | Purpose                                |
|------------------|----------------------------------------|
| Java (JDK 17+)   | Programming                            |
| Spring Boot      | Backend Framework                      |
| Spring Data JPA  | ORM                                    |
| Hiberate         |ORM(Internally used by Spring Data JPA) |
| MySQL            | Database                               |
| Maven            | Build Tool                             |
| Postman          | API Testing                            |


------------------------------------------------------------------------

## 🧩 Modules & Functionalities

### 👤 User Module

-   Register a user
-   View profile
-   View user bills
-   View payment history

### 🧾 Bill Module

-   Generate bill (Admin)
-   Get bills by User ID
-   Get bill by Bill ID
-   Get bills by Status
-   Filter bills (User + Status)

### 💳 Payment Module

-   Pay for a bill
-   Payment details for a bill
-   User payment list
-   Admin: All payments

### 🛠 Admin Module

-   Generate bills
-   View all users
-   View all bills
-   View all payments

------------------------------------------------------------------------

## 🏗️ Entities & Relationships

### User

-   id, name, email, phone, address
-   Role: USER / ADMIN
-   One-to-many with Bills

### Bill

-   id, amount, dueDate, status, category
-   Many-to-one with User
-   One-to-one with Payment

### Payment

-   id, amountPaid, paymentDate, status
-   One-to-one with Bill

------------------------------------------------------------------------

## 🔗 REST API Endpoints

### 👤 Users (`/api/users`)

| Method | Endpoint     |
|--------|--------------|
| POST   | /register    |
| GET    | /get?id=1    |
| GET    | /all         |


### 📄 Bills (`/api/bills`)

| Method | Endpoint                           |
|--------|-------------------------------------|
| POST   | /generate?userId=1                  |
| GET    | /byuser?userId=1                    |
| GET    | /bystatus?status=PENDING            |
| GET    | /byid?billId=1                      |
| GET    | /byuserstatus?userId=1&status=PAID  |


### 💰 Payments (`/api/payments`)

| Method | Endpoint            |
|--------|----------------------|
| POST   | /pay?billId=1        |
| GET    | /byuser?userId=1     |
| GET    | /bybill?billId=1     |
| GET    | /all                 |


### 🛠️ Admin (`/api/admin`)

| Method | Endpoint                      |
|--------|--------------------------------|
| POST   | /generatebill?userId=1         |
| GET    | /users                         |
| GET    | /bills                         |
| GET    | /payments                      |


------------------------------------------------------------------------

## ▶️ Project Flow

1.  User registers → `/api/users/register`
2.  Admin generates bill → `/api/admin/generatebill`
3.  User views bills → `/api/bills/byuser`
4.  User pays bill → `/api/payments/pay`
5.  Admin monitors → `/api/admin/*`

------------------------------------------------------------------------

## 🖼 Sample Images 

    ![Postman Screenshot](images/postman.png)
    ![Database Schema](images/schema.png)

------------------------------------------------------------------------

## 📦 Run the Project

### 1. Clone Repo

``` bash
git clone https://github.com/PraveenC786/Online_Utility_Bill_Payment_System.git
```

### 2. Create Database

``` sql
CREATE DATABASE utility_bill_payment;
```

### 3. Configure Properties

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/utility_bill_payment
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### **4. Run the Project**

Deploy on **Tomcat** and visit:

    http://localhost:8080/OnlineUtilityBillPayment

------------------------------------------------------------------------

## 🙋‍♂️ Author

**Praveen C**\
Java Full Stack Developer
