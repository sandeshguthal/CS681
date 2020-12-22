package edu.umb.cs681.hw16;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Observable {
    private ConcurrentLinkedQueue<Observer> observers;

    private AtomicBoolean changed;

    public Observable() {
        observers = new ConcurrentLinkedQueue<Observer>();
        changed = new AtomicBoolean();
    }

    public void deleteObserver(Observer o) {
        if (observers.contains(o))
            observers.remove(o);
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o))
            observers.add(o);
    }

    protected int countObserver() {
        return observers.size();
    }

    protected void setChanged() {
        changed.set(true);
    }

    protected void clearChanged() {
        changed.set(false);
    }

    public boolean hasChanged() {
        return changed.get();
    }

    public void notifyObservers(Object event) {
        if (hasChanged()) {
            for (Observer o : observers) {
                o.update(this, event);
            }
            clearChanged();
        }
    }


    public abstract void setQuote(String sqo, float v);
}