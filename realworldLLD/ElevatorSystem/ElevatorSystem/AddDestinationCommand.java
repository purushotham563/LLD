package ElevatorSystem;

public class AddDestinationCommand
        implements ElevatorCommand{
    private Elevator elevator;
    private int floor;
    private boolean executed=false;
    private boolean wasIdle;

    public AddDestinationCommand(Elevator elevator, int floor) {
        this.elevator = elevator;
        this.floor = floor;
    }

    @Override
    public void execute() {
     wasIdle=elevator.getDirection()==Direction.IDLE;
     elevator.addDestination(floor);
     executed=true;
    }

    @Override
    public void undo() {
        if(executed){
            elevator.getDestinationFloors().remove(floor);
            if (elevator.getDirection() == Direction.UP) {
                elevator.getUpQueue().remove(floor);
            } else if (elevator.getDirection() == Direction.DOWN) {
                elevator.getDownQueue().remove(floor);
            }
            if(wasIdle&&elevator.getDownQueue().isEmpty()&&elevator.getUpQueue().isEmpty()){
                elevator.setDirection(Direction.IDLE);
                elevator.setBehavior(new IdleBehaviour());
            }

        }
    }
}
