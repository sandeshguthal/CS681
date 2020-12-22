package edu.umb.cs681.hw16;

public class StockQuoteObservable extends Observable {

    public void setQuote() {
        this.setChanged();
    }
    public void changeQuote(String ticker, float g) {
        this.setChanged();
        this.notifyObservers(new StockEvent(ticker, g));
    }


    @Override
    public void setQuote(String sqo, float v) {

    }
}
