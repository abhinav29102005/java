package food.model;

public abstract class FoodOrder {
    private String orderId;
    private String customerName;
    private double amount;
    
    // Static member for restaurant name
    public static String restaurantName = "BiteRush Deliveries";
    
    // Static object counter
    private static int totalOrdersCreated = 0;

    public FoodOrder(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        totalOrdersCreated++; // Increment the counter when a new order is instantiated
    }

    // Abstract method
    public abstract double calculateDeliveryCharge();

    // Static method to display total orders
    public static void displayTotalOrders() {
        System.out.println("Total Orders Created: " + totalOrdersCreated);
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
