# Library Management System

A Spring Boot-based Library Management System with secure user authentication, book management, and comprehensive library operations.

## 🚀 Features

- *User Management*
  - Secure authentication and authorization
  - Role-based access (Admin, Librarian, Member)
  - User profile management

- *Book Management*
  - Add, update, and delete books
  - Book categorization and search
  - Book availability tracking
  - ISBN validation

- *Borrowing System*
  - Book checkout and return
  - Due date management
  - Fine calculation
  - Reservation system

- *Reporting & Analytics*
  - Borrowing statistics
  - Member activity reports
  - Book popularity metrics
  - Fine collection reports

## 🛠 Tech Stack

- *Backend:* Spring Boot 3.4.4
- *Security:* Spring Security
- *Database:* MySQL
- *Build Tool:* Maven
- *Java Version:* 17

## 📋 Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher
- IDE (Eclipse, IntelliJ IDEA, or VS Code)

## 🔧 Installation & Setup

1. *Clone the repository*
   ```bash
   git clone [repository-url]
   cd librarysystem
   ```

2. *Configure MySQL*
   - Create a new database
   ```sql
   CREATE DATABASE library_db;
   ```
   - Update application.properties with your database credentials

3. *Build and Run*
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. *Access the application*
   ```
   http://localhost:8080
   ```

## 🔑 API Endpoints

### Authentication
- POST /api/auth/register - Register new user
- POST /api/auth/login - User login

### Books
- GET /api/books - List all books
- POST /api/books - Add new book
- PUT /api/books/{id} - Update book
- DELETE /api/books/{id} - Delete book
- GET /api/books/search - Search books

### Members
- GET /api/members - List all members
- POST /api/members - Add new member
- PUT /api/members/{id} - Update member
- DELETE /api/members/{id} - Delete member

### Borrowing
- POST /api/borrow - Borrow a book
- POST /api/return - Return a book
- GET /api/borrow/history - View borrowing history
- GET /api/borrow/current - View current borrowings

## 🔐 Security

- JWT-based authentication
- Password encryption using BCrypt
- Role-based access control
- Session management
- CSRF protection

## 📝 Database Schema

The system uses the following main entities:
- Users
- Books
- Members
- Borrowings
- Fines
- Categories

## 📚 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/library/librarysystem/
│   │       ├── controllers/
│   │       ├── models/
│   │       ├── repositories/
│   │       ├── services/
│   │       ├── security/
│   │       └── LibrarysystemApplication.java
│   └── resources/
│       └── application.properties
└── test/
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Thank You

Thank you for exploring the Library Management System. Your feedback and contributions are always welcome! 