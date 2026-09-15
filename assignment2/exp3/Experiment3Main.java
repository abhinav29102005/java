package assignment2.exp3;

/**
 * Main class to demonstrate Abstract Classes, Interfaces, Static, and Instance members.
 */
public class Experiment3Main {
    public static void main(String[] args) {
        System.out.println("Starting Experiment 3...\n");

        // Calling a static method directly using the Class name.
        // Notice we haven't created any Shape objects yet.
        System.out.print("Before creating objects - ");
        Shape.displayTotalShapes();

        // We cannot instantiate an abstract class:
        // Shape myShape = new Shape("Red"); // This would cause a compilation ERROR!

        // We can create objects of concrete subclasses and use polymorphism
        Shape circle1 = new Circle("Red", 5.0);
        Shape circle2 = new Circle("Blue", 10.0);

        System.out.println("\n--- Interacting with circle1 ---");
        // Accessing instance method (acts on the specific object circle1)
        circle1.displayColor(); 
        System.out.println("Area: " + String.format("%.2f", circle1.calculateArea()));
        
        // Because circle1 is referenced as a Shape, we need to cast it to access Drawable methods
        // if we didn't store it in a Drawable reference. But since Shape implements Drawable, 
        // we can cast or call it directly.
        ((Drawable)circle1).draw();

        System.out.println("\n--- Interacting with circle2 ---");
        // Accessing instance method (acts on the specific object circle2)
        circle2.displayColor();
        System.out.println("Area: " + String.format("%.2f", circle2.calculateArea()));
        ((Drawable)circle2).draw();

        // Calling the static method again. 
        // The static variable 'totalShapesCreated' is shared among all instances.
        System.out.print("\nAfter creating objects - ");
        Shape.displayTotalShapes();
    }
}
