public class PromoCodeDiscount implements DiscountStrategy {
    private double discountPercentage;
    private String promoCode;

    public PromoCodeDiscount(double discountPercentage, String promoCode) {
        this.discountPercentage = discountPercentage;
        this.promoCode = promoCode;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return Math.max(0, originalPrice * (1 - discountPercentage));
    }
}
