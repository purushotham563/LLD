import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
  private final String ticketid;
  private final Vehicle vehicle;
  private final ParkingSlot slot;
  private final LocalDateTime entryTime;
  private LocalDateTime exitTime;
  private double fee;
  private boolean paid;
  private FeeCalculationStrategy feeStrategy;

    public Ticket(String ticketid, Vehicle vehicle, ParkingSlot slot,FeeCalculationStrategy feeCalculationStrategy)
    {
        this.ticketid = ticketid;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
        this.exitTime=null;
        this.fee=0.0;
        this.paid=false;
        this.feeStrategy=feeCalculationStrategy;
    }
    public double calculateFee() {
        if (exitTime == null) {
            throw new IllegalStateException("Exit time not set");
        }


        this.fee = feeStrategy.calculateFee(this);
        return this.fee;
    }
    public void setFeeStrategy(FeeCalculationStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }
    public void markPaid() {
        this.paid = true;
    }

    // Getters
    public String getTicketId() {
        return ticketid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getFee() {
        return fee;
    }

    public boolean isPaid() {
        return paid;
    }

}
