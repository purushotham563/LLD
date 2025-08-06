🚗 Parking Lot Management System
A modular and extensible Parking Lot Management System implemented using Object-Oriented Design Principles and well-known design patterns like Singleton, Strategy, and Factory. The system supports vehicle entry and exit, dynamic fee calculation, and slot management for different types of vehicles.

📌 Features
Vehicle entry and exit with ticket generation

Slot allocation by vehicle type (Bike, Car, Truck)

Admin control for slot and floor management

Dynamic pricing strategies (Hourly / Flat Rate)

Extensible design using SOLID principles

🧱 Class Structure Overview
1. ParkingService
Manages vehicle entry and exit operations.

Uses the singleton ParkingLot for ticket management.

2. AdminService
Allows the admin to manage parking floors and slots.

Can generate status reports.

3. ParkingLot (Singleton Pattern)
Core system class with only one instance.

Holds all parking floors and pricing strategies.

Methods:

generateTicket(vehicle)

processExit(ticketId)

setPricingStrategy(strategy)

4. ParkingFloor
Manages multiple ParkingSlots.

Uses a map grouped by VehicleType for optimized lookup.

Methods:

addParkingSlot(slot)

findAvailableSlot(vehicleType)

5. ParkingSlot
Represents individual parking slots.

Attributes include slotId, slotType, availability, and current vehicle.

Methods:

parkVehicle(vehicle)

unparkVehicle()

canFitVehicle(vehicle)

6. Ticket
Represents a parking ticket.

Contains details like vehicle info, slot, entry/exit time, and calculated fee.

Delegates fee calculation to a FeeCalculationStrategy.

🎯 Design Patterns Used
✅ Singleton Pattern
ParkingLot: Ensures only one parking lot instance exists.

✅ Strategy Pattern
FeeCalculationStrategy: Supports interchangeable fee calculation methods.

HourlyRateStrategy

FlatRateStrategy

✅ Factory Pattern
VehicleFactory: Simplifies creation of different types of vehicles.

🚘 Vehicle Hierarchy
Vehicle (Abstract)
Attributes: licenseNumber, type

Abstract Methods:

getHourlyParkingRate()

Concrete Subclasses:
Bike

Car

Truck

Each implements its own getHourlyParkingRate().

🧠 Fee Calculation Strategy
Implemented via the FeeCalculationStrategy interface.

HourlyRateStrategy

Charges based on hours parked.

FlatRateStrategy

Charges a fixed rate regardless of time.

Each strategy is injected into the Ticket or ParkingLot for flexibility.

🧪 Usage Flow
On Vehicle Entry:
Vehicle created via VehicleFactory

ParkingService.enterVehicle(vehicle) is called

Ticket is generated and slot is allocated

On Vehicle Exit:
ParkingService.exitVehicle(ticketId) is called

Ticket fee is calculated based on strategy

Vehicle is removed from the slot

🗂️ Enums
VehicleType
BIKE

CAR

TRUCK

📈 Extensibility
The system is designed to be open for extension and closed for modification. You can:

Add new vehicle types easily.

Introduce new pricing strategies.

Integrate real-time monitoring or database storage.

📄 Example Enhancements
Add TimeBasedDiscountStrategy

Integrate license plate recognition system

Add UI/REST interface for interaction

Persist tickets and slot states in a database

🧑‍💻 Authors(Purushotham Reddy)
Inspired by common system design interviews and built with object-oriented design best practices in mind.
