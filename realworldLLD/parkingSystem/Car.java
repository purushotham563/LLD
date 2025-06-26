public class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate,VehicleType.CAR);
    }

    @Override
    public double getHourlyParkingRate() {
        return 20;
    }
}
