package edu.umb.cs681.hw17;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	private static ReentrantLock instanceLock = new ReentrantLock();
	private ConcurrentHashMap<java.nio.file.Path, Integer> count;

	private AccessCounter() {
		count = new ConcurrentHashMap<java.nio.file.Path, Integer>();
	}
	public void increment(Path path) {
		try {
			count.compute(path, (p, v) -> v == null ? 1 : ++v);
		} finally {
			System.out.println(Thread.currentThread().getName() + " add  " + path + " count " + count.get(path));
		}
	}

	public static AccessCounter getInstance() {
		instanceLock.lock();
		try {
			if (ac == null) {
				ac = new AccessCounter();
			}
			return ac;
		} finally {
			instanceLock.unlock();
		}
	}

	public int getCount(Path path) {
		try {
			if (count.containsKey(path)) {
				return count.get(path);
			} else {
				return 0;
			}
		} finally {
			System.out.println(Thread.currentThread().getName() + " returnCount " + path + " count " + count.get(path));
		}
	}
	private static AccessCounter ac = null;


	
}
