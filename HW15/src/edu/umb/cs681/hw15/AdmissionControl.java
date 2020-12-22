package edu.umb.cs681.hw15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionControl {
	
	
	private ReentrantLock lock = new ReentrantLock();
	public int countCurrentVisitors() {
		lock.lock();
		try {
			return visitorCount;
		} finally {
			lock.unlock();
		}
	}
	private Condition exitCondition = lock.newCondition();

	public void enter() {
		lock.lock();
		try {
			while (visitorCount >= 5) {
				try {
					System.out.println("Visitors exceeded");
					entryCondition.await();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			visitorCount++;
			exitCondition.signalAll();
			System.out.println("Count updated : " + visitorCount);
		} finally {
			lock.unlock();
		}
	}
	
	private Condition entryCondition = lock.newCondition();
	public void exit() {
		lock.lock();
		try {
			while (visitorCount <= 0) {
				try {
					System.out.println("No current visitors");
					exitCondition.await();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			visitorCount--;
			entryCondition.signalAll();
			System.out.println("New count is = : " + visitorCount);
		} finally {
			lock.unlock();
		}
	}
	private static int visitorCount = 0;
}
