public class EmailNotificationService implements SeatAvailabilityObserver {
    @Override
    public void update(Seat seat) {
        // In a real system, this would email users who were interested in this seat
        System.out.println("Notification: Seat " + seat.getSeatId() + " is now available!");
    }
}
