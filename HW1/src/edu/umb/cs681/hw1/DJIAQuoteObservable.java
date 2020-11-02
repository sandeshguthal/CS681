package edu.umb.cs681.hw1;

public class DJIAQuoteObservable extends Observable {
	
	void changeQuote(String ticker, float quote) {
        setChanged();
        notifyObservers(new DJIAEvent(quote));
	}

}
