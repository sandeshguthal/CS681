package edu.umb.cs681.hw7;

import java.util.LinkedList;

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {

	public RunnablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend);
		if (from >= 2 && to >= from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException("from must be >= 2, and to must be >= from." + "from==" + from + " to==" + to);
		}
	}

	public void run() {
		generatePrimeFactors();
		System.out.println("Thread #" + Thread.currentThread().getId() + " generated " + factors);
	}

	protected boolean isEven(long n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void generatePrimeFactors() {
		long divisor = from;
		while (dividend != 1 && divisor <= to) {
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
		}
	}

	public static void main(String[] args) {
		System.out.println("Factorization of 36");
		RunnablePrimeFactorizer runnable = new RunnablePrimeFactorizer(36, 2, (long) Math.sqrt(36));
		Thread thread = new Thread(runnable);
		System.out.println("Thread #" + thread.getId() + " performs factorization in the range of " + runnable.getFrom()
				+ "->" + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final result: " + runnable.getPrimeFactors() + "\n");

		// Factorization of 84 with two threads
		System.out.println("86 Factorization");
		LinkedList<RunnablePrimeFactorizer> runnables = new LinkedList<RunnablePrimeFactorizer>();
		LinkedList<Thread> threads = new LinkedList<Thread>();

		runnables.add(new RunnablePrimeFactorizer(86, 2, (long) Math.sqrt(86) / 2));
		runnables.add(new RunnablePrimeFactorizer(86, 1 + (long) Math.sqrt(86) / 2, (long) Math.sqrt(84)));

		thread = new Thread(runnables.get(0));
		threads.add(thread);
		System.out.println(
				"Thread #" + thread.getId() + " Range " + runnables.get(0).getFrom() + "->" + runnables.get(0).getTo());

		thread = new Thread(runnables.get(1));
		threads.add(thread);
		System.out.println(
				"Thread #" + thread.getId() + " Range " + runnables.get(1).getFrom() + "->" + runnables.get(1).getTo());

		threads.forEach((t) -> t.start());
		threads.forEach((t) -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		LinkedList<Long> listOfFactors = new LinkedList<Long>();
		runnables.forEach((factorizer) -> listOfFactors.addAll(factorizer.getPrimeFactors()));
		System.out.println("Answer:" + listOfFactors + "\n");

		runnables.clear();
		threads.clear();

		// Factorization of 2489 with two threads
		System.out.println("Factorization of 2580");
		runnables.add(new RunnablePrimeFactorizer(2580, 2, (long) Math.sqrt(2580) / 2));
		runnables.add(new RunnablePrimeFactorizer(2580, 1 + (long) Math.sqrt(2580) / 2, (long) Math.sqrt(2580)));

		thread = new Thread(runnables.get(0));
		threads.add(thread);
		System.out.println(
				"Thread #" + thread.getId() + " Range " + runnables.get(0).getFrom() + "->" + runnables.get(0).getTo());

		thread = new Thread(runnables.get(1));
		threads.add(thread);
		System.out.println(
				"Thread #" + thread.getId() + " Range " + runnables.get(1).getFrom() + "->" + runnables.get(1).getTo());

		threads.forEach((t) -> t.start());
		threads.forEach((t) -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		LinkedList<Long> listofFactorTwo = new LinkedList<Long>();
		runnables.forEach((factorizer) -> listofFactorTwo.addAll(factorizer.getPrimeFactors()));
		System.out.println("Final result: " + listofFactorTwo);

//		For multiple threads 
//		System.out.println("Factorization of 2489");
//		runnables.add( new RunnablePrimeFactorizer(2489, 2, (long)Math.sqrt(2489)/3 ));
//		runnables.add( new RunnablePrimeFactorizer(2489, 1+(long)Math.sqrt(2489)/3, (long)Math.sqrt(2489)/3 + (long)Math.sqrt(2489)/3 ));
//		runnables.add( new RunnablePrimeFactorizer(2489, (long)Math.sqrt(2489)/3 + (long)Math.sqrt(2489)/3, (long)Math.sqrt(2489) ));
//		threads.clear();
//		runnables.clear();
//		thread = new Thread(runnables.get(0));
//		threads.add(thread);
//		System.out.println("Thread #" + thread.getId() + 
//			" performs factorization in the range of " + runnables.get(0).getFrom() + "->" + runnables.get(0).getTo());
//		
//		thread = new Thread(runnables.get(1));
//		threads.add(thread);
//		System.out.println("Thread #" + thread.getId() + 
//			" performs factorization in the range of " + runnables.get(1).getFrom() + "->" + runnables.get(1).getTo());
//		thread = new Thread(runnables.get(2));
//		threads.add(thread);
//		System.out.println("Thread #" + thread.getId() + 
//			" performs factorization in the range of " + runnables.get(2).getFrom() + "->" + runnables.get(2).getTo());
//		
//		threads.forEach( (t)->t.start() );
//		threads.forEach( (t)->{	try{t.join();}
//								catch(InterruptedException e){e.printStackTrace(); }} );
//		
//		LinkedList<Long> factors3 = new LinkedList<Long>();
//		runnables.forEach( (factorizer) -> factors3.addAll(factorizer.getPrimeFactors()) );
//		System.out.println("Final result: " + factors3);
	}
}