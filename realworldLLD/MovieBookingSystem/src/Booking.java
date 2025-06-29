import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Event event;
    private List<Seat> seats;
    private LocalDateTime bookingTime;
    private Payment payment;
    private BookingStatus status;

    public Booking(String bookingId, User user, Event event, List<Seat> seats,
                   Payment payment) {
        this.bookingId = bookingId;
        this.user = user;
        this.event = event;
        this.seats = seats;
        this.payment = payment;
        this.status = BookingStatus.CONFIRMED;
        this.bookingTime=LocalDateTime.now();
    }
    public void cancel(){
        this.status=BookingStatus.CANCELLED;
        for(Seat seat:seats){
            event.releaseSeat(seat.getSeatId());
        }
    }
    public double calculateRefund(){
        long hoursUntilEvent = java.time.Duration.between(LocalDateTime.now(),
                event.getDateTime()).toHours();
        if(hoursUntilEvent>24){
            return payment.getAmount()*0.8;
        }
        return 0;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
enum BookingStatus{
    CONFIRMED,CANCELLED
}
