interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("$" + amount + " paid with credit card ending in " + cardNumber.substring(cardNumber.length() - 4) + ".");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("$" + amount + " paid using PayPal account: " + email);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment method not set.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class Exercise8 {
    public static void main(String[] args) {
        PaymentContext cartContext = new PaymentContext();

        System.out.println("--- Transaction 1 ---");
        
        cartContext.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456"));
        cartContext.executePayment(250.50);

        System.out.println("\n--- Transaction 2 ---");
        
        cartContext.setPaymentStrategy(new PayPalPayment("johndoe@example.com"));
        cartContext.executePayment(45.99);
    }
}