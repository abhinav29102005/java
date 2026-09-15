package food.main;

import food.model.FoodOrder;
import food.model.PremiumOrder;
import food.model.RegularOrder;
import food.utility.OrderUtility;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to " + FoodOrder.restaurantName + " Order Management System\n");

        // i. create at least six orders
        // ii. store them using an array of FoodOrder
        FoodOrder[] orders = new FoodOrder[6];
        
        orders[0] = new RegularOrder("ORD001", "Alice", 500.0);
        orders[1] = new PremiumOrder("ORD002", "Bob", 1200.0);
        orders[2] = new RegularOrder("ORD003", "Charlie", 350.0);
        orders[3] = new PremiumOrder("ORD004", "Diana", 800.0);
        orders[4] = new RegularOrder("ORD005", "Eve", 150.0);
        orders[5] = new PremiumOrder("ORD006", "Frank", 2000.0);

        // iii, iv, v, vi. display bill, discount, delivery charge, final payable amount
        for (FoodOrder order : orders) {
            if (OrderUtility.validateCustomerName(order.getCustomerName()) && 
                OrderUtility.validateAmount(order.getAmount())) {
                OrderUtility.generateOrderSummary(order);
            } else {
                System.out.println("Invalid order data for Order ID: " + order.getOrderId());
            }
        }
        
        System.out.println("\n");
        // Static method to display total orders
        FoodOrder.displayTotalOrders();
    }
}
