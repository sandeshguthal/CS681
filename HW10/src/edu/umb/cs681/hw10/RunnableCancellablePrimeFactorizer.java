package edu.umb.cs681.hw10;
import java.util.concurrent.locks.ReentrantLock;


public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();

	public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}

	public void setDone() {
		lock.lock();
		try {
			done = false;
		} finally {
			lock.unlock();
		}
	}

	public void generatePrimeFactors() {
		long divisor = from;
		while (dividend != 1 && divisor <= to) {
			lock.lock();
			try {
				if (divisor > 2 && isEven(divisor)) {
					divisor++;
					continue;
				}
				if (dividend % divisor == 0) {
					factors.add(divisor);
					dividend /= divisor;
				} else {
					if (divisor == 2) {
						divisor++;
					} else {
						divisor += 2;
					}
				}
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		RunnableCancellablePrimeFactorizer generatefactor = new RunnableCancellablePrimeFactorizer(36, 2,
				(long) Math.sqrt(36));
		Thread thread = new Thread(generatefactor);
		System.out.println(
				"Thread #" + thread.getId() + " Range " + generatefactor.getFrom() + "->" + generatefactor.getTo());
		thread.start();
		generatefactor.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(generatefactor.getPrimeFactors() + " are the factors for 36");
		// if i need to run for multiple threads
//		RunnableCancellablePrimeFactorizer generatefactor1 = new RunnableCancellablePrimeFactorizer(36, 2,
//				(long) Math.sqrt(36) / 2);
//		RunnableCancellablePrimeFactorizer generatefactor2 = new RunnableCancellablePrimeFactorizer(36,
//				1 + (long) Math.sqrt(36) / 2, (long) Math.sqrt(36));
//		Thread t1 = new Thread(generatefactor1);
//		Thread t2 = new Thread(generatefactor2);
//		
//		t1.start();
//		t2.start();
//		
//		generatefactor1.setDone();
//		generatefactor2.setDone();
//		
//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		System.out.println();
//
//		System.out.println("MultiThreaded");
//		if(!generatefactor1.getPrimeFactors().isEmpty())
//		{
//			System.out.println(generatefactor1.getPrimeFactors() + " are the factors for first half of 36");
//			System.out.println();
//		}
//		if(!generatefactor2.getPrimeFactors().isEmpty()) {
//		System.out.println(generatefactor2.getPrimeFactors() + " are the factors for are the second half 36");
//		}

	}
}