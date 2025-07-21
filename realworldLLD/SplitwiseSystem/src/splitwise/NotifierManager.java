package splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifierManager {
    private final Map<String, List<Notifier>>notification=new HashMap<>();
    public void subscribe(String NotifierName,Notifier notifier){
        notification.computeIfAbsent(NotifierName,k->new ArrayList<>()).add(notifier);
    }
    public void unSubscribe(String NotifierName,Notifier notifier){
        List<Notifier>notifiers=notification.get(NotifierName);
        if(notifier!=null){
            notifiers.remove(notifier);
        }
    }
    public void notify(String NotifierName,String message){
        List<Notifier>notifiers=notification.get(NotifierName);
        if(notifiers!=null){
            for (Notifier notifier :notifiers) {
                notifier.update(message);
            }
        }
    }
}
