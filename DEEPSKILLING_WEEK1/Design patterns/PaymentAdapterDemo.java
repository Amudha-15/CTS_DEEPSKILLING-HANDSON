interface PaymentProcessor { void processPayment(double amount); }

// Adaptees with different interfaces
class StripeGateway { void sendPayment(double amt){ System.out.println("Stripe paid " + amt); } }
class PayPalGateway { void makePayment(double amt){ System.out.println("PayPal paid " + amt); } }

// Adapters
class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripe = new StripeGateway();
    public void processPayment(double amount){ stripe.sendPayment(amount); }
}
class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway pp = new PayPalGateway();
    public void processPayment(double amount){ pp.makePayment(amount); }
}

public class PaymentAdapterDemo {
    public static void main(String[] args){
        PaymentProcessor p1 = new StripeAdapter();
        PaymentProcessor p2 = new PayPalAdapter();
        p1.processPayment(10.0);
        p2.processPayment(20.0);
    }
}
