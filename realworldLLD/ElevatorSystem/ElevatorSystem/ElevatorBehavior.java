package ElevatorSystem;

public interface ElevatorBehavior {
    void move(Elevator elevator);
    boolean canServe(Elevator elevator,Request request);
    void addDestination(Elevator elevator,int floor);
}
