package splitwise;

import java.sql.ClientInfoStatus;
import java.util.List;

public class EqualSplit implements SplitStrategy{
    private final List<User>users;
    private final double amount;
    private final BalanceSheet balanceSheet;
    public EqualSplit(List<User> users,
                      double amount,BalanceSheet sheet) {
        this.users = users;
        this.amount=amount;
        this.balanceSheet=sheet;
    }

    @Override
    public void calculateSplit(User paidBy) {
        int n=users.size();
        double share=amount/n;
        for(int i=0;i<n;i++){
            if(!users.get(i).equals(paidBy)){
                balanceSheet.updateBalance(users.get(i),paidBy,share);
            }
        }
    }
}
