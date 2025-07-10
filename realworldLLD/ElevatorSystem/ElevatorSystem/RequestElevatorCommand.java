package ElevatorSystem;

public class RequestElevatorCommand implements ElevatorCommand{
    private ElevatorController controller;
    private int floor;
    private Direction direction;
    private Elevator assignedElevator;

    public RequestElevatorCommand(ElevatorController controller,
                                  int floor,
                                  Direction direction) {
        this.controller = controller;
        this.floor = floor;
        this.direction = direction;

    }

    @Override
    public void execute() {
        assignedElevator=controller.findBestElevator(new Request(floor,direction));
        if(assignedElevator!=null){
            assignedElevator.addDestination(floor);
        }
    }

    @Override
    public void undo() {
      if(assignedElevator!=null){
          assignedElevator.getDestinationFloors().remove(floor);
          if(assignedElevator.getDirection()==Direction.UP){
              assignedElevator.getUpQueue().remove(floor);
          } else if (assignedElevator.getDirection()==Direction.DOWN) {
              assignedElevator.getDownQueue().remove(floor);
          }
      }
    }
}
