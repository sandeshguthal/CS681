package edu.umb.cs681.hw11;

public class MultiThread implements Runnable {

    @Override
    public void run() {
        getInstanceAndName();
    }

    private void getInstanceAndName() {
        System.out.println(ConcurrentSingleton.getInstance());
        System.out.println("Current Thread Ends " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MultiThread());
        Thread thread2 = new Thread(new MultiThread());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
