# 🎯 Online Quiz Application (Java + MySQL)

## 📌 Project Overview

The Online Quiz Application is a desktop-based Java application developed using Swing and MySQL. It allows users to securely log in, attempt multiple-choice quizzes, and receive instant results with score analysis. The application demonstrates core Java concepts, GUI development, database integration, and event-driven programming.

---

## 🚀 Features

* 🔐 User Authentication (Login System)
* 🧠 Multiple Choice Questions (MCQs)
* ⏱️ Timer for Each Question
* 📊 Real-time Score Calculation
* 📈 Result Analysis (Percentage & Pass/Fail)
* 💾 MySQL Database Integration
* 🖥️ Interactive GUI using Java Swing

---

## 🛠️ Tech Stack

* **Language:** Java
* **Frontend:** Java Swing (GUI)
* **Backend Logic:** Core Java (OOP, Event Handling)
* **Database:** MySQL
* **Connectivity:** JDBC

---

## 🏗️ Project Structure

```
QuizApp/
│
├── DBConnection.java
├── Login.java
├── Question.java
├── QuizApp.java
```

---

## 🗄️ Database Setup

Run the following SQL queries in MySQL:

```sql
CREATE DATABASE quiz_app;

USE quiz_app;

CREATE TABLE users (
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users VALUES ('babu', '1234');

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    score INT
);
```

---

## ▶️ How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/your-username/quiz-app.git
```

2. Navigate to project folder:

```bash
cd QuizApp
```

3. Compile the project:

```bash
javac *.java
```

4. Run the application:

```bash
java Login
```

---

## 🎯 Learning Outcomes

* Understanding of Java Swing GUI development
* Hands-on experience with JDBC and MySQL
* Implementation of OOP principles
* Event-driven programming in Java
* Building real-world desktop applications

---

## 📸 Screenshots

<img width="478" height="426" alt="Screenshot 2026-04-15 225245" src="https://github.com/user-attachments/assets/6831f3ec-e964-4297-819e-d02736bab976" />



---

## 🔥 Future Enhancements

* 🌐 Convert to Web Application using Spring Boot
* 🔐 Secure authentication (JWT)
* 📊 Admin Dashboard for managing questions
* 🎨 Improved UI/UX design
* 📱 Mobile-friendly version

---

## 👨‍💻 Author

**Babu**
Aspiring Software Developer | Java & Machine Learning Enthusiast

---

## ⭐ If you like this project

Give it a ⭐ on GitHub and share your feedback!
