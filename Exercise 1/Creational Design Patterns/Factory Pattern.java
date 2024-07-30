// FactoryMethodPattern.java
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

abstract class NotificationFactory {
    public abstract Notification createNotification();
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        Notification email = emailFactory.createNotification();
        email.send("Hello via Email!");

        NotificationFactory smsFactory = new SMSNotificationFactory();
        Notification sms = smsFactory.createNotification();
        sms.send("Hello via SMS!");
    }
}
