public class FlatFeeStrategy implements FeeCalculationStrategy {
    private final double flatRate;

    public FlatFeeStrategy(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        return flatRate;
    }
}
