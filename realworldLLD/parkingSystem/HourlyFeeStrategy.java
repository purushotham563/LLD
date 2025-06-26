import java.time.Duration;

public class HourlyFeeStrategy implements FeeCalculationStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = duration.toHours();
        return Math.max(1, hours) * ticket.getVehicle().getHourlyParkingRate();
    }

}
