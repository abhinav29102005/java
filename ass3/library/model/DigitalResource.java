package library.model;

import library.service.Printable;

public class DigitalResource extends LibraryResource implements Printable {

    public DigitalResource(String resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // The fine for Digital Resource is Rs. 2/day
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }

    @Override
    public void printDetails() {
        System.out.println("--- Digital Resource Details ---");
        displayBasicInfo(); // Using the protected method from the parent class
        System.out.println("Resource Type: Digital / E-Book");
        System.out.println("--------------------------------");
    }
}
