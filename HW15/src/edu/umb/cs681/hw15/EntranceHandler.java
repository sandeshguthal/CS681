package edu.umb.cs681.hw15;

public class EntranceHandler implements Runnable {

	AdmissionControl controlAdmin = new AdmissionControl();
	volatile boolean done = false;

	public void setDone() {
		done = true;
	}

	public void run() {
		while (true) {
			if (done)
				break;
			controlAdmin.enter();
			//else
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				continue;
			}

		}
	}
}
