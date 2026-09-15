package assignment2.exp2;

/**
 * Main class to demonstrate the creation of objects and usage of classes.
 */
public class Experiment2Main {
    public static void main(String[] args) {
        System.out.println("Starting Experiment 2: Classes, Objects, and Constructors...\n");

        // 1. Creating an object using the Default Constructor
        // Syntax: ClassName objectName = new ClassName();
        Student student1 = new Student();
        
        // Modifying the object using setter methods because variables are private
        student1.setName("Alice Smith");
        student1.setRollNumber(101);
        student1.marks = 85.5; // We can access 'marks' directly here because it is protected and we are in the same package (assignment2.exp2)

        // 2. Creating an object using the Parameterized Constructor
        Student student2 = new Student(102, "Bob Johnson", 92.0);

        // 3. Using methods to display the information
        System.out.println("\nDisplaying Student 1:");
        student1.displayStudentInfo();

        System.out.println("Displaying Student 2:");
        student2.displayStudentInfo();
        
        // 4. Demonstrating access modifier restrictions:
        // System.out.println(student1.name); // ERROR: 'name' has private access in Student
        System.out.println("Accessing public variable directly: " + student1.university);
        System.out.println("Accessing private variable via getter: " + student1.getName());
    }
}
