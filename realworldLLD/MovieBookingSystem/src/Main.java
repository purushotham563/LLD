import java.time.LocalDateTime;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        BookingService bookingService = new BookingService();
        bookingService.registerForSeatNotification(new EmailNotificationService());
        Seat seat1 = new Seat("A1", "VIP", 100);
        Seat seat2 = new Seat("A2", "VIP", 100);
        Seat seat3 = new Seat("B1", "Regular", 50);
        Seat seat4 = new Seat("B2", "Regular", 50);
        List<Seat> seats = Arrays.asList(seat1, seat2, seat3, seat4);
        LocalDateTime eventTime = LocalDateTime.now().plusDays(3);
        PricingStrategy pricingStrategy = eventTime.getDayOfWeek().getValue() >= 6
                ? new WeekendPrice() : new WeekDayPrice();

        EventFactory concertFactory = new ConcertFactory();
        Event concert = concertFactory.createEvent(
                "EV-001", "Rock Concert", "Annual rock festival",
                "Central Park", eventTime, seats, pricingStrategy);

        bookingService.addEvent(concert);
        User user = new User("USR-001", "Purushotham", "purushotham@gmial.com");
        System.out.println("Available events:");
        bookingService.getEvents().forEach(e -> System.out.println(e.getName()));
        System.out.println("\nAvailable seats for concert:");
        concert.getAvailableSeats().forEach(s ->
                System.out.println(s.getSeatId() + " - " + s.getSelection() + "RS " + concert.calculatePrice(s)));
        try {
            DiscountStrategy discount = new EarlyBirdDiscount(0.1); // 10% early bird discount
            Booking booking = bookingService.createBooking(
                    user, concert, Arrays.asList(seat1, seat2),
                    discount, PaymentMethod.CREDIT_CARD);

            System.out.println("\nBooking created: " + booking.getBookingId());
            System.out.println("Total paid:" + booking.getPayment().getAmount());

            if (eventTime.isAfter(LocalDateTime.now().plusHours(24))) {
                System.out.println("\nCancelling booking...");
                bookingService.cancelBooking(booking);
                System.out.println("Refund amount: " + booking.calculateRefund());
            } else {
                System.out.println("\nCannot cancel - less than 24 hours before event");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}