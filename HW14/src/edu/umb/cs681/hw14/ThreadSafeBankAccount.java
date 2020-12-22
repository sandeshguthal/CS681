package edu.umb.cs681.hw14;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount {
	public void withdraw(double amount) {
		lock.lock();
		try {
			
			while(balance<=0) {
				try {
					
					System.out.println(Thread.currentThread().getName()+"Balance in overdraft condition ie below 0");
					sufficientFundsCondition.await();
					
				}catch(InterruptedException ie){
					System.out.println(ie);
					
				}
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + "Value after taking amount " + balance); 
			belowUpperLimitFundsCondition.signalAll();
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			lock.unlock();
			System.out.println("Lock updated to unlock:Withdraw");
		}
		
		
	}
	
	
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	
	
	
	public ThreadSafeBankAccount() {}

	
	public void deposit(double amount) {
		lock.lock();
		try {
			
			while(balance>=500) {
				try {
					System.out.println(Thread.currentThread().getName()+"Balance is over 500 being maxlim");
					belowUpperLimitFundsCondition.await();
					
				}catch(InterruptedException ie) {
					System.out.println(ie);
				}
			}
			balance += amount;
			System.out.println(Thread.currentThread().getName() + "Updated Remaining vale" + balance);
			sufficientFundsCondition.signalAll();
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			lock.unlock();
			System.out.println("Lock updated to unlock:Deposit");
		}
		
	}
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition(); 
	
	
	

}
