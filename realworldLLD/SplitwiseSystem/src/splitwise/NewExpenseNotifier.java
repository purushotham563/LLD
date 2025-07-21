package splitwise;

public class NewExpenseNotifier implements Notifier{
    User user;
    public NewExpenseNotifier(User user) {
        this.user = user;
    }
    @Override
    public void update(String message) {
        System.out.println(user.getName()+" You have new expense "+message);
    }
}
