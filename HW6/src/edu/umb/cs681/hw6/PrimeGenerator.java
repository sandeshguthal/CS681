package edu.umb.cs681.hw6;

import java.util.stream.*;
import java.util.*;

public class PrimeGenerator {
	protected long from, to;
	protected ArrayList<Long> primes = new ArrayList<Long>();

	public PrimeGenerator(long from, long to) {
		if (from >= 1 && to > from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
		}
	}

	public ArrayList<Long> getPrimes() {
		return primes;
	};

	protected boolean checkforeven(long n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isPrime(long n) {
		// Testing purpose for faster runtime for debugging
//		i = 0
//        if (n <= 1) 
//            return false; 
//        if (n <= 3) 
//            return true; 
//        if (n % 2 == 0 || n % 3 == 0) 
//            return false; 
//        for (i = 5; i * i <= n; i = i + 6) 
//            if (n % i == 0 || n % (i + 2) == 0) 
//                return false; 
//        return true; 
		if (n <= 1) {
			return false;
		}
		if (n > 2 && checkforeven(n)) {
			return false;
		}
		long i;
		for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {
		}

		if (i == 1) {
			return true;
		} else {
			return false;
		}

	}

	public void generatePrimes() {
		for (long n = from; n <= to; n++) {
			if (isPrime(n)) {
				primes.add(n);
			}

		}
	}

	public static void main(String[] args) {
		PrimeGenerator generatePrimes = new PrimeGenerator(1, 100);
		generatePrimes.generatePrimes();
		generatePrimes.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		System.out.println("\n" + generatePrimes.getPrimes().size() + " are the total prime numbers");
		// using the generatePrimes for creation of thread objects.
		PrimeGenerator generatePrimes2 = new PrimeGenerator(1, 100);
		List<Long> primes = LongStream.rangeClosed(generatePrimes2.from, generatePrimes2.to).filter((long n) -> generatePrimes2.isPrime(n)).boxed()
				.collect(Collectors.toList());
		primes.forEach((Long prime) -> System.out.print(prime + ", "));
		System.out.println("\n" + primes.size() + " are the total prime numbers");

		PrimeGenerator generatePrimes3 = new PrimeGenerator(1, 100);
		long size = LongStream.rangeClosed(generatePrimes3.from, generatePrimes3.to).filter((long n) -> generatePrimes3.isPrime(n)).reduce(0L,
				(long count, long n) -> {
					System.out.print(n + ", ");
					return ++count;
				});
		System.out.println("\n" + size + " are the total prime numbers");

	}
}