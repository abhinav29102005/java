package food.model;

import food.service.Discountable;

public class PremiumOrder extends FoodOrder implements Discountable {

    public PremiumOrder(String orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Method overriding for calculating delivery charge
    @Override
    public double calculateDeliveryCharge() {
        return 50.0;
    }

    // Implementing the interface method for discount
    @Override
    public double applyDiscount() {
        return getAmount() * 0.15; // 15% discount
    }
}
