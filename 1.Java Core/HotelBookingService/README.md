# Hotel Booking Service

A Java-based console application that simulates a hotel booking system. The application allows users to create clients, hotels with rooms, and book rooms based on capacity and availability.

## Features

- Create clients with personal information and initial balance
- Create hotels with randomly generated rooms (different capacities and prices)
- Book rooms based on required capacity
- View all clients and their balances
- View all hotels and their available rooms
- Handle payment processing for bookings

## Architecture

The application follows a simple layered architecture:

### Model Layer
- `Client`: Represents a client with personal details and a bill
- `Hotel`: Represents a hotel with a collection of rooms
- `Room`: Represents a room with capacity, price, and availability status
- `Bill`: Represents a financial account with balance management

### Repository Layer
- `ClientRepository`: Manages client data storage and retrieval
- `HotelRepository`: Manages hotel data storage and retrieval

### Service Layer
- `ClientService`: Handles client-related business logic
- `HotelService`: Handles hotel-related business logic
- `BookingService`: Handles room booking logic and payment processing

## How to Run

1. Ensure you have Java 21+ and Maven installed on your system
2. Clone or download this repository
3. Navigate to the project directory
4. Compile and run using Maven:
   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="org.javacourse.Main"
   ```
   
   Or compile and run directly:
   ```bash
   mvn compile
   mvn exec:java
   ```

## Usage

The application provides a console-based menu system:

1. **Create client**: Add a new client with first name, last name, phone number, email, and initial balance
2. **Create hotel with random rooms**: Create a hotel with a specified number of rooms (each with random capacity and price)
3. **Book a room**: Book an available room in a hotel that meets the required capacity
4. **Show all clients**: Display all registered clients and their balances
5. **Show all hotels**: Display all hotels with their rooms and availability
6. **Exit**: Close the application

## Business Logic

- Rooms have random capacities (1-4 people) and prices ($50-$200)
- Clients must have sufficient balance to book a room
- Room availability is tracked and updated when booked
- Payment is automatically processed when a room is booked

## Project Structure

```
src/
├── main/
│   └── java/
│       └── org/
│           └── javacourse/
│               ├── Main.java
│               ├── model/
│               │   ├── Bill.java
│               │   ├── Client.java
│               │   ├── Hotel.java
│               │   └── Room.java
│               ├── repository/
│               │   ├── ClientRepository.java
│               │   └── HotelRepository.java
│               └── service/
│                   ├── BookingService.java
│                   ├── ClientService.java
│                   └── HotelService.java
```

## Dependencies

- Java 21+
- Maven 3.x

No external libraries are required for this project.

## Design Patterns

- Repository Pattern: For data access and storage
- Service Layer Pattern: For business logic implementation
- Simple Dependency Injection: Services receive their dependencies through constructors