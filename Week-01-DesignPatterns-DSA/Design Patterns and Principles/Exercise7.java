import java.util.ArrayList;
import java.util.List;

public interface Stock {
    public void regiter(Observer o);
    public void deRegister(Observer o);
    public void notifyObservers(); 
}

class StockMarket implements Stock {
    private String symbol;
    private double price;
    private List<Observer> observers;
    
    public StockMarket(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.observers = new ArrayList<>();
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
    
    @Override
    public void regiter(Observer o) {
        observers.add(o);
    }
    
    @Override
    public void deRegister(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(this);
        }
    }
}   

interface Observer {
    void update(StockMarket stockMarket);
}

class MobileApp implements Observer {
    @Override
    public void update(StockMarket stockMarket) {
        System.out.println("MobileApp Alert: Stock " + stockMarket.getSymbol() + " has updated to $" + stockMarket.getPrice());
    }
}

class WebApp implements Observer {
    @Override
    public void update(StockMarket stockMarket) {
        System.out.println("WebApp Alert: Stock " + stockMarket.getSymbol() + " has updated to $" + stockMarket.getPrice());
    }
}

class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket techStock = new StockMarket("AAPL", 150.0);
        
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();
        
        techStock.regiter(mobileApp);
        techStock.regiter(webApp);
        
        System.out.println("--- First price update ---");
        techStock.setPrice(155.0);
        
        System.out.println("\n--- Deregistering WebApp ---");
        techStock.deRegister(webApp);
        
        System.out.println("\n--- Second price update ---");
        techStock.setPrice(160.0);
    }
}