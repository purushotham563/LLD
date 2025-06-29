public class Payment {
    private String paymentId;
    private double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

    public Payment(String paymentId, double amount
            , PaymentMethod paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public boolean process(){
        boolean success=Math.random()>0.1;
        this.paymentStatus=success?PaymentStatus.COMPLETED:PaymentStatus.FAILED;
        return success;

    }
}
enum PaymentMethod{//hear we can implement strategy pattern
    CREDIT_CARD,DEBIT_CARD,PAYPAL
}
enum PaymentStatus{
    PENDING,COMPLETED,FAILED
}
