public class ParkingSlot {
    private final String slotId;
    private final VehicleType slotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;
    private final ParkingFloor floor;

    public ParkingSlot(String id, VehicleType type, ParkingFloor floor) {
        this.slotId = id;
        this.slotType = type;
        this.floor = floor;
        this.isAvailable=true;
    }
    public boolean parkVehicle(Vehicle vehicle){
        if(!isAvailable||!canFitVehicle(vehicle)){
            return false;
        }
        this.parkedVehicle=vehicle;
        this.isAvailable=false;
        return true;
    }
    public Vehicle unparkVehicle(){
        if(isAvailable){
            return null;
        }
        Vehicle vehicle=this.parkedVehicle;
        this.parkedVehicle=null;
        this.isAvailable=true;
        return vehicle;

    }


    private boolean canFitVehicle(Vehicle vehicle) {
        switch (vehicle.getType()){
            case CAR -> {
                return this.slotType==VehicleType.CAR||this.slotType==VehicleType.TRUCK;
            }
            case TRUCK -> {
                return this.slotType==VehicleType.TRUCK;
            }
            case BIKE -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public String getSlotId() {
        return slotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public ParkingFloor getFloor() {
        return floor;
    }
}
