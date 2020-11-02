package edu.umb.cs.cs681.hw5;
import java.util.stream.*;
import java.util.*;


public class PrimeGenerator {
	protected long from, to;
	protected ArrayList<Long> primes = new ArrayList<Long>();

	public PrimeGenerator(long from, long to){
		if(from >= 1 && to > from){
			this.from = from;
			this.to = to;
		}else{
			throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
		}
	}
	
	public ArrayList<Long> getPrimes(){ return primes; };
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}
	
	protected boolean isPrime(long n){
		if(n <= 1){ return false; }
		if( n > 2 && isEven(n) ){ return false; }
		long i;
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
       
        if (i == 1){ return true; }
        else{ return false; }
	}

	public void generatePrimes(){
		for (long n = from; n <= to; n++) {
			if( isPrime(n) ){ primes.add(n); }
        }
	}
	
	public static void main(String[] args) {
		PrimeGenerator gen = new PrimeGenerator(1, 100);
		gen.generatePrimes();
		gen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimes().size() + " prime numbers are found.");
		//using the generatePrimes for creation of thread objects. 
		PrimeGenerator gen2 = new PrimeGenerator(1, 100);
		List<Long> primes = LongStream.rangeClosed(gen2.from, gen2.to)
								.filter( (long n)->gen2.isPrime(n) )
								.boxed()
								.collect(Collectors.toList());
		primes.forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + primes.size() + " prime numbers are found.");

		PrimeGenerator gen3 = new PrimeGenerator(1, 100);
		long size = LongStream.rangeClosed(gen3.from, gen3.to)
								.filter( (long n)->gen3.isPrime(n) )
								.reduce( 0L, (long count, long n)->{System.out.print(n + ", ");
																	return ++count;} );
		System.out.println("\n" + size + " prime numbers are found.");
								
	}
}