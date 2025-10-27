# Banking System - Java OOP Practice

## Overview

This project is a comprehensive Object-Oriented Programming (OOP) practice implementation of a banking system. It demonstrates core OOP principles, data persistence with JPA/Hibernate, and follows clean architectural patterns for financial operations.

## Features

- **Account Management**: Create and manage bank accounts with personal information
- **Financial Operations**: Deposit, withdraw, and transfer funds between accounts
- **Transaction Tracking**: Complete audit trail with deposits and payments recorded
- **Data Persistence**: SQLite database integration with automatic schema management
- **Safety Checks**: Validation for negative amounts, insufficient funds, and invalid operations

## Architecture

### Core Entities

- **Person**: Customer information (first name, last name, phone number)
- **Bill**: Financial account balance with deposit/withdraw methods
- **Account**: Links Person and Bill entities together
- **Deposit**: Records deposit transactions with timestamp
- **Payment**: Records payment transactions with timestamp

### Service Layer

- **DepositService**: Handles deposit operations and persistence
- **PaymentService**: Manages payment transactions with validation
- **TransferService**: Facilitates secure fund transfers between accounts

### Technology Stack

- **Java 21**: Modern Java features and syntax
- **JPA 3.1**: Standardized persistence API
- **Hibernate 6.5.0**: ORM framework for database operations
- **SQLite**: Lightweight embedded database
- **Maven**: Build automation and dependency management

## Database Schema

The application uses an SQLite database (`bank.db`) with automatic schema generation through Hibernate's `hbm2ddl.auto=update` setting.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6.0 or higher

### Building and Running

1. Clone the repository
2. Navigate to the project directory
3. Build the project: `mvn clean compile`
4. Run the application: `mvn exec:java -Dexec.mainClass="org.javacourse.Main"`

### Interactive Menu

The application provides an interactive console interface:

- **Create Account**: Register new customer accounts with initial balance
- **Show Accounts**: Display all accounts with customer information and balances
- **Deposit**: Add funds to a specific account
- **Pay**: Withdraw funds from an account
- **Transfer**: Move funds between two accounts
- **Exit**: Close the application

## Design Patterns

- **Service Layer Pattern**: Business logic is separated from the presentation layer
- **Data Access Object (DAO)**: JPA EntityManager handles all database operations
- **Dependency Injection**: Services receive EntityManager through constructor injection
- **Entity Relationship Mapping**: JPA annotations define relationships between domain objects

## Security & Validation

- Negative amounts are rejected in all financial operations
- Insufficient funds validation prevents overdrafts
- Input validation for account IDs and amounts
- Transaction safety through database transactions

## Project Structure

```
src/
├── main/
│   ├── java/org/javacourse/
│   │   ├── model/          # Entity classes
│   │   ├── service/        # Business logic services
│   │   └── Main.java       # Application entry point
│   └── resources/
│       └── META-INF/
│           └── persistence.xml  # JPA configuration
```

## Use Cases

1. **Customer Registration**: Create new accounts with personal details and initial deposit
2. **Balance Management**: Safely add, remove, or transfer funds with validation
3. **Transaction History**: Track all financial operations with timestamps
4. **Account Inquiry**: View all accounts and their current balances

## Error Handling

The system includes comprehensive error handling for:
- Invalid account IDs
- Insufficient funds during payments or transfers
- Negative amounts in transactions
- Malformed input in the console interface

## Learning Objectives

This project demonstrates:
- Object-Oriented Programming principles (encapsulation, inheritance, polymorphism)
- JPA/Hibernate integration for database persistence
- Service-oriented architecture
- Input validation and error handling
- Financial transaction processing
- Console-based user interface design

## Future Enhancements

Potential improvements could include:
- Password-protected accounts
- Interest calculation
- Transaction history queries
- Email notifications
- Web-based user interface