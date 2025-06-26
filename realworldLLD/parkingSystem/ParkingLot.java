import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors;
    private final List<Ticket> activeTickets;
    private final List<Ticket> completedTickets;
    private FeeCalculationStrategy defaultStrategy=new HourlyFeeStrategy();

    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.activeTickets = new ArrayList<>();
        this.completedTickets = new ArrayList<>();
    }
    public void setDefaultFeeStrategy(FeeCalculationStrategy strategy){
        this.defaultStrategy=strategy;
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public boolean removeFloor(String floorId) {
        return floors.removeIf(f -> f.getFloorId().equals(floorId));
    }

    public Ticket generateTicket(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle.getType());
            if (slot != null && slot.parkVehicle(vehicle)) {
                String ticketId = generateTicketId();
                Ticket ticket = new Ticket(ticketId, vehicle, slot,defaultStrategy);
                activeTickets.add(ticket);
                return ticket;
            }
        }
        throw new RuntimeException("No available parking slot");
    }

    public double processExit(String ticketId) {
        Ticket ticket = findActiveTicket(ticketId);
        ticket.markExit();
        double fee = ticket.calculateFee();
        ticket.getSlot().unparkVehicle();
        activeTickets.remove(ticket);
        completedTickets.add(ticket);
        return fee;
    }

    private Ticket findActiveTicket(String ticketId) {
        return activeTickets.stream()
                .filter(t -> t.getTicketId().equals(ticketId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID"));
    }

    private String generateTicketId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("==== Parking Lot Status ====\n");
        floors.forEach(floor -> sb.append(floor.getStatus()).append("\n"));
        sb.append(String.format("\nTotal Vehicles: %d (Active: %d, Completed: %d)",
                activeTickets.size() + completedTickets.size(),
                activeTickets.size(),
                completedTickets.size()));

        return sb.toString();
    }

    public List<ParkingFloor> getFloors() {
        return Collections.unmodifiableList(floors);
    }

    public List<Ticket> getActiveTickets() {
        return Collections.unmodifiableList(activeTickets);
    }

    public List<Ticket> getCompletedTickets() {
        return Collections.unmodifiableList(completedTickets);
    }
}
