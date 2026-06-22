public interface PaymentProcessor {
    void processPayment();
}

class StripeGateway {
    public void makePayment() {
        System.out.println("Processing payment through Stripe Gateway.");
    }
}

class PayPalGateway {
    public void sendPayment() {
        System.out.println("Processing payment through PayPal Gateway.");
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment() {
        
        stripeGateway.makePayment();
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment() {
        
        payPalGateway.sendPayment();
    }
}

class TestAdapterPattern {
    public static void main(String[] args) {
        System.out.println("--- Testing Stripe Adapter ---");
        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment();

        System.out.println("\n--- Testing PayPal Adapter ---");
        PayPalGateway payPal = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        payPalProcessor.processPayment();
    }
}