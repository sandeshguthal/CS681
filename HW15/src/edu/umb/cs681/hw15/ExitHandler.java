package edu.umb.cs681.hw15;

public class ExitHandler implements Runnable {
	AdmissionControl controlAdmin = new AdmissionControl();
	volatile boolean done = false;


	public void run() {
		
		while (true) {
			if (done)
				break;
			controlAdmin.exit();
			try {
				Thread.sleep(900);
			} catch (InterruptedException e)
			{
				continue;
			}
		}
	}
	public void setDone() {
		done = true;
	}
}
