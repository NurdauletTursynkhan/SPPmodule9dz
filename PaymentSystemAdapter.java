interface IPaymentProcessor {
    void processPayment(double amount);
}

class PayPalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " via PayPal.");
    }
}

class StripePaymentService {
    public void makeTransaction(double totalAmount) {
        System.out.println("Processing payment of " + totalAmount + " via Stripe.");
    }
}

class StripePaymentAdapter implements IPaymentProcessor {
    private final StripePaymentService stripeService;

    public StripePaymentAdapter(StripePaymentService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void processPayment(double amount) {
        stripeService.makeTransaction(amount);
    }
}

class SquarePaymentService {
    public void processSquarePayment(double amount) {
        System.out.println("Processing payment of " + amount + " via Square.");
    }
}

class SquarePaymentAdapter implements IPaymentProcessor {
    private final SquarePaymentService squareService;

    public SquarePaymentAdapter(SquarePaymentService squareService) {
        this.squareService = squareService;
    }

    @Override
    public void processPayment(double amount) {
        squareService.processSquarePayment(amount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        // Работа с PayPal
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        paypalProcessor.processPayment(100.0);

        // Работа с Stripe через адаптер
        StripePaymentService stripeService = new StripePaymentService();
        IPaymentProcessor stripeAdapter = new StripePaymentAdapter(stripeService);
        stripeAdapter.processPayment(200.0);

        // Работа с Square через адаптер
        SquarePaymentService squareService = new SquarePaymentService();
        IPaymentProcessor squareAdapter = new SquarePaymentAdapter(squareService);
        squareAdapter.processPayment(300.0);
    }
}
