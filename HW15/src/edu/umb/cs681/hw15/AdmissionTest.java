package edu.umb.cs681.hw15;

public class AdmissionTest {
	
	public static void main(String[] args) {
		EntranceHandler handlerOEntrance = new EntranceHandler();
		Thread entry = new Thread(handlerOEntrance);
		entry.start();

		try {
			
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
					}
		new Thread(new MonitorHandler()).start();
		ExitHandler handlerOExit = new ExitHandler();
		Thread exit = new Thread(handlerOExit);
		exit.start();

		try {
			Thread.sleep(2000);
			
		} 
		catch (InterruptedException e)
		{
		}
		handlerOEntrance.setDone();
		entry.interrupt();
		handlerOExit.setDone();
		exit.interrupt();

		try {
			entry.join();
			exit.join();
		} catch (InterruptedException e) {
			
			System.out.println("Interupt " + e.getMessage());
		}

		new Thread(new MonitorHandler()).start();
	}
}
