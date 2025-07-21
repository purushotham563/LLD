package splitwise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private String groupId;
    private String name;
    private Set<User> groupMembers;
    private Set<Expense>expenses;
   private final NotifierManager notifierManager;

    public Group(String groupId, String name, NotifierManager notifierManager) {
        this.groupId = groupId;
        this.name=name;
        this.notifierManager = notifierManager;
        groupMembers=new HashSet<>();
        expenses=new HashSet<>();

    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Set<User> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }
    public void addExpense(Expense expense){
       expense.calculateShare();
       expenses.add(expense);
       notifierManager.notify("newExpense",expense.getDescription());
    }
    public void addMembers(User user){
        groupMembers.add(user);
        notifierManager.subscribe("newExpense",new NewExpenseNotifier(user));

    }
    public void removeMembers(User user){
        groupMembers.remove(user);
        notifierManager.unSubscribe("newExpense",new NewExpenseNotifier(user));
    }
}
