interface PaymentStrategy { void pay(double amount); }
class CreditCardPayment implements PaymentStrategy { public void pay(double a){ System.out.println("Paid by CC: " + a); } }
class PayPalPayment implements PaymentStrategy { public void pay(double a){ System.out.println("Paid by PayPal: " + a); } }

class PaymentContext {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy s){ strategy = s; }
    public void executePay(double amount){ strategy.pay(amount); }
}

public class StrategyDemo {
    public static void main(String[] args){
        PaymentContext ctx = new PaymentContext();
        ctx.setStrategy(new CreditCardPayment()); ctx.executePay(100);
        ctx.setStrategy(new PayPalPayment()); ctx.executePay(50);
    }
}
