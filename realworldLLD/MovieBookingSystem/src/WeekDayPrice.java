import java.time.LocalDateTime;

public class WeekDayPrice implements PricingStrategy {

    @Override
    public double calculatePrice(double price, LocalDateTime time) {
        return price;
    }
}
