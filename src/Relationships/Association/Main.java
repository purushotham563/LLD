package Relationships.Association;

public class Main {
    static class Logger{
        void log(String message){
            System.out.print(message);
        }
    }
    static class Service{
        Logger logger;
        void doWork(){
            logger.log("service is working");
        }
    }
    public static void main(String[] args) {

    }
}
