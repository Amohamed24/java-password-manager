# 🔐 Password Manager

A beginner-friendly console-based Java application for managing and testing passwords with basic file handling support.

## 🧠 What It Does
- Save passwords for different websites
- Test the strength of a given password
- Prevent weak or duplicate passwords
- List and delete saved passwords
- Read from and write to a file (passwords.txt)
- Persistent storage via file system

## 🚀 Features
- Uses a `Password` class for modeling site-password pairs
- Uses a `User` class to prevent use of personal info as password
- Uses a `PasswordManager` class to handle password logic
- FileHandler handles reading, writing, and deleting text files
- Avoids duplicate site entries
- Prevents passwords matching the site or username
- Length-based password strength checks
- Uses `Scanner` for user input
- Uses `ArrayList` for dynamic storage

## 🛠 Technologies Used
- Java (JDK 17+ recommended)
- java.util.Scanner
- java.util.ArrayList
- java.io.File, FileWriter, IOException, etc.

## 🧪 How to Run
- Open the project in your Java IDE (e.g., IntelliJ, Eclipse)
- Run `Main.java`
- Follow the on-screen prompts in the console

## 📚 What I Learned
- Separation of concerns using multiple classes
- Managing user input with validation
- Modeling real-world entities with objects
- File I/O in Java (read/write/delete)
- Preventing data duplication
- Building basic CLI tools with good UX

## 📅 Project Level
🟢 **Level 3** — Integrated file handling, input validation, and multi-class modeling with real-world application design.
