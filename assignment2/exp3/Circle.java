package assignment2.exp3;

/**
 * Concrete class extending the abstract class Shape.
 */
public class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(String color, double radius) {
        // Call the constructor of the parent abstract class using 'super'
        super(color);
        this.radius = radius;
    }

    // Providing implementation for the abstract method from the abstract class Shape
    @Override
    public double calculateArea() {
        // Area of a circle = π * r^2
        return Math.PI * radius * radius;
    }

    // Providing implementation for the abstract method from the interface Drawable
    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius + " using " + DRAWING_TOOL);
    }
}
