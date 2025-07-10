package ElevatorSystem;

class MovingUpBehaviour implements ElevatorBehavior {
    @Override
    public void move(Elevator elevator) {
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        if (elevator.getUpQueue().peek() == elevator.getCurrentFloor()) {
            elevator.stop();
            elevator.getUpQueue().poll();
            elevator.getDestinationFloors().remove(elevator.getCurrentFloor());
        }

        if (elevator.getUpQueue().isEmpty()) {
            if (!elevator.getDownQueue().isEmpty()) {
                elevator.setDirection(Direction.DOWN);
                elevator.setBehavior(new MovingDownBehaviour());
            } else {
                elevator.setDirection(Direction.IDLE);
                elevator.setBehavior(new IdleBehaviour());
            }
        }
    }

    @Override
    public boolean canServe(Elevator elevator, Request request) {
        return request.getDirection() == Direction.UP &&
                elevator.getCurrentFloor() <= request.getFloor();
    }

    @Override
    public void addDestination(Elevator elevator, int floor) {
        if (floor > elevator.getCurrentFloor()) {
            elevator.getUpQueue().offer(floor);
            elevator.getDestinationFloors().add(floor);
        } else {
            // For floors below, add to down queue for later
            elevator.getDownQueue().offer(floor);
            elevator.getDestinationFloors().add(floor);
        }
    }
}