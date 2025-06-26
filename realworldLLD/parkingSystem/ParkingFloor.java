import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private final String floorId;
    private final Map<String,ParkingSlot>slots;
    private final Map<VehicleType, List<ParkingSlot>>slotsByType;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        slots=new HashMap<>();
        this.slotsByType=new HashMap<>();
        initializeSlotTypes();
    }

    private void initializeSlotTypes() {
        for(VehicleType type:VehicleType.values()){
            slotsByType.put(type,new ArrayList<>());
        }

    }
    public void addParkingSlot(ParkingSlot slot){
        if(slots.containsKey(slot.getSlotId())){
            throw new IllegalStateException("Slot id already exits "+slot.getSlotId());


        }
        slots.put(slot.getSlotId(), slot);
        slotsByType.get(slot.getSlotType()).add(slot);
    }
    public boolean removeParkingSlot(String slotId){
        ParkingSlot slot=slots.remove(slotId);
        if(slot!=null){
            slotsByType.get(slot.getSlotType()).remove(slot);
            return true;
        }
        return false;
    }
    public ParkingSlot findAvailableSlot(VehicleType vehicleType) {
        for (ParkingSlot slot : slotsByType.get(vehicleType)) {
            if (slot.isAvailable()) {
                return slot;
            }
        }

        if (vehicleType == VehicleType.CAR) {
            for (ParkingSlot slot : slotsByType.get(VehicleType.TRUCK)) {
                if (slot.isAvailable()) {
                    return slot;
                }
            }
        }
        if (vehicleType == VehicleType.BIKE) {
            for (List<ParkingSlot> slotList : slotsByType.values()) {
                for (ParkingSlot slot : slotList) {
                    if (slot.isAvailable()) {
                        return slot;
                    }
                }
            }
        }

        return null;
    }

    public List<ParkingSlot> getAllSlots() {
        return new ArrayList<>(slots.values());
    }

    public List<ParkingSlot> getSlotsByType(VehicleType type) {
        return new ArrayList<>(slotsByType.get(type));
    }

    public int getAvailableSlotsCount(VehicleType type) {
        return (int) slotsByType.get(type).stream()
                .filter(ParkingSlot::isAvailable)
                .count();
    }

    public int getTotalSlotsCount(VehicleType type) {
        return slotsByType.get(type).size();
    }

    public String getFloorId() {
        return floorId;
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Floor ").append(floorId).append(" Status:\n");

        for (VehicleType type : VehicleType.values()) {
            int available = getAvailableSlotsCount(type);
            int total = getTotalSlotsCount(type);
            sb.append(String.format("  %-6s: %2d/%2d available%n",
                    type, available, total));
        }

        return sb.toString();
    }


}
