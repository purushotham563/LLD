import java.time.LocalDateTime;
import java.util.List;

public class MovieFactory implements EventFactory {

    @Override
    public Event createEvent(String eventId, String name, String description, String venue, LocalDateTime dateTime, List<Seat> seats,
                             PricingStrategy pricingStrategy) {
        return new Event(eventId, name, description, venue, dateTime, seats, pricingStrategy);
    }

}
