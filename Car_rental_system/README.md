# Car Rental System

This mini-project is a simple Car Rental System implemented in Java. It demonstrates object-oriented programming concepts such as encapsulation, constructors, copy constructors, and class interactions.

## Project Structure

- [`Car.java`](Car_rental_system/Car.java): Represents a car with properties like ID, type, brand, and gear type.
- [`Date.java`](Car_rental_system/Date.java): Handles date operations, including validation, comparison, and date arithmetic.
- [`Rent.java`](Car_rental_system/Rent.java): Represents a car rental, including customer name, car, pickup and return dates, and price calculation.

## Features

- **Car Management:** Create and manage car objects with validation for ID and type.
- **Date Handling:** Validate dates, compare dates, and calculate differences between dates.
- **Rental Management:** Create rental records, calculate rental prices with discounts, handle upgrades, and check for overlapping rentals.

## Usage

1. **Compile the Java files:**
   ```sh
   javac Car.java Date.java Rent.java