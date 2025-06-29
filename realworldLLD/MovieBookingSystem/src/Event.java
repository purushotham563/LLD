import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Event {
    private String eventId;
    private String name;
    private String description;
    private String venue;
    private LocalDateTime dateTime;
    private Map<String,Seat>seats;
    private PricingStrategy pricingStrategy;
    private ReentrantLock lock=new ReentrantLock(true);

    public Event(String eventId, String name, String description, String venue,
                 LocalDateTime dateTime, List<Seat>seats, PricingStrategy pricingStrategy) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.venue = venue;
        this.dateTime = dateTime;
        this.seats = new ConcurrentHashMap<>();
        this.pricingStrategy = pricingStrategy;
        for (Seat seat:seats
             ) {
            this.seats.put(seat.getSeatId(), seat);
        }
    }
    public List<Seat>getAvailableSeats(){
         List<Seat>availableSeats=new ArrayList<>();
         for(Seat seat:seats.values()){
             if(seat.isAvailable()){
                 availableSeats.add(seat);
             }
         }
         return availableSeats;
    }
    public boolean reserveSeat(String seatId,User user){
        lock.lock();
        try {
            Seat seat=seats.get(seatId);
            if(seat!=null&&seat.isAvailable()){
                seat.reserve();
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }
    public void releaseSeat(String seatId){
        lock.lock();
        try {
            Seat seat=seats.get(seatId);
            if(seat!=null&&!seat.isAvailable()){
                seat.release();
            }
        }finally {
            lock.unlock();
        }
    }
    public double calculatePrice(Seat seat){
        return pricingStrategy.calculatePrice(seat.getBasePrice(), dateTime);
    }
    public String getEventId() { return eventId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getVenue() { return venue; }
    public LocalDateTime getDateTime() { return dateTime; }

}
