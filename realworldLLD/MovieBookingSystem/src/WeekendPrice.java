import java.time.LocalDateTime;

public class WeekendPrice implements PricingStrategy {

    @Override
    public double calculatePrice(double price, LocalDateTime time) {
        return price * 1.2;
    }
}
