public class EarlyBirdDiscount implements DiscountStrategy {
    private double discountPercentage;

    public EarlyBirdDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - discountPercentage);
    }
}
