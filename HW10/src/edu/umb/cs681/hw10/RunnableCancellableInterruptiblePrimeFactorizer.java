package edu.umb.cs681.hw10;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}
	
	public void setDone(){
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
	}

	public void generatePrimeFactors(){
		long divisor = from;
		while( dividend != 1 && divisor <= to ){
			lock.lock();
			try{
				if (done){
					System.out.println("Factors generation stopped");
					this.factors.clear();
					break;
				}
				if( divisor > 2 && isEven(divisor)) {
					divisor++;
					continue;
				}
				if(dividend % divisor == 0) {
					factors.add(divisor);
					System.out.println(divisor);
					dividend /= divisor;
				}else {
					if(divisor==2){ divisor++; }
					else{ divisor += 2; }
				}
			} finally {
				lock.unlock();
			}

			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeFactorizer generatePrimeFactors = new RunnableCancellableInterruptiblePrimeFactorizer(36,6, 30);
		Thread thread = new Thread(generatePrimeFactors);
		thread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		generatePrimeFactors.setDone();
		thread.interrupt();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("primeFactors:");
		System.out.println(generatePrimeFactors.getPrimeFactors());
	}

}