package edu.umb.cs681.hw16;

import java.util.concurrent.locks.ReentrantLock;

public class DJIAQuoteObservable extends Observable {

    private ReentrantLock threadLock = new ReentrantLock();

    public void changeQuote(float quote) {
        threadLock.lock();
        this.setChanged();
        this.notifyObservers(new DJIAEvent(quote));
        threadLock.unlock();
    }

    public void setQuote(float quote) {
        threadLock.lock();
        this.setChanged();
        notifyObservers(new DJIAEvent(quote));
        threadLock.unlock();
    }

    @Override
    public void setQuote(String sqo, float v) {

    }
}
