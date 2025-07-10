# ParkingSystem

A Java-based Smart Parking Management System implementing various design patterns including Strategy, Singleton, and Factory patterns.

## Features

- Multi-floor parking lot management
- Vehicle type support (Car, Bike, Truck)
- Dynamic fee calculation strategies (Flat Rate, Hourly Rate)
- Slot allocation and availability tracking
- Ticket generation and processing
- Real-time parking status monitoring
- Vehicle parking and exit management
- Administrative controls and reporting

## Project Structure

```
src/
├── AdminService.java              # Administrative operations and reporting
├── Bike.java                     # Bike vehicle implementation
├── Car.java                      # Car vehicle implementation
├── FeeCalculationStrategy.java   # Strategy pattern interface for fee calculation
├── FlatFeeStrategy.java          # Flat fee calculation strategy
├── HourlyFeeStrategy.java        # Hourly fee calculation strategy
├── Main.java                     # Entry point and system demonstration
├── ParkingFloor.java             # Floor management and slot operations
├── ParkingLot.java               # Main parking lot entity (Singleton)
├── ParkingService.java           # Core parking operations service
├── ParkingSlot.java              # Individual parking slot entity
├── Ticket.java                   # Parking ticket entity
├── Truck.java                    # Truck vehicle implementation
├── Vehicle.java                  # Abstract base class for all vehicles
├── VehicleFactory.java           # Factory pattern for vehicle creation
├── VehicleType.java              # Enum for vehicle types (BIKE, CAR, TRUCK)
```

## UML Class Diagram

![ParkingSystemUML](https://github.com/user-attachments/assets/your-parking-image-id-here)

## Design Patterns Used

### Strategy Pattern
- **FeeCalculationStrategy**: Interface defining fee calculation algorithms
- **FlatFeeStrategy**: Fixed fee calculation implementation
- **HourlyFeeStrategy**: Time-based fee calculation implementation

### Singleton Pattern
- **ParkingLot**: Ensures single instance of parking lot with global access
- Implements thread-safe singleton with static instance and private constructor

### Factory Pattern
- **VehicleFactory**: Creates vehicle instances based on vehicle type
- Encapsulates vehicle creation logic and supports extensibility

## Technologies Used

- Java 8+ (Core, Collections, LocalDateTime)
- Object-Oriented Programming principles
- Design Patterns implementation
- IntelliJ IDEA

## How to Run

1. Clone this repository
2. Open in IntelliJ IDEA or any Java IDE
3. Run `Main.java` to start the application
4. The system will demonstrate:
   - Vehicle parking operations
   - Fee calculation with different strategies
   - Slot availability management
   - Ticket generation and processing
   - Administrative reporting

## Key Features Demonstrated

- **Smart Slot Assignment**: Automatically finds available slots based on vehicle type
- **Flexible Fee Calculation**: Switch between flat rate and hourly rate strategies
- **Multi-Floor Support**: Manages multiple parking floors with different slot configurations
- **Vehicle Type Management**: Handles different vehicle types with specific parking requirements
- **Ticket System**: Generates unique tickets with entry/exit time tracking
- **Administrative Tools**: Provides status reports and management functions

## System Configuration

- **Configurable Floors**: Add multiple floors with customizable slot distribution
- **Vehicle Types**: Support for Car, Bike, and Truck with different rates
- **Fee Strategies**: Easily switch between pricing models
- **Slot Management**: Dynamic slot allocation based on vehicle type

## Class Relationships

- **ParkingLot** (Singleton) manages multiple **ParkingFloor** instances
- **ParkingFloor** contains multiple **ParkingSlot** instances organized by vehicle type
- **Ticket** associates **Vehicle** with **ParkingSlot** and tracks timing
- **FeeCalculationStrategy** implementations calculate parking fees
- **VehicleFactory** creates **Vehicle** instances based on **VehicleType**

## Extensibility

- Add new vehicle types by extending **Vehicle** class and updating **VehicleType** enum
- Implement new fee strategies by implementing **FeeCalculationStrategy** interface
- Extend administrative features through **AdminService** class
- Add new floor configurations and slot types as needed

## Notes

- Ensure Java 8+ is installed for LocalDateTime and modern collection features
- The system uses LocalDateTime for accurate time tracking and fee calculation
- Extend fee calculation strategies by implementing the FeeCalculationStrategy interface
- Add new vehicle types by extending the Vehicle class and updating the factory

## Author

Purushotham Reddy
