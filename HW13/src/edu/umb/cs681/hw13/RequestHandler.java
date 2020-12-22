package edu.umb.cs681.hw13;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;


public class RequestHandler implements Runnable {
	
	private ReentrantLock lock = new ReentrantLock();
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
	}
	
	private boolean done = false;
	
	public void run() {
		
		String[] testFl = {"AccessCounter.class", 
						  "RequestHandler.class", 
						  "a.html", 
						  "b.html"};
		AccessCounter reqAccess = AccessCounter.getInstance();

		while (true) {			
			lock.lock();
			try {
				if(done) {
	    			System.out.println("Access the files");
	    			break;
	    		}
				
				int num = new Random().nextInt(testFl.length);
				Path path = FileSystems.getDefault().getPath(".", testFl[num]);				
				
				reqAccess.increment(path);
				System.out.println(testFl[num] + "     " + reqAccess.getCount(path));
			}
			finally {
				lock.unlock();
			}
			
			try {
				Thread.sleep(900);
			}
			catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		RequestHandler [] reqhandler = new RequestHandler [11];
		for (int i = 0; i < 11; i++)
		{
			reqhandler[i] = new RequestHandler();
		}

		Thread [] ts = new Thread [11];
		for (int i = 0; i < 11; i++)
		{
			ts[i] = new Thread(reqhandler[i]);
		}
		

		for (int i = 0; i < 11; i++)
		{
			ts[i].start();
		}
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 11; i++)
		{
			reqhandler[i].setDone();
		}
		

		for (int i = 0; i < 11; i++)
		{
			ts[i].interrupt();
		}

		
		try {
			for (int i = 0; i < 11; i++)
			{
				ts[i].join();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}   		
	}	
}