public class Bike extends Vehicle{
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }

    @Override
    public double getHourlyParkingRate() {
        return 10;
    }
}
