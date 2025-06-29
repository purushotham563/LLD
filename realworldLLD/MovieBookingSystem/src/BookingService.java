import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Event>events;
    private SeatAvailabilityNotifier seatNotifier;
    public BookingService(){
        this.events=new ArrayList<>();
        this.seatNotifier=new SeatAvailabilityNotifier();
    }
    public void addEvent(Event event){
        events.add(event);
    }
    public List<Event>getEvents(){
        return events;
    }
    public Booking createBooking(User user,Event event,List<Seat>seats,DiscountStrategy discountStrategy,
                                 PaymentMethod paymentMethod){
        for (Seat seat:seats){
            if(!event.reserveSeat(seat.getSeatId(),user)){
                for(Seat reserveSeat:seats){
                    if(reserveSeat.getSeatId().equals(seat.getSeatId())){
                        break;
                    }
                    event.releaseSeat(reserveSeat.getSeatId());
                }
                throw new IllegalStateException("Seat " + seat.getSeatId() + " is no longer available");

            }
        }
        double totalPrice=0;
        for (Seat seat:seats){
            totalPrice+=event.calculatePrice(seat);
        }
        totalPrice=discountStrategy.applyDiscount(totalPrice);
        Payment payment=new Payment(generatePaymentId(),totalPrice,paymentMethod);
        if(!payment.process()){
            for(Seat seat:seats){
                event.releaseSeat(seat.getSeatId());
            }
            throw new IllegalStateException("Payment failed");
        }
        Booking booking=new Booking(generateBookingId(),user,event,seats,payment);
        return booking;
    }
    public void cancelBooking(Booking booking) {
        booking.cancel();
        for (Seat seat : booking.getSeats()) {
            seatNotifier.notifyObserver(seat);
        }
    }
    public void registerForSeatNotification(SeatAvailabilityObserver observer){
        seatNotifier.addObserver(observer);
    }











    private String generateBookingId() {
        return "BK-" + System.currentTimeMillis();
    }

    private String generatePaymentId() {
        return "PY-" + System.currentTimeMillis();
    }

}
