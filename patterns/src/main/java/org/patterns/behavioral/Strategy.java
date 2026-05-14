package org.patterns.behavioral;

interface PaymentStrategy {
    void pay(int amount);
}

// Concrete implementations of strategy interface that can be dynamically used
class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Amount " + amount + " Paid using Upi.");
    }
}

class CardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Amount " + amount + " Paid using Card.");
    }
}

class CashPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Amount " + amount + " Paid using Cash.");
    }
}

// This class uses the dynamic behavior passed among all the different strategies
class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(int amount){
        paymentStrategy.pay(amount);
    }
}

public class Strategy {
    public static void main(String[] args) {

        PaymentStrategy strategy;
        strategy = new UpiPayment();

        PaymentService service = new PaymentService(strategy);

        strategy = new CardPayment();
        service = new PaymentService(strategy);
        service.processPayment(100000);

    }
}
