package edu.umb.cs681.hw14;


import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable{
	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}
	private boolean done = false;
	
	public DepositRunnable(ThreadSafeBankAccount account) {
		this.accBankAccess = account;
	}
	
	
	public void run() {
		while (true) {
			lock.lock();
			try{
				if (done)
				{
					System.out.println(Thread.currentThread().getId() + " Now processed");
					break;
				}
			}
//			else
				finally {lock.unlock();}
			accBankAccess.deposit(300);
			try 
			{
			Thread.sleep(2000);
			} 
			catch (InterruptedException e) {continue;}
		}
		
	}
	private ThreadSafeBankAccount accBankAccess = null;
	private ReentrantLock lock = new ReentrantLock();

}
