package StructuralDesignPattern.Decorator;

public class Main {
    public interface Notifier{
        void send(String message);
    }
    public static class EmailNotifier implements Notifier{
        private String email;
        public EmailNotifier(String email){
            this.email=email;
        }

        @Override
        public void send(String message) {
            System.out.println("Sending email to "+email+": "+message);
        }


    }
    public static abstract class NotifierDecorator implements Notifier{
        protected Notifier wrappee;
        public NotifierDecorator(Notifier notifier){
            this.wrappee=notifier;
        }

        @Override
        public void send(String message) {
            wrappee.send(message);
        }
    }
    public static class SMSDecorator extends NotifierDecorator{
        private String phoneNo;
        public SMSDecorator(Notifier notifier,String phoneNo){
            super(notifier);
            this.phoneNo=phoneNo;
        }
        @Override
        public void send(String message){
            super.send(message);
            System.out.println("Sending sms to "+phoneNo+": "+message);
        }
    }
    public static class FaceBookDecorator extends NotifierDecorator{
        private String fbUser;
        public FaceBookDecorator(Notifier notifier,String fbUser){
            super(notifier);
            this.fbUser=fbUser;
        }
        @Override
        public void send(String message){
            super.send(message);
            System.out.println("sending facebook message to"+fbUser+": "+message);
        }

    }
    public static class SlackDecorator extends NotifierDecorator{
        private String slackChannel;
        public SlackDecorator(Notifier notifier,String slackChannel){
            super(notifier);
            this.slackChannel=slackChannel;
        }
        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Sending Slack notification to channel " + slackChannel + ": " + message);
        }

    }

    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier("user@example.com");

        // Add decorators as needed
        notifier = new SMSDecorator(notifier, "+1234567890");
        notifier = new FaceBookDecorator(notifier, "john.doe");
        notifier = new SlackDecorator(notifier, "#alerts");

        notifier.send("🔥 House is on fire!");
    }
}
