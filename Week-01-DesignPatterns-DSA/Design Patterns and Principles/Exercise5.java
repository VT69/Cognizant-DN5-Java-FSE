public interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("Sending Email: " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void send(String msg) {
        wrappedNotifier.send(msg);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg); 
        sendSMS(msg);   
    }

    private void sendSMS(String msg) {
        System.out.println("Sending SMS: " + msg);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg); 
        sendSlack(msg);  
    }

    private void sendSlack(String msg) {
        System.out.println("Sending Slack message: " + msg);
    }
}

class TestDecoratorPattern {
    public static void main(String[] args) {
        System.out.println("--- Sending only Email ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello World!");

        System.out.println("\n--- Sending Email + SMS ---");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Alert: System update!");

        System.out.println("\n--- Sending Email + SMS + Slack ---");
        Notifier allNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        allNotifier.send("CRITICAL: Server down!");
    }
}