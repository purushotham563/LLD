package splitwise;

import java.util.List;

public class Expense {
    private String expenseId;
    private String description;
    private User paidBy;
    private double amount;
    private SplitStrategy splitStrategy;
    List<User>participants;


    public Expense(String expenseId,
                   String name,
                   String description,
                   User paidBy, double amount,
                   SplitStrategy splitStrategy,
                   List<User> participants) {
        this.expenseId = expenseId;
        this.description = description;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitStrategy = splitStrategy;
        this.participants = participants;
    }
    public void calculateShare(){
        splitStrategy.calculateSplit(paidBy);
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
    public void addParticipants(User user){
        participants.add(user);
    }
    public void removeParticipants(User user){
        participants.remove(user);
    }
}
