package ElevatorSystem;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private DoorStatus doorStatus;
    private ElevatorState elevatorState;
    private final int capacity;
    private int currentLoad;
    private boolean emergencyAlarm;
    private Set<Integer> destinationFloors;
    private PriorityQueue<Integer> upQueue;
    private PriorityQueue<Integer>downQueue;
    private ElevatorBehavior behavior;

    public Elevator(int id, int capacity) {
        this.currentLoad=0;
        this.emergencyAlarm=false;
        destinationFloors=new HashSet<>();
        upQueue=new PriorityQueue<>();
        this.downQueue=new PriorityQueue<>(Collections.reverseOrder());
        this.currentFloor=0;
        this.direction=Direction.IDLE;
        this.doorStatus=DoorStatus.CLOSE;
        this.behavior=new IdleBehaviour();
        this.id = id;
        this.capacity = capacity;
    }
    public void move(){
        behavior.move(this);
    }
    public void addDestination(int floor){
        behavior.addDestination(this,floor);
    }
    public boolean canServe(Request request){
        if(elevatorState==ElevatorState.IDLE||elevatorState==ElevatorState.MAINTENANCE){
            return false;
        }
        return behavior.canServe(this,request);
    }
    public void stop(){
        doorStatus=DoorStatus.OPEN;
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        doorStatus=DoorStatus.CLOSE;
    }
    public int getCurrentFloor() { return currentFloor; }
    public void setCurrentFloor(int floor) { this.currentFloor = floor; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public ElevatorState getState() { return elevatorState; }
    public void setElevatorState(ElevatorState state){
        this.elevatorState=state;
        if(state==ElevatorState.MAINTENANCE){
            this.behavior=new MaintenanceBehavior();
        }

    }
    public int getId() { return id; }
    public boolean isEmergencyAlarm() { return emergencyAlarm; }
    public void setEmergencyAlarm(boolean emergencyAlarm){
        this.emergencyAlarm=emergencyAlarm;
        if (emergencyAlarm){
            this.behavior=new MaintenanceBehavior();
        }
    }
    public DoorStatus getDoorStatus() { return doorStatus; }
    public int getCapacity() { return capacity; }
    public int getCurrentLoad() { return currentLoad; }
    public boolean isFull() { return currentLoad >= capacity; }
    public Set<Integer> getDestinationFloors() { return destinationFloors; }
    public PriorityQueue<Integer> getUpQueue() { return upQueue; }
    public PriorityQueue<Integer> getDownQueue() { return downQueue; }
    public void setBehavior(ElevatorBehavior behavior) { this.behavior = behavior; }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                ", doorStatus=" + doorStatus +
                ", elevatorState=" + elevatorState +
                ", capacity=" + capacity +
                ", currentLoad=" + currentLoad +
                ", emergencyAlarm=" + emergencyAlarm +
                ", destinationFloors=" + destinationFloors +
                ", upQueue=" + upQueue +
                ", downQueue=" + downQueue +
                ", behavior=" + behavior +
                '}';
    }
}
