package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.Printable;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to " + LibraryResource.libraryName + " Management System\n");

        // i. create at least five objects
        // ii. store them in an array
        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book("101", "Effective Java", "Joshua Bloch");
        resources[1] = new DigitalResource("102", "Clean Code e-book", "Robert C. Martin");
        resources[2] = new Book("103", "Design Patterns", "Gang of Four");
        resources[3] = new DigitalResource("104", "Java Concurrency in Practice", "Brian Goetz");
        resources[4] = new Book("105", "Head First Java", "Kathy Sierra");

        int[] overdueDays = {5, 2, 0, 10, 3}; // Sample overdue days for each resource

        double totalFine = 0.0;

        // iii. display complete details
        // iv. calculate total fine of all overdue resources
        for (int i = 0; i < resources.length; i++) {
            LibraryResource resource = resources[i];
            
            // Validate before processing
            if (InputValidator.validateResourceId(resource.getResourceId()) && 
                InputValidator.validateFineDays(overdueDays[i])) {
                
                // Using the Printable interface to print details
                if (resource instanceof Printable) {
                    ((Printable) resource).printDetails();
                }

                double fine = resource.calculateFine(overdueDays[i]);
                System.out.println("Overdue Days: " + overdueDays[i]);
                System.out.println("Fine for this resource: Rs. " + fine);
                System.out.println();

                totalFine += fine;
            } else {
                System.out.println("Validation failed for Resource ID: " + resource.getResourceId() + "\n");
            }
        }

        System.out.println("=====================================");
        System.out.println("Total Fine of all overdue resources: Rs. " + totalFine);
        System.out.println("=====================================\n");
        
        // Static method to display total resources created
        LibraryResource.displayTotalResources();
    }
}
