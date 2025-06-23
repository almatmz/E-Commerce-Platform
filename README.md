# Java E-Commerce Simulation

## 📦 Overview

This is a simple Java Object-Oriented Programming (OOP) project that simulates a basic e-commerce platform. It includes core functionalities such as:

- User management (Admin and Customer)
- Product inventory
- Order placement and cancellation
- Stock management

The project demonstrates key OOP principles like inheritance, encapsulation, and polymorphism.

---

## 📁 Project Structure

src/

├── Main.java

├── User.java

├── Admin.java

├── Customer.java

├── Product.java

└── Order.java


---

## 👥 Class Descriptions

### `User` (Base class)
- Common fields: `id`, `name`, `email`
- Method: `displayDetails()`

### `Admin` (extends `User`)
- Can manage products (e.g., add, update stock, view products)

### `Customer` (extends `User`)
- Can place and cancel orders
- Stores order history and shipping address

### `Product`
- Fields: `id`, `name`, `price`, `stock`
- Methods: Getters/setters for inventory management

### `Order`
- Links a `Customer` and a `Product`
- Contains quantity and payment method

---

## 🚀 How to Run

1. **Compile the code** (make sure all files are in the same `src/` directory):
   ```bash
    javac *.java
Run the program:

java Main


🧪 Features
Admin can:

Add and manage products

View product inventory

Customer can:

Place orders (with stock check)

Cancel orders (returns stock)

View personal details and order history



📚 OOP Concepts Used
Inheritance (Admin and Customer inherit from User)

Encapsulation (use of getters/setters)

Polymorphism (overriding displayDetails())

Composition (Order has Product and Customer references)

📌 Notes
This is a console-based simulation.

No external libraries or GUI used.

Designed for educational purposes to demonstrate OOP in Java.
