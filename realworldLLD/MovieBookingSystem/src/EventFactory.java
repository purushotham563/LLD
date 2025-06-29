import java.time.LocalDateTime;
import java.util.List;

public interface EventFactory {
    Event createEvent(String eventId, String name,
                      String description, String venue,
                      LocalDateTime dateTime, List<Seat> seats,
                      PricingStrategy pricingStrategy);
}

