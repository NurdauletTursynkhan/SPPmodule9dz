interface Beverage {
    String getDescription();
    double getCost();
}

class Espresso implements Beverage {
    public String getDescription() {
        return "Espresso";
    }

    public double getCost() {
        return 1.50;
    }
}

class Tea implements Beverage {
    public String getDescription() {
        return "Tea";
    }

    public double getCost() {
        return 1.00;
    }
}

class Latte implements Beverage {
    public String getDescription() {
        return "Latte";
    }

    public double getCost() {
        return 2.00;
    }
}

class Mocha implements Beverage {
    public String getDescription() {
        return "Mocha";
    }

    public double getCost() {
        return 2.50;
    }
}

abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription();
    }

    public double getCost() {
        return beverage.getCost();
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.30;
    }
}

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.10;
    }
}

class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.50;
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Milk(beverage);
        beverage = new Sugar(beverage);
        beverage = new WhippedCream(beverage);

        System.out.println("Drink: " + beverage.getDescription());
        System.out.printf("Total Cost: %.2f%n", beverage.getCost());

        Beverage teaWithMilk = new Milk(new Tea());
        System.out.println("Drink: " + teaWithMilk.getDescription());
        System.out.printf("Total Cost: %.2f%n", teaWithMilk.getCost());
    }
}
