package library.model;

public abstract class LibraryResource {
    private String resourceId;
    private String title;
    private String author;
    
    // Static variable for library name
    public static String libraryName = "Smart Central Library";
    
    // Static object counter
    private static int totalResourcesCreated = 0;

    public LibraryResource(String resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResourcesCreated++;
    }

    // Abstract method
    public abstract double calculateFine(int overdueDays);

    // Static method to display total resources created
    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + totalResourcesCreated);
    }

    // Getters
    public String getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Protected method example
    protected void displayBasicInfo() {
        System.out.println("Resource ID: " + resourceId + " | Title: " + title + " | Author: " + author);
    }
}
