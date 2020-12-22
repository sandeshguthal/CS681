package edu.umb.cs681.hw15;

public class MonitorHandler implements Runnable {

	AdmissionControl controllerAdmin = new AdmissionControl();

	public void run() {
		System.out.println("Visitors = " + controllerAdmin.countCurrentVisitors());
	}
}
