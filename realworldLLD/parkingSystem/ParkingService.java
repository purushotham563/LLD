public class ParkingService {
    private final ParkingLot parkingLot;
    public ParkingService(){
        this.parkingLot=ParkingLot.getInstance();
    }
    public Ticket enterVehicle(Vehicle vehicle){
        return parkingLot.generateTicket(vehicle);
    }
    public double exitVehicle(String ticketId){
        return parkingLot.processExit(ticketId);
    }
    public String getParkingStatus(){
        return parkingLot.getStatus();
    }
}
