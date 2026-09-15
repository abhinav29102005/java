package food.utility;

import food.model.FoodOrder;
import food.service.Discountable;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String customerName) {
        return customerName != null && !customerName.trim().isEmpty();
    }

    public static void generateOrderSummary(FoodOrder order) {
        System.out.println("-------------------------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Restaurant: " + FoodOrder.restaurantName);
        
        double amount = order.getAmount();
        double discount = 0;
        
        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }
        
        double deliveryCharge = order.calculateDeliveryCharge();
        double finalPayableAmount = (amount - discount) + deliveryCharge;
        
        System.out.println("Bill Amount: Rs. " + String.format("%.2f", amount));
        System.out.println("Discount: Rs. " + String.format("%.2f", discount));
        System.out.println("Delivery Charge: Rs. " + String.format("%.2f", deliveryCharge));
        System.out.println("Final Payable Amount: Rs. " + String.format("%.2f", finalPayableAmount));
        System.out.println("-------------------------------------------------");
    }
}
