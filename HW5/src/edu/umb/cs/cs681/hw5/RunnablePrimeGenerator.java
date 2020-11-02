package edu.umb.cs.cs681.hw5;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		RunnablePrimeGenerator generatePrime = new RunnablePrimeGenerator(1L, 2000000L);
		Thread t = new Thread(generatePrime);

		long startTime = System.currentTimeMillis();
		t.start();

		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		float firstimecal = (endTime - startTime) / 1000F;

		generatePrime.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		System.out.println("\nNumber of primes in 1 - 2000000 :\t" + generatePrime.getPrimes().size());
		System.out.println("\nTime take for a single thread primes in  1 - 2000000 is  :\t" + firstimecal);
		System.out.println("Two Threads");

		RunnablePrimeGenerator generatePrime1 = new RunnablePrimeGenerator(1L, 1000000L);
		RunnablePrimeGenerator generatePrime2 = new RunnablePrimeGenerator(1000000L, 2000000L);
		Thread t1 = new Thread(generatePrime1);
		Thread t2 = new Thread(generatePrime2);

		startTime = System.currentTimeMillis();
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		endTime = System.currentTimeMillis();
		float twoThreads = (endTime - startTime) / 1000F;

		long twoThreadPrimes = generatePrime1.getPrimes().size() + generatePrime2.getPrimes().size();
		System.out.println("\n" + twoThreadPrimes +" " + "Total Primes.");
		System.out.println("\nTime take for a Two threads primes in  1 - 2000000 is  :\t" + twoThreads);
		
		System.out.println();
		
		System.out.println("Four Threads");

		RunnablePrimeGenerator generatePrime3 = new RunnablePrimeGenerator(1L, 500000L);
		RunnablePrimeGenerator generatePrime4 = new RunnablePrimeGenerator(500000L, 1000000L);
		RunnablePrimeGenerator generatePrime5 = new RunnablePrimeGenerator(1000000L, 1500000L);
		RunnablePrimeGenerator generatePrime6 = new RunnablePrimeGenerator(1500000L, 2000000L);

		Thread t3 = new Thread(generatePrime3);
		Thread t4 = new Thread(generatePrime4);
		Thread t5 = new Thread(generatePrime5);
		Thread t6 = new Thread(generatePrime6);

		startTime = System.currentTimeMillis();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

		try {
			t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
		}

		endTime = System.currentTimeMillis();
		float fourThreads = (endTime - startTime) / 1000F;

		long fourThreadPrimes = generatePrime3.getPrimes().size() + generatePrime4.getPrimes().size()
				+ generatePrime5.getPrimes().size() + generatePrime6.getPrimes().size();


		System.out.println("\n" + fourThreadPrimes +" " + "Total Primes.");
		System.out.println("\nTime take for a Four threads primes in  1 - 2000000 is  :\t" + fourThreads);
		System.out.println();
		
		System.out.println("Eight Threads");

		RunnablePrimeGenerator generatePrime7 = new RunnablePrimeGenerator(1L, 250000L);
		RunnablePrimeGenerator generatePrime8 = new RunnablePrimeGenerator(250000L, 500000L);
		RunnablePrimeGenerator generatePrime9 = new RunnablePrimeGenerator(500000L, 750000L);
		RunnablePrimeGenerator generatePrime10 = new RunnablePrimeGenerator(750000L, 1000000L);
		RunnablePrimeGenerator generatePrime11 = new RunnablePrimeGenerator(1000000L, 1250000L);
		RunnablePrimeGenerator generatePrime12 = new RunnablePrimeGenerator(1250000L, 1500000L);
		RunnablePrimeGenerator generatePrime13 = new RunnablePrimeGenerator(1500000L, 1750000L);
		RunnablePrimeGenerator generatePrime14 = new RunnablePrimeGenerator(1750000L, 2000000L);

		Thread t7 = new Thread(generatePrime7);
		Thread t8 = new Thread(generatePrime8);
		Thread t9 = new Thread(generatePrime9);
		Thread t10 = new Thread(generatePrime10);
		Thread t11 = new Thread(generatePrime11);
		Thread t12 = new Thread(generatePrime12);
		Thread t13 = new Thread(generatePrime13);
		Thread t14 = new Thread(generatePrime14);

		startTime = System.currentTimeMillis();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		t14.start();

		try {
			t7.join();
			t8.join();
			t9.join();
			t10.join();
			t11.join();
			t12.join();
			t13.join();
			t14.join();
		} catch (InterruptedException e) {
		}

		endTime = System.currentTimeMillis();
		float eightThreads = (endTime - startTime) / 1000F;

		long eightThreadPrimes = generatePrime7.getPrimes().size() + generatePrime8.getPrimes().size()
				+ generatePrime9.getPrimes().size() + generatePrime10.getPrimes().size()
				+ generatePrime11.getPrimes().size() + generatePrime12.getPrimes().size()
				+ generatePrime13.getPrimes().size() + generatePrime14.getPrimes().size();

		System.out.println("\n" + eightThreadPrimes +" " + "Total Primes.");
		System.out.println("\nTime take for a Eight threads primes in  1 - 2000000 is  :\t" + eightThreads);
		System.out.println();
		System.out.println("Sixteen Threads");

		RunnablePrimeGenerator generatePrime15 = new RunnablePrimeGenerator(1L, 125000L);
		RunnablePrimeGenerator generatePrime16 = new RunnablePrimeGenerator(125000L, 250000L);
		RunnablePrimeGenerator generatePrime17 = new RunnablePrimeGenerator(250000L, 375000L);
		RunnablePrimeGenerator generatePrime18 = new RunnablePrimeGenerator(375000L, 500000L);
		RunnablePrimeGenerator generatePrime19 = new RunnablePrimeGenerator(500000L, 625000L);
		RunnablePrimeGenerator generatePrime20 = new RunnablePrimeGenerator(625000L, 750000L);
		RunnablePrimeGenerator generatePrime21 = new RunnablePrimeGenerator(750000L, 875000L);
		RunnablePrimeGenerator generatePrime22 = new RunnablePrimeGenerator(875000L, 1000000L);
		RunnablePrimeGenerator generatePrime23 = new RunnablePrimeGenerator(1000000L, 1250000L);
		RunnablePrimeGenerator generatePrime24 = new RunnablePrimeGenerator(1250000L, 1375000L);
		RunnablePrimeGenerator generatePrime25 = new RunnablePrimeGenerator(1375000L, 1500000);
		RunnablePrimeGenerator generatePrime26 = new RunnablePrimeGenerator(1500000L, 1625000L);
		RunnablePrimeGenerator generatePrime27 = new RunnablePrimeGenerator(1625000L, 1750000L);
		RunnablePrimeGenerator generatePrime28 = new RunnablePrimeGenerator(1750000L, 1875000L);
		RunnablePrimeGenerator generatePrime29 = new RunnablePrimeGenerator(1875000L, 2000000L);

		Thread t15 = new Thread(generatePrime15);
		Thread t16 = new Thread(generatePrime16);
		Thread t17 = new Thread(generatePrime17);
		Thread t18 = new Thread(generatePrime18);
		Thread t19 = new Thread(generatePrime19);
		Thread t20 = new Thread(generatePrime20);
		Thread t21 = new Thread(generatePrime21);
		Thread t22 = new Thread(generatePrime22);
		Thread t23 = new Thread(generatePrime23);
		Thread t24 = new Thread(generatePrime24);
		Thread t25 = new Thread(generatePrime25);
		Thread t26 = new Thread(generatePrime26);
		Thread t27 = new Thread(generatePrime27);
		Thread t28 = new Thread(generatePrime28);
		Thread t29 = new Thread(generatePrime29);
		startTime = System.currentTimeMillis();
		t15.start();
		t16.start();
		t17.start();
		t18.start();
		t19.start();
		t20.start();
		t21.start();
		t22.start();
		t23.start();
		t24.start();
		t25.start();
		t26.start();
		t27.start();
		t28.start();
		t29.start();

		try {
			t15.join();
			t16.join();
			t17.join();
			t18.join();
			t19.join();
			t20.join();
			t21.join();
			t22.join();
			t23.join();
			t24.join();
			t25.join();
			t26.join();
			t27.join();
			t28.join();
			t29.join();

		} catch (InterruptedException e) {
		}

		endTime = System.currentTimeMillis();
		float sixteenThreads = (endTime - startTime) / 1000F;

		long sixteenThreadPrimes = generatePrime15.getPrimes().size() + generatePrime16.getPrimes().size()
				+ generatePrime17.getPrimes().size() + generatePrime18.getPrimes().size()
				+ generatePrime19.getPrimes().size() + generatePrime20.getPrimes().size()
				+ generatePrime21.getPrimes().size() + generatePrime22.getPrimes().size()
				+ generatePrime23.getPrimes().size() + generatePrime24.getPrimes().size()
				+ generatePrime25.getPrimes().size() + generatePrime26.getPrimes().size()
				+ generatePrime27.getPrimes().size() + generatePrime28.getPrimes().size()
				+ generatePrime29.getPrimes().size();

		System.out.println("\n" + sixteenThreadPrimes +" " + "Total Primes.");
		System.out.println("\nTime take for a Sixteen threads primes in  1 - 2000000 is  :\t" + sixteenThreads);
	}

}