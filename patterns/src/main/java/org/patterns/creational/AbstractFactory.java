package org.patterns.creational;

//Core Components To understand the pattern, it helps to look at its four main moving parts:

//Abstract Factory: An interface that declares methods for creating each type of abstract product.

//Concrete Factory: Classes that implement the Abstract Factory interface.
//Each concrete factory corresponds to a specific "variant" or "family" of objects.

//Abstract Product: An interface or base class for a type of product (e.g., a generic Button or Chair).

//Concrete Product: The actual, specific implementations of the abstract products (e.g., a WindowsButton or a ModernChair).


interface NotificationSender {
    void send(String message);
}

interface NotificationTemplate {
    String formatMessage(String message);
}

interface NotificationFactory {

    NotificationSender createSender();

    NotificationTemplate createTemplate();
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
