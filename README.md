# Banking and ATM Management System

## Index
1. [Introduction](#introduction)
2. [Bank System](#bank-system)
3. [ATM System](#atm-system)
4. [Framework and System Requirements](#framework-and-system-requirements)
5. [Trigger](#trigger)
6. [Procedure](#procedure)
7. [Function](#function)
8. [Information About Tables](#information-about-tables)
9. [ER Diagram](#er-diagram)
10. [EER Diagram](#eer-diagram)
11. [Database Connection](#database-connection)

## Introduction

This project includes an ATM and a bank management system. Here, we provide the client with an operational demonstration of the banking and ATM systems. Customers who already have an account with any XYZ bank, for example, are eligible to use the ATM. However, if they don't already have an account, they need to open a bank account.

In this project, the bank employee is also included in the interface. Only bank staff have access to this system. Initially, the bank officer uses an authorized username and password to access the bank system. Then, the bank employee verifies their authority to open the client's account.

Using the Bank Management system, bank staff can use basic and necessary information to open a customer's bank account. After that, they can access the most current transactions, make cash withdrawals, deposit money for admission fees, cancel customer accounts, and perform balance inquiries. They can also obtain the number of people who open bank accounts on the current day. In the future, if the customer does not have an email address, they will not be able to update their ATM PIN. Thus, a customer's ATM PIN can be changed by bank employees using KYC.

We have enhanced the functionality of the ATM system to enable users to deposit and withdraw money, check balances, read mini statements, and instantly add funds to their accounts. Similar to the One-Time Password (OTP) program, consumers can safely update their ATM PIN through email verification.

In Java, the front end of the bank management system is designed using `javax.swing.JFrame`. This choice of framework allows for the creation of a user-friendly graphical interface, enabling customers and bank staff to interact with the system seamlessly. The `JFrame` class provides essential functionalities for building windows with various components, such as buttons, labels, and text fields, ensuring an intuitive user experience. Combined with JDBC for backend connectivity and MySQL Workbench for database management, the `JFrame` frontend ensures a comprehensive and efficient banking solution tailored to meet the needs of modern banking operations.

## Bank System

### 1. Welcome Page
![Indian_Bank_Main_Image](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/bf6f4707-65e1-4bff-b677-18836ec05cc2)

### Bank Login Page

### Admin Login Page
Only accessible by Bank Employees.

### Admin Page

### Registration Form
Opening Fresh Account By Bank Employee (by clicking the account button in the above image, the below page will appear)

### Customer Personal Detail Page
(by clicking the next button on the above page, the below page will appear)

### Account Details Page
(by clicking the next button on the above page, the below page will appear)

The customer must deposit at least 1000 rupees. After clicking the submit button on the above page, the below page will appear.

### Email Notifications
The customer will receive an email containing account details, including the account number, debit card number, and debit card PIN, after submitting their information.

### Accessing Customer Details by the Admin

### Cash Withdrawal

### Customer Information
This displays the number of customers who hold accounts with Indian Bank.

### Transaction Details

### Cash Deposit

### View Balance

### PIN Change

### Money Transfer

### Netbanking: Access by customers

### User Account Details

### Money Transfer by User

### Transaction Details

### Balance Check

### Account Details

## ATM System

### ATM Login Page

### Features of the ATM

### Cash Deposit

### Cash Withdrawal

### Balance Inquiry

### Mini Statement

### Fast Cash Withdrawal

### PIN Change in ATM
Get email notification like OTP.

### OTP Notification
The customer can modify the debit card's PIN if they input the right OTP.

### Set New PIN

## Framework and System Requirements

### Used Framework

During the project development, we focused on creating a user-friendly frontend interface using `javax.swing.JFrame` and `ActionListener` in Java. The `javax.swing.JFrame` class provided the foundation for building windows and graphical user interfaces (GUIs), allowing us to design interactive screens for users to interact with the system. Additionally, `ActionListener` was employed to handle user actions such as button clicks, enabling dynamic responses to user input and enhancing the overall user experience.

We used the JDBC (Java Database Connectivity) API on the backend to connect to and communicate with the MySQL database server. The JDBC standardized the interface via which Java programs may access databases, facilitating the smooth integration of our project's frontend and backend elements. We were able to access and modify data, run SQL queries, and guarantee data integrity and consistency within the MySQL database by using JDBC.

For database management, we utilized MySQL Server as our relational database management system (RDBMS), chosen for its reliability, performance, and robust feature set. MySQL Workbench, an integrated development environment (IDE) specifically designed for MySQL, served as our primary tool for database administration and development tasks. MySQL Workbench offered a range of features, including database design, SQL development, and database administration, enabling us to efficiently design, implement, and manage the database schema and data.

### Framework and System Requirements

Our project utilizes various Java libraries like `jcalender-tz-1.3.3-4.jar`, `mysql-connector-java-8.0.28.jar`, `JTattoo-1.6.11.jar`, and `mail-1.4.7.jar`, among others. These provide essential functionalities such as date/time management, database connectivity, UI customization, and email communication.

### System Requirements

- Apache NetBeans IDE 17
- MySQL Workbench 8.0 CE
- MySQL Server 8.0
- MySQL Router 8.0
- Java Development Kit (JDK) version 8 or higher

A MySQL database server is necessary for data retrieval and storage, as well as the right configuration parameters to meet the needs of the application.

## Trigger

### Account Number Exist or Not

```sql
DELIMITER //

CREATE TRIGGER isAccountExistTrigger
BEFORE INSERT ON CustomerDetails
FOR EACH ROW
BEGIN
    DECLARE i INT;
    SET i = 0;
    SELECT COUNT(*) INTO i FROM CustomerDetails WHERE mobile_number = NEW.mobile_number;
    IF i > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Account with this mobile number already exists.';
    END IF;
END//

DELIMITER ;
