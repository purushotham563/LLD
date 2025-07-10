package ElevatorSystem;
    class  MovingDownBehaviour implements ElevatorBehavior {
        @Override
        public void move(Elevator elevator) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            if (elevator.getDownQueue().peek() == elevator.getCurrentFloor()) {
                elevator.stop();
                elevator.getDownQueue().poll();
                elevator.getDestinationFloors().remove(elevator.getCurrentFloor());
            }

            if (elevator.getDownQueue().isEmpty()) {
                if (!elevator.getUpQueue().isEmpty()) {
                    elevator.setDirection(Direction.UP);
                    elevator.setBehavior(new MovingUpBehaviour());
                } else {
                    elevator.setDirection(Direction.IDLE);
                    elevator.setBehavior(new IdleBehaviour());
                }
            }
        }

        @Override
        public boolean canServe(Elevator elevator, Request request) {
            return request.getDirection() == Direction.DOWN &&
                    elevator.getCurrentFloor() >= request.getFloor();
        }

        @Override
        public void addDestination(Elevator elevator, int floor) {
            if (floor < elevator.getCurrentFloor()) {
                elevator.getDownQueue().offer(floor);
                elevator.getDestinationFloors().add(floor);
            } else {
                // For floors above, add to up queue for later
                elevator.getUpQueue().offer(floor);
                elevator.getDestinationFloors().add(floor);
            }
        }
    }

