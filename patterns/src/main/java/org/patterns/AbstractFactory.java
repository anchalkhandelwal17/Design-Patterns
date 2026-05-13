package org.patterns;

interface NotificationSender {
    void send(String message);
}

interface NotificationTemplate {
    String formatMessage(String message);
}

class EmailNotificationService implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class EmailNotificationTemplate implements NotificationTemplate {
    @Override
    public String formatMessage(String message) {
        return "Email Template: " + message;
    }
}

class SmsNotificationService implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending Sms: " + message);
    }
}

class SmsTemplateService implements NotificationTemplate {

    @Override
    public String formatMessage(String message) {
        return "Sms Template: " + message;
    }
}

interface NotificationFactory {

    NotificationSender createSender();

    NotificationTemplate createTemplate();
}

class EmailNotificationFactory implements NotificationFactory{

    @Override
    public NotificationSender createSender() {
        return new EmailNotificationService();
    }

    @Override
    public NotificationTemplate createTemplate() {
        return new EmailNotificationTemplate();
    }
}

class SmsNotificationFactory implements NotificationFactory{

    @Override
    public NotificationSender createSender() {
        return new SmsNotificationService();
    }

    @Override
    public NotificationTemplate createTemplate() {
        return new SmsTemplateService();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        String str = "sms";

        NotificationFactory factory;

        if(str.equalsIgnoreCase("email")){
            factory = new EmailNotificationFactory();
        }
        else{
            factory = new SmsNotificationFactory();
        }

        NotificationSender sender = factory.createSender();
        NotificationTemplate template = factory.createTemplate();

        String formattedMessage = template.formatMessage("Hello! Welcome");
        sender.send(formattedMessage);

    }
}
