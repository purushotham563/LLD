package splitwise;

import java.util.HashMap;

public class BalanceSheet {
    private final HashMap<User,HashMap<User,Double>>balances;
    NotifierManager notifierManager;
    public BalanceSheet(){
        balances=new HashMap<>();
        notifierManager=new NotifierManager();
    }

    public void updateBalance(User payer,User receiver,double amount){
        balances.computeIfAbsent(payer,
                k->new HashMap<>()).merge(receiver,amount,Double::sum);
        balances.computeIfAbsent(receiver,k->new HashMap<>()).merge(payer,-amount,
                Double::sum);

    }
    public double getBalance(User user1,User user2){
        return balances.getOrDefault(user1,new HashMap<>()).getOrDefault(user2,0.0);
    }

}
