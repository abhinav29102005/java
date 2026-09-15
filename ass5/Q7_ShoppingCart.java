package ass5;

import ass5.exceptions.*;

import java.util.ArrayList;
import java.util.List;

class Product {
    String id;
    String name;
    double price;
    int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class Q7_ShoppingCart {
    private List<Product> availableProducts = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();
    private double userBalance = 1000.0; // Simulated user wallet

    public Q7_ShoppingCart() {
        availableProducts.add(new Product("P1", "Laptop", 800.0, 5));
        availableProducts.add(new Product("P2", "Mouse", 20.0, 0)); // Out of stock
        availableProducts.add(new Product("P3", "Keyboard", 50.0, 10));
    }

    public Product searchProduct(String id) throws ProductNotFoundException {
        for (Product p : availableProducts) {
            if (p.id.equals(id)) return p;
        }
        throw new ProductNotFoundException("Product with ID " + id + " not found.");
    }

    public void addToCart(String id) throws ProductException {
        Product p = searchProduct(id); // Can throw ProductNotFoundException
        if (p.stock <= 0) {
            throw new OutOfStockException("Product " + p.name + " is currently out of stock.");
        }
        cart.add(p);
        System.out.println(p.name + " added to cart.");
    }

    public void checkout(double paymentAmount) throws ApplicationException {
        if (cart.isEmpty()) {
            throw new EmptyCartException("Cannot checkout. The shopping cart is empty.");
        }

        double total = 0;
        for (Product p : cart) {
            total += p.price;
        }
        
        System.out.println("Total Cart Value: $" + total);

        if (paymentAmount <= 0) {
            throw new InvalidPaymentException("Payment amount must be greater than zero.");
        }
        
        if (paymentAmount < total) {
            throw new InvalidPaymentException("Payment amount $" + paymentAmount + " is less than the total $" + total);
        }

        if (userBalance < paymentAmount) {
            throw new InsufficientFundsException("Insufficient funds in wallet. Balance: $" + userBalance);
        }

        // Process payment
        userBalance -= paymentAmount;
        double change = paymentAmount - total;
        
        System.out.println("Payment successful! Change returned: $" + change);
        
        // Deduct stock
        for (Product p : cart) {
            p.stock--;
        }
        cart.clear(); // Empty cart after checkout
    }

    public static void main(String[] args) {
        System.out.println("--- Shopping Cart Application ---");
        Q7_ShoppingCart app = new Q7_ShoppingCart();

        try {
            // Scenario 1: Add valid product
            app.addToCart("P1");
            
            // Scenario 2: Add out-of-stock product
            // app.addToCart("P2"); // Uncomment to trigger OutOfStockException
            
            // Scenario 3: Search invalid product
            // app.searchProduct("P99"); // Uncomment to trigger ProductNotFoundException
            
            // Scenario 4: Checkout with insufficient funds
            // app.addToCart("P1"); 
            // app.addToCart("P1"); // Total 1600
            // app.checkout(1600); // Trigger InsufficientFundsException (balance is 1000)

            // Successful Checkout
            app.checkout(1000.0);

        } catch (ApplicationException e) {
            System.out.println("Application Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
