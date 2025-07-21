package splitwise;

import java.util.List;

public class ExactAmountSplit implements SplitStrategy {

    private final List<User>users;
    private final List<Double>amounts;
    private final BalanceSheet sheet;

    public ExactAmountSplit(List<User> users, List<Double> amounts,BalanceSheet sheet) {
        this.users = users;
        this.amounts = amounts;
        this.sheet=sheet;
    }
    @Override
    public void calculateSplit(User paidBy) {
        for(int i=0;i<users.size();i++){
            User user=users.get(i);
            if(!user.equals(paidBy)){
                sheet.updateBalance(user,paidBy,amounts.get(i));
            }

        }
    }
}
