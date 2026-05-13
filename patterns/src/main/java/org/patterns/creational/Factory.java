package org.patterns.creational;

// Factory design pattern is used to create objects without exposing the creation logic
// to the client
// Instead of using [ new Object() ] everywhere, we delegate the object creation logic to a
// Factory class
interface Payment {
    void Pay(double amount);
}

class CardPayment implements Payment {
    @Override
    public void Pay(double amount) {
        System.out.println("Amount: " + amount + " successfully paid via card.");
    }
}

class UpiPayment implements Payment {
    @Override
    public void Pay(double amount){
        System.out.println("Amount: " + amount + " succesfully paid via upi.");
    }
}

class CashPayment implements Payment {
    @Override
    public void Pay(double amount){
        System.out.println("Amount: " + amount + " successfully paid via cash.");
    }
}

class PaymentFactory {

    public static Payment getPayment(String str){
        if(str.equalsIgnoreCase("card")){
            return new CardPayment();
        }
        if(str.equalsIgnoreCase("upi")){
            return new UpiPayment();
        }
        if(str.equalsIgnoreCase("cash")){
            return new CashPayment();
        }
        else{
            throw new RuntimeException("Please provide a valid payment type.");
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        Payment p = PaymentFactory.getPayment("upi");
        p.Pay(2987.88);
    }
}
