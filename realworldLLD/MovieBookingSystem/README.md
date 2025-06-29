
# BookingSystem

A Java-based Event Booking System implementing various design patterns including Strategy, Factory, and Observer.

## Features

- Event creation (Movies, Concerts)
- Seat management and pricing strategy (Weekday, Weekend)
- Booking system with discounts (Early Bird, Group, Promo Code)
- Payment system with multiple methods and status tracking
- Notification system for seat availability

## Project Structure

```
src/
├── Booking.java                 # Booking entity and status
├── BookingService.java         # Core service to manage bookings
├── ConcertFactory.java         # Factory for Concert events
├── DiscountStrategy.java       # Interface for discount strategies
├── EarlyBirdDiscount.java      # Discount strategy: early bird
├── EmailNotificationService.java  # Observer for seat updates
├── Event.java                  # Event entity
├── EventFactory.java           # Event factory interface
├── GroupDiscount.java          # Discount strategy: group booking
├── Main.java                   # Entry point
├── MovieFactory.java           # Factory for Movie events
├── Payment.java                # Payment entity, method, and status
├── PricingStrategy.java       # Pricing strategy interface
├── PromoCodeDiscount.java     # Discount strategy: promo code
├── Seat.java                   # Seat entity
├── SeatAvailabilityNotifier.java # Notifier for seat availability
├── SeatAvailabilityObserver.java # Observer interface
├── User.java                   # User entity
├── WeekDayPrice.java          # Weekday pricing strategy
├── WeekendPrice.java          # Weekend pricing strategy
```

## Technologies Used

- Java (Core)
- IntelliJ IDEA
- OOP Design Patterns

## How to Run

1. Clone this repository.
2. Open in IntelliJ IDEA or any Java IDE.
3. Run `Main.java` to start the application.

## Notes

- Ensure Java 8+ is installed.
- Extend pricing and discount strategies by implementing their respective interfaces.

## Author

Purushotham Reddy
