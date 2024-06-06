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


## Introduction

This project includes an ATM and a bank management system. Here, we provide the client with an operational demonstration of the banking and ATM systems. Customers who already have an account with any XYZ bank, for example, are eligible to use the ATM. However, if they don't already have an account, they need to open a bank account.

In this project, the bank employee is also included in the interface. Only bank staff have access to this system. Initially, the bank officer uses an authorized username and password to access the bank system. Then, the bank employee verifies their authority to open the client's account.

Using the Bank Management system, bank staff can use basic and necessary information to open a customer's bank account. After that, they can access the most current transactions, make cash withdrawals, deposit money for admission fees, cancel customer accounts, and perform balance inquiries. They can also obtain the number of people who open bank accounts on the current day. In the future, if the customer does not have an email address, they will not be able to update their ATM PIN. Thus, a customer's ATM PIN can be changed by bank employees using KYC.

We have enhanced the functionality of the ATM system to enable users to deposit and withdraw money, check balances, read mini statements, and instantly add funds to their accounts. Similar to the One-Time Password (OTP) program, consumers can safely update their ATM PIN through email verification.

In Java, the front end of the bank management system is designed using `javax.swing.JFrame`. This choice of framework allows for the creation of a user-friendly graphical interface, enabling customers and bank staff to interact with the system seamlessly. The `JFrame` class provides essential functionalities for building windows with various components, such as buttons, labels, and text fields, ensuring an intuitive user experience. Combined with JDBC for backend connectivity and MySQL Workbench for database management, the `JFrame` frontend ensures a comprehensive and efficient banking solution tailored to meet the needs of modern banking operations.

## Bank System

### 1. Welcome Page
![Indian_Bank_Main_Image](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/bf6f4707-65e1-4bff-b677-18836ec05cc2)

### 2. Bank Login Page
![Login-Page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/0d5c41e2-6dab-4736-956c-6c91cd174678)

### 3. Admin Login Page
Only accessible by Bank Employees.
![admin-login-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/39084b99-d759-42dc-912b-fe87a4609317)

### 4. Admin Page
![admin-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/ee4d10e9-75bf-4118-b1e8-0d0b2b12c841)

### 5. Registration Form
Opening Fresh Account By Bank Employee (by clicking the account button in the above image, the below page will appear)
![registration-form](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/e5139d99-480d-4523-a458-b5447e5eae61)

### 6. Customer Personal Detail Page
(by clicking the next button on the above page, the below page will appear)
![custom-personal-detail](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/fab07eee-a23c-4df9-9864-689b7517babc)

### 7. Account Details Page
(by clicking the next button on the above page, the below page will appear)
![account-detail](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/58d61222-32b7-48fe-8602-6b423ea05cf0)

8. The customer must deposit at least 1000 rupees. After clicking the submit button on the above page, the below page will appear.
![cash-deposit-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/fcb90f0b-6068-45b3-88be-3f13d48d2d4a)

### 9. Email Notifications
The customer will receive an email containing account details, including the account number, debit card number, and debit card PIN, after submitting their information.
![email](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/8153084c-6958-4ace-be2e-202b7e156838)

### 10. Accessing Customer Details by the Admin
![user_profile image](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/e4e42e2c-34f0-4353-b27f-49c55dc0763c)

### 11. Cash Withdrawal
![cash-withdrawal-image](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/69222e5a-6d3e-4cd3-8af3-2690ea52a821)

### 12. Customer Information
This displays the number of customers who hold accounts with Indian Bank.
![customer-list](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/53b638b8-b8f2-4e9a-8ecd-4cbfbef5f4c1)

### 13. Transaction Details
![transaction-history](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/fe480727-6980-4277-811b-1160bbfdaafb)

### 14. Cash Deposit
![cash-deposit](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/7f191e40-7796-4f12-ac14-4cecd6555b2d)

### 15. View Balance
![balance-query](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/77ee9a10-ede6-4228-be86-8c9d7590e72a)

### 16. PIN Change
![pin-change (1)](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/fb6be7cf-902e-449c-9dc5-543737c46b60)

### 17. Money Transfer
![money-transfer](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/2dd65277-c2ae-4a97-8871-c03f8a694d37)

### 18. Netbanking: Access by customers
![authentication](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/46ad3ee2-a41b-4b50-b8db-0dc47ad5684f)

### 19. User Account Details
![user-profile](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/4d5bb8cf-e666-4eb5-9540-0cba3fb1f12a)

### 20. Money Transfer by User
![user-money-transfer](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/8e97e578-21fe-41f6-bb9b-8bf05ef7e448)

### 21. Transaction Details
![user-transaction](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/bcb296e8-5b32-41dc-826e-44fd71a643df)

### 22. Balance Check
![user-balance-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/c6529fa2-7c75-4850-afb8-f9ee277af83a)

### 23. Account Details
![user-account-detail](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/f3f4028d-620d-46a7-a3b6-ebdc28ef7b7b)

## ATM System

### 1. ATM Login Page
![ATM](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/91835d21-5575-4a01-85fd-55ceaa1a4fe4)

### 2. Features of the ATM
![select-transaction](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/8fada643-0514-4660-aed7-42773d4c6f9d)

### 3. Cash Deposit
![deposit-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/52bd14dc-47d6-4a44-93dc-b7cf5af5f8a7)

### 4. Cash Withdrawal
![withdrawal-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/ad08d195-52ed-4c91-bcb3-52978ec3c8ff)

### 5. Balance Inquiry
![balance-query-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/16b5623f-7867-4d4e-8eae-510de474b9d2)

### 6. Mini Statement
![mini-statement](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/65cd563b-54c1-46c2-b331-cc0e1fb93c9e)

### 7. Fast Cash Withdrawal
![fastcash-withdrawal](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/3925f5c6-32f7-4173-930f-f330e9f1bddd)

### 8. PIN Change in ATM
Get email notification like OTP.
![otp page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/e73be02a-c515-458f-bbcd-daac3881a6a5)

### 9. OTP Notification
The customer can modify the debit card's PIN if they input the right OTP.
![otp-verification-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/6b4c1c42-cc97-4d00-9658-2256404bbc9f)

### 10. Set New PIN
![pn-change-page](https://github.com/pratikmalviya24/Bank_And_ATM_Management_System/assets/129980635/3face880-1c6d-49c3-9b50-6d9f70c883f6)

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

```

### Age Validation

```sql
DELIMITER //
CREATE TRIGGER validateAgeTrigger
BEFORE INSERT ON CustomerDetails
FOR EACH ROW
BEGIN
    DECLARE dob_date DATE;
    DECLARE age INT;
    SET dob_date = STR_TO_DATE(NEW.dob, '%d-%M-%Y');
    SET age = TIMESTAMPDIFF(YEAR, dob_date, CURDATE());
    IF age < 18 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Person must be at least 18 years old to create an account.';
    END IF;
END//
DELIMITER ;

```

### Valid email 

```sql
DELIMITER //

CREATE TRIGGER validateEmailFormat
BEFORE INSERT ON CustomerDetails
FOR EACH ROW
BEGIN
    IF NEW.email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid email format.';
    END IF;
END//

```

### Unique PAN Number
```sql
CREATE TRIGGER ensureUniquePanNumber
BEFORE INSERT ON PersonalDetails
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM PersonalDetails WHERE panNumber = NEW.panNumber) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'PAN number must be unique.';
    END IF;
END//

DELIMITER //

```

### Unique Adhar number
```sql
DELIMITER //

CREATE TRIGGER ensureUniqueAadharNumber
BEFORE INSERT ON PersonalDetails
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM PersonalDetails WHERE aadharNumber = NEW.aadharNumber) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Aadhar number must be unique.';
    END IF;
END//

DELIMITER ;
```
## Procedure

## Function

## Information About DateBase - Tables


