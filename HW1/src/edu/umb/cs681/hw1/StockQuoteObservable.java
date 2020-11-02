package edu.umb.cs681.hw1;

public class StockQuoteObservable extends Observable {
	
    public void changeQuote(String ticker, float g) {
        this.setChanged();
        this.notifyObservers(new StockEvent(ticker, g));
    }
    

}
