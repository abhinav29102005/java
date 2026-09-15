package assignment2.exp3;

/**
 * Experiment 3: Implementation of Interfaces
 *
 * An interface in Java is a blueprint of a class. It has static constants and abstract methods.
 * It is a mechanism to achieve full abstraction.
 */
public interface Drawable {
    // In an interface, variables are implicitly public, static, and final (constants)
    String DRAWING_TOOL = "Digital Canvas";

    // In an interface, methods are implicitly public and abstract (no body)
    void draw();
}
