public class Truck extends Vehicle{
    public Truck(String licensePlate) {
        super(licensePlate,VehicleType.TRUCK);
    }

    @Override
    public double getHourlyParkingRate() {
        return 30;
    }
}
