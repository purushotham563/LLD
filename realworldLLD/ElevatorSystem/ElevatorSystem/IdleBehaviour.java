package ElevatorSystem;

public class IdleBehaviour implements ElevatorBehavior{

    @Override
    public void move(Elevator elevator) {
        if(!elevator.getUpQueue().isEmpty()){
            elevator.setBehavior(new MovingUpBehaviour());
        } else if (!elevator.getDownQueue().isEmpty()) {
            elevator.setBehavior(new MovingDownBehaviour());
        }
    }

    @Override
    public boolean canServe(Elevator elevator, Request request) {
        return true;
    }

    @Override
    public void addDestination(Elevator elevator, int floor) {
        if(floor>elevator.getCurrentFloor()){
            elevator.getUpQueue().add(floor);
        }else {
            elevator.getDownQueue().add(floor);
        }
        elevator.getDestinationFloors().add(floor);
    }
}
