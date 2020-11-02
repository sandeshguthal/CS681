package edu.umb.cs681.hw1;

public class tester {
	public static void main(String args[]) {
			//create a new observable
		StockQuoteObservable stockQuote = new StockQuoteObservable();
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Notified Stock Event Observer 10");
		});
		stockQuote.changeQuote("Test1", 1);
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Notified Stock Event Observer 20");
		});
		stockQuote.changeQuote("Test2", 2);
		//create a new djia
		DJIAQuoteObservable djiaQuote = new DJIAQuoteObservable();
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Notified DJIA Observer 10");
		});
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Notified DJIA Observer 20");
		});
		djiaQuote.changeQuote("Test2", 200);
	

	}

}
