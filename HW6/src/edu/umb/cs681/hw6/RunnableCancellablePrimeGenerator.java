package edu.umb.cs681.hw6;

//import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();

	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void setDone() {
		lock.lock();
		try {
			done = false;
		} finally {
			lock.unlock();
		}
	}

	public void generatePrimes() {
		for (long n = from; n <= to; n++) {
			lock.lock();
			try {
				if (done) {
					break;
				}
				if (isPrime(n)) {
					this.primes.add(n);
				}
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		RunnableCancellablePrimeGenerator generatePrime = new RunnableCancellablePrimeGenerator(1, 100);
		Thread thread = new Thread(generatePrime);
		thread.start();
		generatePrime.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println("caught exception");
			e.printStackTrace();
		}
//		ArrayList<Long> newarray= new ArrayList<>();
		// Thougt of adding elements into arraylist from the lamda fundction and then
		// print out the data
		System.out.println("The numbers are: ");
		generatePrime.getPrimes().forEach((Long prime) -> System.out.print(prime + " "));
//		for(Long s:newarray ) {
//			System.out.println(s);
//		}
		System.out.println();

		System.out.println("Total " + generatePrime.getPrimes().size());
	}
}