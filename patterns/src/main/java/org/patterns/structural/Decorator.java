package org.patterns.structural;

// Common Contract
interface Coffee {

    String getDescription();
    int cost();
}

// Base Object
class PlainCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public int cost() {
        return 60;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {

    Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}

// Concrete Decorators
class MilkCoffeeDecorator extends CoffeeDecorator {

    public MilkCoffeeDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public int cost() {
        return coffee.cost() + 20;
    }
}

class ChocolateCoffeeDecorator extends CoffeeDecorator {

    public ChocolateCoffeeDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Chocolate";
    }

    @Override
    public int cost() {
        return coffee.cost() + 30;
    }
}

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new PlainCoffee();
        coffee = new MilkCoffeeDecorator(coffee);
        coffee = new ChocolateCoffeeDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }
}
