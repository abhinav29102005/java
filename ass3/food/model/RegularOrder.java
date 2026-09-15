package food.model;

import food.service.Discountable;

public class RegularOrder extends FoodOrder implements Discountable {
    
    public RegularOrder(String orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Method overriding for calculating delivery charge
    @Override
    public double calculateDeliveryCharge() {
        return 80.0;
    }

    // Implementing the interface method for discount
    @Override
    public double applyDiscount() {
        return getAmount() * 0.10; // 10% discount
    }
}
