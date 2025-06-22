package BehaviouralDesignPattern.Strategy;
public class Main {
    interface PaymentStrategy {
        void pay(PaymentContext context);  // strategy needs access to payment data
    }
    interface PaymentContext {
        double getAmount();  // strategies will use this to get payment amount
    }
    static class ShoppingCart implements PaymentContext {
        private double amount;

        public ShoppingCart(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        // method to use any strategy
        public void checkout(PaymentStrategy strategy) {
            strategy.pay(this);  // pass the context (which gives data access)
        }
    }
    static class UPIPayment implements PaymentStrategy {
        public void pay(PaymentContext context) {
            System.out.println("Paid ₹" + context.getAmount() + " using UPI.");
        }
    }
    static class PayPalPayment implements PaymentStrategy {
        public void pay(PaymentContext context) {
            System.out.println("Paid ₹" + context.getAmount() + " using PayPal.");
        }
    }
    static class CreditCardPayment implements PaymentStrategy {
        public void pay(PaymentContext context) {
            System.out.println("Paid ₹" + context.getAmount() + " using Credit Card.");
        }
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(999.0);

        // Try UPI
        cart.checkout(new UPIPayment());

        // Try PayPal
        cart.checkout(new PayPalPayment());

        // Try Credit Card
        cart.checkout(new CreditCardPayment());

    }

}
