import java.util.List;

public class AdminService {
    private final ParkingLot parkingLot;
    public AdminService(){
        this.parkingLot=ParkingLot.getInstance();
    }
    public void addFloor(ParkingFloor floor){
        parkingLot.addFloor(floor);
    }
    public void addParkingSlot(String floorId, ParkingSlot slot) {
        parkingLot.getFloors().stream()
                .filter(f -> f.getFloorId().equals(floorId))
                .findFirst()
                .ifPresentOrElse(
                        floor -> floor.addParkingSlot(slot),
                        () -> { throw new IllegalArgumentException("Floor not found"); }
                );
    }

    public String viewCurrentStatus() {
        return parkingLot.getStatus();
    }

    public List<Ticket> getAllActiveTickets() {
        return parkingLot.getActiveTickets();
    }

}
