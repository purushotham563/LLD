package ElevatorSystem;

public class MaintenanceBehavior implements ElevatorBehavior {
    @Override
    public void move(Elevator elevator) {
        return;
    }

    @Override
    public boolean canServe(Elevator elevator, Request request) {
        return false;
    }

    @Override
    public void addDestination(Elevator elevator, int floor) {
      return;
    }

}
