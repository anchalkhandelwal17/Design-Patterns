package org.patterns.behavioral;

//Strategy Interface
//A common interface or abstract class that defines the method(s) all algorithms must implement.
interface PaymentStrategy {
    void pay(int amount);
}


// Concrete Strategies
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

//Context: The class that maintains a reference to a Strategy object and delegates the task to it.

class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(int amount){
        paymentStrategy.pay(amount);
    }
}

//Client: The code that selects the desired strategy and passes it to the Context.
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
