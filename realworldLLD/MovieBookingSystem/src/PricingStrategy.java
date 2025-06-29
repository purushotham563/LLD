import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculatePrice(double price, LocalDateTime time);
}
