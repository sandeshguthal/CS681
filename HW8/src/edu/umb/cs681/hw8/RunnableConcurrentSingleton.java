package edu.umb.cs681.hw8;

public class RunnableConcurrentSingleton implements Runnable {

    public void run(){
        System.out.println(ConcurrentSingleton.getInstance()+" Get instance");
    }

    public static void main(String args[]){
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
        new Thread(new RunnableConcurrentSingleton()).start();
    }
}