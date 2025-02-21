# Banking System Project

Welcome to the Banking System project! This Java-based application facilitates managing user accounts, performing transactions, and securing financial data.

## Introduction

This project includes two main components: an ATM system and a bank management system. The ATM system allows customers to perform banking operations, while the bank management system enables bank staff to manage accounts and transactions.

### Features

- **Bank Management System**:
  - Accessible by bank employees with authorized credentials.
  - Allows account creation, transaction processing (withdrawals, deposits), account cancellations, balance inquiries, and daily account statistics.
  - ATM PINs can be updated via KYC if the customer has an email address.

- **ATM System**:
  - Functions include depositing and withdrawing money, checking balances, and reading mini statements.
  - Secure ATM PIN updates via email verification.

## Technical Implementation

### Frameworks and Technologies

- **Frontend**: `javax.swing.JFrame` and `ActionListener` for creating a user-friendly graphical interface.
- **Backend**: JDBC (Java Database Connectivity) for connecting and interacting with the database.
- **Database**: MySQL Server with MySQL Workbench for database management and development.

### System Requirements

- **Java**: Required for running the application and its components.
- **MySQL Server**: Used for relational database management.
- **MySQL Workbench**: Used for designing, managing, and administering the database.


## Information About DateBase - Tables


### Banking Database Schema

This repository contains the schema design for a banking database. The database is designed to manage customer information, personal details, accounts, transactions, cards, and balances.




### Tables

### 1. CustomerDetails

- **mobile_number**: Primary key representing the customer's mobile number.
- **Form no**: Form number (possibly related to account opening).
- **name**, **father_name**, **mother_name**: Customer's personal details.
- **dob**: Date of birth.
- **gender**: Gender (e.g., "Male" or "Female").
- **email**: Customer's email address.
- **marital_status**: Marital status (e.g., "Single" or "Married").
- **address**, **city**, **state**, **pin_code**: Customer's address details.

### 2. PersonalDetails

- **mobile_number**: Foreign key referencing the CustomerDetails table.
- **religion**: Customer's religion.
- **category**: Category (e.g., "General," "OBC," etc.).
- **income**: Customer's income (in rupees).
- **education**: Educational qualification.
- **occupation**: Customer's occupation.
- **panNumber**: PAN card number.
- **aadharNumber**: Primary key representing the Aadhar card number.
- **existing_accounts**: Indicates if the customer has an existing account.
- **senior citizen**: Indicates if the customer is a senior citizen.

### 3. Account

- **mobileNumber**: Foreign key referencing the CustomerDetails table.
- **accountType**: Type of account (e.g., "Savings," "Current," etc.).
- **accountNumber**: Primary key representing the account number.
- **cardNumber**: Associated card number (e.g., debit/credit card).
- **pinNumber**: PIN number for the card.
- **services**: Additional services associated with the account.

### 4. Transaction

- **mobileNumber**: Foreign key referencing the CustomerDetails table.
- **date**: Transaction date.
- **type**: Transaction type (e.g., "Deposit," "Withdrawal," etc.).
- **amount**: Transaction amount (in rupees).

### 5. Card

- **mobileNumber**: Foreign key referencing the CustomerDetails table.
- **cardNumber**: Primary key representing the card number.
- **pinNumber**: PIN number for the card.

### 6. Balance

- **accountNumber**: Primary key representing the account number.
- **balance**: Current account balance (in rupees).

### Usage

This schema can be used to create a relational database for banking systems. Each table represents a different aspect of customer information, accounts, transactions, and card details. 

## Learn More About the Project

To delve deeper into the details of our project, please refer to the [project documentation](https://docs.google.com/document/d/1-xLphTINkxtMgr1tN2R1wFHGWFNcx4YexxIl0P86bAk/edit?usp=sharing).


