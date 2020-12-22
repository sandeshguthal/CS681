package edu.umb.cs681.hw11;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton {
    private static AtomicReference<ConcurrentSingleton> singletonInstance = new AtomicReference<ConcurrentSingleton>();

    private void initialize() {
    }
    public static ConcurrentSingleton getInstance() {
        ConcurrentSingleton instance = new ConcurrentSingleton();

        if (singletonInstance.compareAndSet(null, instance)) {
            synchronized (instance) {
                instance.initialize();
            }
        }
        return singletonInstance.get();
    }
}
