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

### Admin Login Page
```sql
CREATE PROCEDURE AdminLogin(
    IN adminID_in VARCHAR(30),
    IN password_in VARCHAR(30)
)
BEGIN
    DECLARE count INT;
    SELECT COUNT(*) INTO count FROM admin WHERE adminID = adminID_in AND password = password_in;
    IF count = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid admin credentials.';
    END IF;
END //

DELIMITER ;


```

### Update PIN Number
```sql
CREATE PROCEDURE UpdatePinNumber(
    IN card_number_in VARCHAR(20),
    IN new_pin_number VARCHAR(10)
)
BEGIN
    UPDATE Card SET pinNumber = new_pin_number WHERE cardNumber = card_number_in;
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Pin  Changed Successfully';
END //

DELIMITER ;


```

###  Transfer Amount

```sql
DELIMITER //

CREATE PROCEDURE TransferAmount(
    IN fromAccount VARCHAR(20), 
    IN toAccount VARCHAR(20), 
    IN amount BIGINT
)
BEGIN
    -- Update balance for the source account
    UPDATE Balance 
    SET balance = balance - amount
    WHERE accountNumber = fromAccount;

    -- Update balance for the destination account
    UPDATE Balance 
    SET balance = balance + amount
    WHERE accountNumber = toAccount;
    
    
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Money Transfer Successfully!';
END //


```


### Update Account balance
```sql
DELIMITER //

CREATE PROCEDURE UpdateAccountBalance(
    IN account_number_in VARCHAR(20),
    IN transaction_amount DECIMAL(20, 2)
)
BEGIN
    UPDATE Balance SET balance = balance + transaction_amount WHERE accountNumber = account_number_in;
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You Money Deposited Successfully';
END //

DELIMITER ;


```


### Update customer Details
```sql
CREATE PROCEDURE UpdateCustomerDetails(
    IN mobile_number VARCHAR(20), 
    IN name VARCHAR(40),
    IN dob VARCHAR(20),
    IN email VARCHAR(50),
    IN address VARCHAR(200)
)
BEGIN
    UPDATE CustomerDetails 
    SET 
        name = name,
        dob = dob,
        email = email,
        address = address
    WHERE 
        mobile_number = mobile_number;
END //


```

### Insert Customer Details
```sql
DELIMITER //

CREATE PROCEDURE InsertCustomerDetails(
    IN p_mobile_number VARCHAR(10), 
    IN p_formno INT,
    IN p_name VARCHAR(40),
    IN p_father_name VARCHAR(40),
    IN p_mother_name VARCHAR(40),
    IN p_dob DATE,
    IN p_gender VARCHAR(10),
    IN p_email VARCHAR(50),
    IN p_marital_status VARCHAR(10), 
    IN p_address VARCHAR(200),
    IN p_city VARCHAR(20),
    IN p_state VARCHAR(20),
    IN p_pin_code INT
)
BEGIN
    INSERT INTO CustomerDetails (
        mobile_number, formno, name, father_name, mother_name, dob, gender, 
        email, marital_status, address, city, state, pin_code
    ) VALUES (
        p_mobile_number, p_formno, p_name, p_father_name, p_mother_name, p_dob, p_gender, 
        p_email, p_marital_status, p_address, p_city, p_state, p_pin_code
    );
END //

DELIMITER ;


```

### Insert account
```sql
CREATE PROCEDURE InsertAccount(
    IN p_mobileNumber VARCHAR(10),
    IN p_accountType VARCHAR(20),
    IN p_accountNumber VARCHAR(20),
    IN p_cardNumber VARCHAR(20),
    IN p_pinNumber VARCHAR(10),
    IN p_services VARCHAR(200)
)
BEGIN
    INSERT INTO Account (
        mobileNumber, accountType, accountNumber, cardNumber, pinNumber, services
    ) VALUES (
        p_mobileNumber, p_accountType, p_accountNumber, p_cardNumber, p_pinNumber, p_services
    );
END //


```

### Insert card
```sql
CREATE PROCEDURE InsertCard(
    IN p_mobileNumber VARCHAR(10),
    IN p_cardNumber VARCHAR(20),
    IN p_pinNumber VARCHAR(10)
)
BEGIN
    INSERT INTO Card (
        mobileNumber, cardNumber, pinNumber
    ) VALUES (
        p_mobileNumber, p_cardNumber, p_pinNumber
    );

END //


```

### Add Transaction Detail:
```sql
CREATE PROCEDURE AddTransaction(
    IN mobileNumber VARCHAR(15),
    IN date DATE,
    IN type VARCHAR(20),
    IN amount float8
)
BEGIN
    INSERT INTO Transaction VALUES (
        mobileNumber, date, type, amount
    );
END //


```

###  Update Personal Detail:

```sql
CREATE PROCEDURE UpdatePersonalDetails(
    IN mobile_number VARCHAR(20),
    IN religion VARCHAR(20),
    IN category VARCHAR(20),,
    IN education VARCHAR(20),
    IN occupation VARCHAR(40),
    IN panNumber VARCHAR(20),
    IN aadharNumber VARCHAR(50),
    IN existingAccount VARCHAR(20),
    IN seniorCitizen VARCHAR(20)
)
BEGIN
    UPDATE PersonalDetails 
    SET 
        religion = religion,
        category = category,
        education = education,
        occupation = occupation,
        panNumber = panNumber,
        existingAccount = existingAccount,
        seniorCitizen = seniorCitizen
    WHERE 
        mobile_number = mobile_number;
END //


```
## Function

### Generate account number

```sql
DELIMITER //

CREATE FUNCTION GenerateAccountNumber()
RETURNS VARCHAR(20)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE account_number VARCHAR(20);
    SET account_number = CONCAT('ACC-', LPAD(CONVERT(FLOOR(RAND() * 1000000000), CHAR), 10, '0'));
    RETURN account_number;
END //

DELIMITER ;
```

### Generate card number
```sql
DELIMITER //

CREATE FUNCTION GenerateCardNumber()
RETURNS VARCHAR(20)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE card_number VARCHAR(20);
    SET card_number = CONCAT('CARD-', LPAD(CONVERT(FLOOR(RAND() * 1000000000), CHAR), 10, '0'));
    RETURN card_number;
END //

DELIMITER ;
```




### Get account Balance
```sql
DELIMITER //
CREATE FUNCTION GetAccountBalance(
    accountNumber_in VARCHAR(20)
)
RETURNS DECIMAL(20, 2)
DETERMINISTIC
BEGIN
    DECLARE balance DECIMAL(20, 2);
    SELECT balance INTO balance FROM Balance WHERE accountNumber = accountNumber_in;
    RETURN balance;
END //

DELIMITER //
```


### Is Account exist:
```sql
CREATE FUNCTION IsAccountExist(
    p_accountNumber VARCHAR(20)
) RETURNS BOOLEAN
BEGIN
    DECLARE account_exist BOOLEAN;
    SELECT IF(COUNT(*) > 0, TRUE, FALSE) INTO account_exist FROM Account WHERE accountNumber = p_accountNumber;
    RETURN account_exist;
END;

```

### Verify card validity:

```sql
CREATE FUNCTION VerifyCardValidity(
    p_cardNumber VARCHAR(20),
    p_pinNumber VARCHAR(10)
) RETURNS BOOLEAN
BEGIN
    DECLARE card_valid BOOLEAN;
    SELECT IF(COUNT(*) > 0, TRUE, FALSE) INTO card_valid FROM Card 
    WHERE cardNumber = p_cardNumber AND pinNumber = p_pinNumber;
    RETURN card_valid;
END;
```

### Add balance:

```sql
CREATE FUNCTION AddBalance(
    p_accountNumber VARCHAR(20),
    p_amount BIGINT
) RETURNS BOOLEAN
BEGIN
    DECLARE balance_added BOOLEAN DEFAULT FALSE;
    UPDATE Balance SET balance = balance + p_amount WHERE accountNumber = p_accountNumber;
    SET balance_added = TRUE;
    RETURN balance_added;
END;
```

### Get Transection history 
```sql
CREATE FUNCTION GetTransactionHistory(
   		 p_accountNumber VARCHAR(20),
    		p_limit INT
) RETURNS TABLE (
   			 transactionID INT,
   			 mobileNumber VARCHAR(10),
   			 date DATE,
   			 type VARCHAR(20),
   			 amount BIGINT
)
BEGIN
    RETURN (
        SELECT transactionID, mobileNumber, date, type, amount
        FROM Transaction
        WHERE accountNumber = p_accountNumber
        ORDER BY date DESC
        LIMIT p_limit
    );
END;
```

### Get Card Details
```sql
CREATE FUNCTION GetCardDetails(accountNumber VARCHAR(20))
RETURNS TABLE (
    cardNumber VARCHAR(20),
    pinNumber VARCHAR(10)
)
BEGIN
    RETURN (
        SELECT cardNumber, pinNumber
        FROM Card
        WHERE accountNumber = accountNumber
    );
END //
```

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


