package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;


public class WithdrawRunnable implements Runnable {
	public WithdrawRunnable(ThreadSafeBankAccount account) {
		this.accBankAccess = account;
	}
	private ThreadSafeBankAccount accBankAccess = null;
	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}
	
	private boolean done = false;
	
	
	public void run() {
		
		while (true) {
			lock.lock();
			try{
				if (done) {
					System.out.println(Thread.currentThread().getName() + "Executed");
					break;
				}
			} finally {
				lock.unlock();
			}
			accBankAccess.withdraw(150);
			try{
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println(e);
				continue;
			}
		}
		
	}
	private ReentrantLock lock = new ReentrantLock();

}
