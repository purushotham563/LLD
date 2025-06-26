import java.time.Duration;

public interface FeeCalculationStrategy {
    double calculateFee(Ticket ticket);
}

