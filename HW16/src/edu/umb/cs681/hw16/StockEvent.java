package edu.umb.cs681.hw16;

public class StockEvent {

    private String ticker;
    private float quote;

    public String getTicker() {
        return ticker;
    }

    StockEvent() {
        System.out.println("StockEvent created");
    }

    StockEvent(String ticker, float quote) {
        System.out.println("StockEvent created");
        this.ticker = ticker;
        this.quote = quote;
    }

    public float getQuote() {
        return quote;
    }
}
