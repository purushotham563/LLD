public class VehicleFactory {
    public Vehicle createVehicle(VehicleType type,String licenseNumber){
        if(licenseNumber==null||licenseNumber.trim().isEmpty())
        throw new IllegalStateException("License number cannot be empty");
        switch (type){
            case BIKE -> {
                return new Bike(licenseNumber);
            }
            case CAR -> {
                return new Car(licenseNumber);
            }
            case TRUCK -> {
                return new Truck(licenseNumber);

            }
            default -> throw new IllegalStateException("Unknown vehicle type"+type);
        }
    }

}
