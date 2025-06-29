public class GroupDiscount implements DiscountStrategy {
    private double discountPercentage;
    private int minGroup;

    public GroupDiscount(double discountPercentage, int minGroup) {
        this.discountPercentage = discountPercentage;
        this.minGroup = minGroup;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - discountPercentage);
    }
}
