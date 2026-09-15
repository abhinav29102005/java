package assignment2.exp2;

/**
 * Experiment 2: Implementation of Classes, Objects, Constructors, and Access Modifiers
 *
 * This class represents a Student. It demonstrates:
 * - Access modifiers (private, public, protected)
 * - Different types of constructors (default, parameterized)
 * - Instance variables and methods
 */
public class Student {
    // 1. Access Modifiers:
    // 'private' means these variables can only be accessed within this Student class.
    // This is called Encapsulation.
    private int rollNumber;
    private String name;
    
    // 'protected' means it can be accessed within the same package and by subclasses.
    protected double marks;
    
    // 'public' means it can be accessed from anywhere.
    public String university = "Global Tech University";

    // 2. Constructors:
    // Default constructor (no parameters)
    public Student() {
        this.rollNumber = 0;
        this.name = "Unknown";
        this.marks = 0.0;
        System.out.println("Default constructor called.");
    }

    // Parameterized constructor (takes arguments to initialize the object)
    public Student(int rollNumber, String name, double marks) {
        // 'this' keyword refers to the current object's instance variable
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
        System.out.println("Parameterized constructor called for: " + name);
    }

    // 3. Methods:
    // Getter method to safely access private variable 'name'
    public String getName() {
        return name;
    }

    // Setter method to safely modify private variable 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter for rollNumber
    public int getRollNumber() {
        return rollNumber;
    }

    // Setter for rollNumber
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("\n--- Student Information ---");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("University: " + university);
        System.out.println("---------------------------\n");
    }
}
