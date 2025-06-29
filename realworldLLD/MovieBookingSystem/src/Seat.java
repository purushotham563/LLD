public class Seat {
    private String seatId;
    private String selection;
    private double basePrice;
    private boolean isAvailable;

    public Seat(String seatId, String selection, double basePrice) {
        this.seatId = seatId;
        this.selection = selection;
        this.basePrice = basePrice;
        this.isAvailable=true;
    }
    public synchronized void reserve(){
        if(isAvailable){
            isAvailable=false;
        }
    }
    public synchronized void release(){
        if(!isAvailable){
            isAvailable=true;
        }
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSelection() {
        return selection;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
