public class Main {
    public static void main(String[] args) {
        AdminService admin = new AdminService();
        ParkingService parking = new ParkingService();

        ParkingFloor groundFloor = new ParkingFloor("GF");
        groundFloor.addParkingSlot(new ParkingSlot("GF-1", VehicleType.BIKE, groundFloor));
        groundFloor.addParkingSlot(new ParkingSlot("GF-2", VehicleType.CAR, groundFloor));
        groundFloor.addParkingSlot(new ParkingSlot("GF-3", VehicleType.TRUCK, groundFloor));
        admin.addFloor(groundFloor);

        Vehicle car = new Car("KA01AB1234");

        Ticket ticket = parking.enterVehicle(car);
        System.out.println("Ticket issued:\n" + ticket);
        System.out.println("\nCurrent status:\n" + parking.getParkingStatus());

        try {
            Thread.sleep(100);

            double fee = parking.exitVehicle(ticket.getTicketId());
            System.out.printf("\nPaid ₹%.2f for parking\n", fee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal status:\n" + parking.getParkingStatus());
    }
}