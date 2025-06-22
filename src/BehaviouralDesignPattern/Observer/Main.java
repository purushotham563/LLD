package BehaviouralDesignPattern.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    static class EventManager{
        private Map<String,List<EventListener>>listeners=new HashMap<>();
        public void subscribe(String eventType,EventListener listener){
            listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);

        }
        public void unsubscribe(String eventType,EventListener listener){
            List<EventListener>eventListeners=listeners.get(eventType);
            if(eventListeners!=null){
                eventListeners.remove(listener);
            }
        }
        public void notify(String eventType,String data){
            List<EventListener>eventListeners=listeners.get(eventType);
            if(eventListeners!=null){
                for(EventListener listener:eventListeners){
                    listener.update(data);
                }
            }

        }


    }
    static class File {
        private String name;

        public File(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void write() {
            // Implementation would write to file
        }
    }
    static class Editor{
        public EventManager events;
        private File file;

        public Editor(){
            this.events=new EventManager();
        }
        public void openFile(String path){
            this.file=new File(path);
            events.notify("open", file.getName());
        }
        public void saveFile(){
            events.notify("save", file.getName());
        }
    }
    interface EventListener{
        void update(String filename);
    }
    static class LoggingListener implements EventListener{
        private File log;
        private String message;
        public LoggingListener(String log_file_name,String message){
            this.log=new File(log_file_name);
            this.message=message;
        }
        @Override
        public void update(String filename){
            String logMessage = message.replace("%s", filename);
            // In real implementation, we would write to the log file
            System.out.println("Log: " + logMessage);
        }
    }
    static class EmailAlertsListener implements EventListener {
        private String email;
        private String message;

        public EmailAlertsListener(String email, String message) {
            this.email = email;
            this.message = message;
        }

        @Override
        public void update(String filename) {
            String emailMessage = message.replace("%s", filename);
            // In real implementation, we would send an email
            System.out.println("Email to " + email + ": " + emailMessage);
        }
    }


    public static void main(String[] args) {
        Editor editor=new Editor();
        LoggingListener logger = new LoggingListener(
                "/path/to/log.txt",
                "Someone has opened the file: %s");
        editor.events.subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener(
                "admin@example.com",
                "Someone has changed the file: %s");
        editor.events.subscribe("save", emailAlerts);
        editor.openFile("test.txt");
        editor.saveFile();
    }
}
