package library.model;

import library.service.Printable;

public class Book extends LibraryResource implements Printable {

    public Book(String resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // The fine for Book is Rs. 5/day
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5.0;
    }

    @Override
    public void printDetails() {
        System.out.println("--- Book Details ---");
        displayBasicInfo(); // Using the protected method from the parent class
        System.out.println("Resource Type: Physical Book");
        System.out.println("--------------------");
    }
}
