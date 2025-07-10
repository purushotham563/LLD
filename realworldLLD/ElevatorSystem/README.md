# ElevatorSystem

A Java-based Enhanced Elevator System implementing various design patterns including State, Command, and Strategy patterns.

## Features

- Multi-elevator management system
- State-based elevator behavior (Moving Up/Down, Idle, Maintenance)
- Command pattern for undoable operations
- Priority queue-based floor scheduling
- Emergency alarm and maintenance mode
- Real-time elevator status monitoring
- Capacity management and load tracking
- Automatic door control with timing

## Project Structure

```
src/
├── AddDestinationCommand.java     # Command for adding elevator destinations
├── Direction.java                 # Enum for elevator directions (UP, DOWN, IDLE)
├── DoorStatus.java               # Enum for door status (OPEN, CLOSED)
├── Elevator.java                 # Core elevator entity with state management
├── ElevatorBehavior.java         # State pattern interface for elevator behaviors
├── ElevatorCommand.java          # Command pattern interface
├── ElevatorController.java       # Main controller managing multiple elevators
├── ElevatorState.java            # Enum for elevator states (MOVING, IDLE, MAINTENANCE)
├── IdleBehavior.java            # State: elevator idle behavior
├── Main.java                     # Entry point (EnhancedElevatorSystem)
├── MaintenanceBehavior.java      # State: maintenance mode behavior
├── MovingDownBehavior.java       # State: moving down behavior
├── MovingUpBehavior.java         # State: moving up behavior
├── Request.java                  # Request entity for elevator calls
├── RequestElevatorCommand.java   # Command for requesting elevators
```

## UML Class Diagram

![ElevatorSystemUML](https://github.com/user-attachments/assets/your-image-id-here)

## Design Patterns Used

### State Pattern
- **ElevatorBehavior**: Interface defining elevator behavior
- **MovingUpBehavior**: Handles upward movement logic
- **MovingDownBehavior**: Handles downward movement logic
- **IdleBehavior**: Handles idle state operations
- **MaintenanceBehavior**: Handles maintenance mode restrictions

### Command Pattern
- **ElevatorCommand**: Interface for executable and undoable commands
- **RequestElevatorCommand**: Encapsulates elevator requests
- **AddDestinationCommand**: Encapsulates destination additions

## Technologies Used

- Java 8+ (Core, Concurrent Collections, Streams)
- ScheduledExecutorService for real-time operations
- PriorityQueue for efficient floor scheduling
- IntelliJ IDEA

## How to Run

1. Clone this repository
2. Open in IntelliJ IDEA or any Java IDE
3. Run `EnhancedElevatorSystem.java` (Main class) to start the application
4. The system will automatically demonstrate:
   - Elevator requests from different floors
   - Destination selections
   - Command undo functionality
   - Real-time status updates

## Key Features Demonstrated

- **Smart Elevator Assignment**: Finds the best available elevator based on distance and capacity
- **Efficient Scheduling**: Uses priority queues for optimal floor visiting order
- **Undo Operations**: Command pattern allows undoing recent elevator operations
- **State Management**: Elevator behavior changes dynamically based on current state
- **Emergency Handling**: Support for maintenance mode and emergency alarms
- **Real-time Monitoring**: Continuous status updates every second

## System Configuration

- **Default Setup**: 3 elevators, 10 floors, capacity of 10 people each
- **Configurable**: Number of elevators, floors, and capacity can be adjusted
- **Thread-Safe**: Uses concurrent collections for multi-threaded operations

## Notes

- Ensure Java 8+ is installed for Stream API and concurrent collections
- The system uses ScheduledExecutorService for real-time simulation
- Extend elevator behaviors by implementing the ElevatorBehavior interface
- Add new commands by implementing the ElevatorCommand interface

## Author

Purushotham Reddy