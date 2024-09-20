# Banking Management System

### Overview
The **Banking Management System** is a full-stack Java application designed to manage core banking functions such as customer accounts, transactions, loans, and credit management. The system enables banks or financial institutions to handle daily transactions and account activities efficiently and securely.

### Features
- **Customer Management**: Add, update, and view customer information.
- **Account Management**: Create accounts, deposit funds, and withdraw money.
- **Transaction Management**: Track deposits and withdrawals, with a detailed transaction history for each account.
- **Loan Management**: Apply for loans, track loan status, and calculate loan interest.
- **Secure Transactions**: Prevent over-withdrawal and manage funds securely.

### Technologies Used
- **Java**: Core programming language for backend logic.
- **JDBC**: Java Database Connectivity for connecting and interacting with the MySQL database.
- **MySQL**: Relational database to store customer, account, and transaction data.
- **JavaFX**: Frontend framework for building the user interface.
- **Spring (Optional)**: Can be used to build a more advanced UI with REST APIs.
- **Maven**: For project dependency management.

### Database Schema
1. **Customers Table**: Stores customer information like name, email, phone, and address.
2. **Accounts Table**: Stores details of customer accounts, including balance and account type.
3. **Transactions Table**: Records all account transactions (deposits, withdrawals).
4. **Loans Table**: Manages loan details for customers including amount, interest rate, and duration.

