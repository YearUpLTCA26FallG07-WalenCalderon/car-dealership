# Car Dealership Inventory Management System

## Description

This project is a console-based car dealership inventory management
application developed in Java.

The application allows dealership employees to search, add, and remove
vehicles while maintaining inventory information in a CSV file.

## Features

- Search vehicles by price range
- Search vehicles by make and model
- Search vehicles by year range
- Search vehicles by color
- Search vehicles by mileage range
- Search vehicles by type
- Display all available vehicles
- Add new vehicles
- Remove existing vehicles
- Automatically save inventory changes

## Technologies

- Java 17
- Object-Oriented Programming
- Maven project structure
- CSV file handling
- Java Collections
- BigDecimal

## Project Architecture

### Vehicle
Represents an individual vehicle and its information.

### Dealership
Manages the dealership's vehicle inventory and search operations.

### DealershipFileManager
Handles loading and saving dealership information.

### UserInterface
Manages the console interface and user interactions.

### Console
Provides helper methods for reading and validating user input.

### Program
Contains the main method and starts the application.

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java 17 or later is configured.
4. Ensure `src/main/resources/inventory.csv` exists.
5. Run the `Program` class.
6. Select an option from the console menu.

## Author

Walen Calderon Pimentel

Year Up United — Software Development
