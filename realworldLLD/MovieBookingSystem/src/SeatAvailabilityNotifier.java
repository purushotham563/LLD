import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityNotifier {
    private List<SeatAvailabilityObserver> observers = new ArrayList<>();

    public void addObserver(SeatAvailabilityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SeatAvailabilityObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver(Seat seat) {
        for (SeatAvailabilityObserver observer : observers) {
            observer.update(seat);
        }
    }
}
