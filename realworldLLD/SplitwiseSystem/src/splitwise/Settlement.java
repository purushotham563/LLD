package splitwise;

public class Settlement {
    private final BalanceSheet balanceSheet;


    public Settlement(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
    public void makePayment(User from, User to, double amount) {
        double currentBalance = balanceSheet.getBalance(from, to);
        if (currentBalance < amount) {
            throw new IllegalArgumentException(from.getName() +
                    " doesn't owe " + to.getName() + " that much");
        }
        balanceSheet.updateBalance(from, to, -amount);
    }

}
