package edu.umb.cs681.hw1;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable {
	private List<Observer> observers = new LinkedList<Observer>();

	private boolean changed = false;

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
		changed = true;
	}

	protected void clearChanged() {
		changed = false;
	}

	public boolean hasChanged() {
		return changed;
	}

	public void notifyObservers(Object event) {
		if (hasChanged()) {
			for (Observer o : observers) {
				o.update(this, event);
			}
			clearChanged();
		}
	}
}
