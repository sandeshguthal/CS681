package edu.umb.cs681.hw16;

import java.util.Random;

public class Tester {
    public static void main(String[] args) {

        DJIAQuoteObservable obj1 = new DJIAQuoteObservable();
        String quote = "xyz";
        Float val = 400.0f;

        Random random = new Random();

        obj1.addObserver((Observable o, Object obj) -> {
            Float time = ((DJIAEvent) obj).getDjia();
            System.out.println("Observer number 1 -> DIJA event: " + time);
        });
        
        obj1.addObserver((Observable o, Object obj) -> {
            Float time = ((DJIAEvent) obj).getDjia();
            System.out.println("Observer number 2 -> DIJA event: " + time);
        });
        
        System.out.println("Observers Count: " + obj1.countObserver());

        System.out.println("Add new DJIAQuote: " + quote);
        obj1.setQuote(val);

        val = 500.0f;
        System.out.println("DJIA changed");
        obj1.changeQuote(val);


        StockQuoteObservable stockObserverObj = new StockQuoteObservable();
        String code = "SQO";
        Float value = 1000.0f;

        stockObserverObj.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float q = ((StockEvent) obj).getQuote();
            System.out.println(" Observer 1 - Stock event: " + ticker + " " + q);
        });

        stockObserverObj.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float q = ((StockEvent) obj).getQuote();
            System.out.println("Observer 2 - Stock event: " + ticker + " " + q);
        });
        
        stockObserverObj.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float q = ((StockEvent) obj).getQuote();
            System.out.println(" Observer 3 - Stock event: " + ticker + " " + q);
        });
        
        stockObserverObj.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float q = ((StockEvent) obj).getQuote();
            System.out.println(" Observer 4 - Stock event: " + ticker + " " + q);
        });
        
        stockObserverObj.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float q = ((StockEvent) obj).getQuote();
            System.out.println(" Observer 5 - Stock event: " + ticker + " " + q);
        });

        System.out.println("Observers Count: " + stockObserverObj.countObserver());

        System.out.println("Add new Stock: " + code);
        stockObserverObj.setQuote(code, value);

        value = 2000.0f;
        System.out.println("SQuote changed");
        stockObserverObj.changeQuote(code, value);

        Thread thread1  = new Thread(() ->{ obj1.setQuote(random.nextFloat()*100f + 13000f);
            obj1.notifyObservers(new DJIAEvent(random.nextFloat()*100f + 13000f));});
        Thread thread2  = new Thread(() ->{ obj1.setQuote(random.nextFloat()*100f + 13000f);
            obj1.notifyObservers(new DJIAEvent(random.nextFloat()*100f + 13000f));});
        Thread thread3  = new Thread(() ->{ obj1.setQuote(random.nextFloat()*100f + 13000f);
        obj1.notifyObservers(new DJIAEvent(random.nextFloat()*100f + 13000f));});

        thread1.start();
        thread2.start();
        thread3.start();

        Thread stockThread1  = new Thread(() ->{ stockObserverObj.setQuote("SQuote", random.nextFloat()*10f + 200f);
            stockObserverObj.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 200f));});
        Thread stockThread2  = new Thread(() ->{ stockObserverObj.setQuote("SQO", random.nextFloat()*10f + 200f);
            stockObserverObj.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 200f));});
        Thread stockThread3  = new Thread(() ->{ stockObserverObj.setQuote("SQO", random.nextFloat()*10f + 200f);
        stockObserverObj.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 200f));});
        Thread stockThread4  = new Thread(() ->{ stockObserverObj.setQuote("SQO", random.nextFloat()*10f + 200f);
        stockObserverObj.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 200f));});
        Thread stockThread5  = new Thread(() ->{ stockObserverObj.setQuote("SQO", random.nextFloat()*10f + 200f);
        stockObserverObj.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 200f));});

        stockThread1.start();
        stockThread2.start();
        stockThread3.start();
        stockThread4.start();
        stockThread5.start();
        


        try {
            thread1.join();
            thread2.join();
            thread3.join();

            stockThread1.join();
            stockThread2.join();
            stockThread3.join();
            stockThread4.join();
            stockThread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



