import java.util.ArrayList;
import java.util.List;

interface Observer { void update(String symbol, double price); }
interface Subject { void register(Observer o); void deregister(Observer o); void notifyObservers(); }

class StockMarket implements Subject {
    private final List<Observer> obs = new ArrayList<>();
    private String symbol; private double price;
    public void setPrice(String symbol, double price){ this.symbol = symbol; this.price = price; notifyObservers(); }
    public void register(Observer o){ obs.add(o); }
    public void deregister(Observer o){ obs.remove(o); }
    public void notifyObservers(){ for (Observer o : obs) o.update(symbol, price); }
}

class MobileApp implements Observer { public void update(String s, double p){ System.out.println("MobileApp: " + s + "=" + p); } }
class WebApp implements Observer { public void update(String s, double p){ System.out.println("WebApp: " + s + "=" + p); } }

public class ObserverDemo {
    public static void main(String[] args){
        StockMarket market = new StockMarket();
        Observer m = new MobileApp(); Observer w = new WebApp();
        market.register(m); market.register(w);
        market.setPrice("AAPL", 150.0);
    }
}
