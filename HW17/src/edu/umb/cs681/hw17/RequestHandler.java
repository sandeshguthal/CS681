package edu.umb.cs681.hw17;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class RequestHandler implements Runnable {

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}
	
	private ReentrantLock lock;
	
	private static ArrayList<Path> pathArrayDefined = new ArrayList<Path>();

	
	public void run() {
		Random randomNumberGen = new Random();
		while (true) {
			lock.lock();
			try {
				
				if (done)
					
					break;
				
			} finally 
			{
				lock.unlock();
			}
			Path thePathOfFile = pathArrayDefined.get(randomNumberGen.nextInt(pathArrayDefined.size()));
			AccessCounter.getInstance().increment(thePathOfFile);
			AccessCounter.getInstance().getCount(thePathOfFile);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				continue;
			}
		}
	}
	public RequestHandler() {
		lock = new ReentrantLock();
	}

	public static void main(String[] args) {
		ArrayList<RequestHandler> requests = new ArrayList<>();
		ArrayList<Thread> threads = new ArrayList<>();
		pathArrayDefined.add(Paths.get("a.html"));
		pathArrayDefined.add(Paths.get("b.html"));
		for (int i = 0; i < 15; i++) {
			RequestHandler request = new RequestHandler();
			Thread requestHandlerThread = new Thread(request);
			threads.add(requestHandlerThread);
			requests.add(request);
			requestHandlerThread.start();
		}
		try {
			Thread.sleep(900);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		Thread reqHandlerThreads = null;
		RequestHandler requestHandlerreq = null;
		for (int i = 0; i < 15; i++) {
			reqHandlerThreads = threads.get(i);
			requestHandlerreq = requests.get(i);
			try {
				requestHandlerreq.setDone();
				reqHandlerThreads.interrupt();
				reqHandlerThreads.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private boolean done;
}
