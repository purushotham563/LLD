package ElevatorSystem;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class ElevatorController {
    private List<Elevator> elevators;
    private Queue<ElevatorCommand> commandQueue;
    private Deque<ElevatorCommand> historyStack;
    private int totalFloors;
    private ScheduledExecutorService scheduler;

    public ElevatorController(int numElevators, int totalFloors, int capacity) {
        this.totalFloors = totalFloors;
        this.elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i + 1, capacity));
        }
        this.commandQueue = new ConcurrentLinkedQueue<>();
        this.historyStack = new ConcurrentLinkedDeque<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            processCommands();
            moveElevators();
            printStatus();
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public void requestElevator(int floor, Direction direction) {
        commandQueue.add(new RequestElevatorCommand(this, floor, direction));
    }

    public void addDestination(int elevatorId, int floor) {
        Elevator elevator = elevators.get(elevatorId - 1);
        commandQueue.add(new AddDestinationCommand(elevator, floor));
    }

    public void undoLastCommand() {
        if (!historyStack.isEmpty()) {
            ElevatorCommand command = historyStack.pop();
            command.undo();
        }
    }

    private void processCommands() {
        while (!commandQueue.isEmpty()) {
            ElevatorCommand command = commandQueue.poll();
            command.execute();
            historyStack.push(command);
        }
    }

    public Elevator findBestElevator(Request request) {
        List<Elevator> availableElevators = elevators.stream()
                .filter(e -> e.canServe(request) && !e.isFull())
                .collect(Collectors.toList());

        if (availableElevators.isEmpty()) {
            return null;
        }

        availableElevators.sort(Comparator.comparingInt(e ->
                Math.abs(e.getCurrentFloor() - request.getFloor())));

        return availableElevators.get(0);
    }

    private void moveElevators() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }

    private void printStatus() {
        System.out.println("\nElevator Status:");
        elevators.forEach(System.out::println);
        System.out.println("Pending commands: " + commandQueue.size());
    }

    public void setMaintenance(int elevatorId, boolean inMaintenance) {
        Elevator elevator = elevators.get(elevatorId - 1);
        elevator.setElevatorState(inMaintenance ? ElevatorState.MAINTENANCE : ElevatorState.IDLE);
    }

    public void triggerEmergencyAlarm(int elevatorId) {
        Elevator elevator = elevators.get(elevatorId - 1);
        elevator.setEmergencyAlarm(true);
    }
}
