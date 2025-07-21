import splitwise.*;

import java.util.List;

public class Main {
    private static void printBalances(BalanceSheet sheet, User... users) {
        for (User user1 : users) {
            for (User user2 : users) {
                if (!user1.equals(user2)) {
                    double balance = sheet.getBalance(user1, user2);
                    if (balance > 0) {
                        System.out.printf(
                                "%s owes %s: $%.2f\n",
                                user1.getName(), user2.getName(), balance
                        );
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        User alice = new User("u1", "Alice", "alice@example.com");
        User bob = new User("u2", "Bob", "bob@example.com");
        User charlie = new User("u3", "Charlie", "charlie@example.com");
        NotifierManager notifierManager = new NotifierManager();
        Group tripGroup = new Group("g1", "Road Trip", notifierManager);
        tripGroup.addMembers(alice);
        tripGroup.addMembers(bob);
        tripGroup.addMembers(charlie);
        BalanceSheet sheet=new BalanceSheet();
        List<User> participants = List.of(alice, bob, charlie);
        EqualSplit equalSplit = new EqualSplit(participants, 300.0,sheet);
        Expense dinnerExpense = new Expense(
                "e1", "Dinner",
                "Pizza", alice, 300.0, equalSplit,
                participants
        );
        tripGroup.addExpense(dinnerExpense);
        System.out.println("\n--- Balances After Equal Split ---");
        printBalances(sheet,alice,bob,charlie);
        Settlement settlement=new Settlement(sheet);
        settlement.makePayment(bob,alice,100);
        System.out.println("After settlement");
        printBalances(sheet,alice,bob,charlie);
    }
}