package assignment2.exp3;

/**
 * Experiment 3: Abstract Classes
 *
 * An abstract class is a class that is declared abstract. It may or may not include abstract methods.
 * It cannot be instantiated (you cannot create an object of an abstract class).
 */
public abstract class Shape implements Drawable {
    // 1. Static member (belongs to the CLASS, not the object)
    // Shared by all instances of Shape
    protected static int totalShapesCreated = 0;

    // 2. Instance member (belongs to the OBJECT)
    // Each object has its own copy of this variable
    protected String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
        totalShapesCreated++; // Increment the static counter every time a shape is created
    }

    // Abstract method (does not have a body, must be implemented by subclasses)
    public abstract double calculateArea();

    // Concrete method (has a body, can be used or overridden by subclasses)
    public void displayColor() {
        System.out.println("The color of this shape is: " + color);
    }
    
    // Static method (belongs to the class, can be called without an object)
    public static void displayTotalShapes() {
        System.out.println("Total shapes created so far: " + totalShapesCreated);
    }
}
