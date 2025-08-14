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

