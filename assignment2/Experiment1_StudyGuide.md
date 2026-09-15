# Java Platform Fundamentals

Welcome to your study guide for Experiment 1! This guide covers the essential theoretical components of the Java platform.

## 1. The Java Platform: JDK, JRE, and JVM

Java's architecture is unique because it is designed to be "Write Once, Run Anywhere" (WORA). This is achieved through three main components:

### JVM (Java Virtual Machine)
- **What it is:** The JVM is the engine that actually runs your Java code. It's a virtual computer that resides in your actual computer.
- **How it works:** When you compile Java code, it doesn't turn into machine code (like C++ does). Instead, it turns into **Bytecode** (`.class` files). The JVM reads this bytecode and translates it into machine code that your specific operating system (Windows, Mac, Linux) understands.
- **Why it matters:** Because every OS has its own JVM, you can run the exact same bytecode on any machine.

### JRE (Java Runtime Environment)
- **What it is:** The JRE is the software environment in which Java programs run. 
- **What it contains:** It contains the JVM, plus the core classes (Java standard libraries) and supporting files required to run Java applications. 
- **Who needs it:** End-users who only want to *run* Java applications need to install the JRE.

### JDK (Java Development Kit)
- **What it is:** The JDK is the full toolkit used by developers to *write*, *compile*, and *run* Java applications.
- **What it contains:** It contains the JRE (and therefore the JVM), plus development tools like the compiler (`javac`), the archiver (`jar`), and debuggers.
- **Who needs it:** You! As a Java developer, you must have the JDK installed.

---

## 2. Java Project Structure

A well-organized Java project usually follows a standard directory structure. This separates your source code from your compiled output.

```text
MyJavaProject/
├── src/                # Source folder: Where you write your .java files
│   └── com/
│       └── myapp/
│           └── Main.java
├── bin/                # (or out/ or target/) Binary folder: Where compiled .class files go
│   └── com/
│       └── myapp/
│           └── Main.class
└── lib/                # Library folder: For external dependencies (.jar files)
```

---

## 3. Packages

- **What they are:** A package in Java is a mechanism to encapsulate a group of classes, sub-packages, and interfaces. Think of them as folders on your computer.
- **Why we use them:**
  1. **Organization:** Keeps related classes together.
  2. **Namespace Management:** Prevents naming conflicts. You can have a `Student` class in a `school` package and a `Student` class in a `university` package without them conflicting.
  3. **Access Control:** You can use the `default` or `protected` access modifiers to allow classes in the same package to access each other's members.
- **Syntax:** The `package` keyword must be the very first line of code in your Java file.
  ```java
  package com.myapp.school;
  ```

---

## 4. CLASSPATH

- **What it is:** `CLASSPATH` is an environment variable (or a command-line argument) that tells the JVM and the Java compiler (`javac`) where to look for user-defined classes and packages.
- **How it works:** When you import a class like `Scanner` or one of your own classes from another package, Java needs to know where that `.class` file lives on your hard drive. It searches through the directories and `.jar` files listed in the `CLASSPATH`.
- **Usage:** You can specify it when compiling or running code:
  ```bash
  # Tells Java to look in the 'bin' folder and a specific jar file
  java -cp "bin:lib/mylibrary.jar" com.myapp.Main
  ```
