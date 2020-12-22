package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public final class Customer {
	public Customer (Address addr) {
        address = addr;
    }
	public static Address getAddress() {
        Lock.lock();
        System.out.println(":locked: getAddress() is locked :locked:");
        try {
            return address;
        } finally {
            Lock.unlock();
            System.out.println(":unlocked: getAddress() is unlocked :unlocked:");
        }
    }
    
    private static ReentrantLock Lock = new ReentrantLock();

    

    public static void setAddress(Address addr) {
        Lock.lock();
        System.out.println(":locked: setAddress() is locked :locked:");
        try {
            address = addr;
        } finally {
            Lock.unlock();
            System.out.println(":unlocked: setAddress() is unlocked :unlocked:");
        }
    }

    
    private static Address address;
}
