package reetrantLock;

import java.util.concurrent.locks.*;

public class Runner {
	
	private int count =0;
	private  Lock lock = new ReentrantLock();
	
	private void increment() {
		for (int i =0;i<1000;i++) {
			count++;
		}
	}
	public void first() {
		lock.lock();
		increment();
		lock.unlock();
		
	}
	
	public void second() {
		lock.lock();
		increment();
		lock.unlock();
		
	}

	public void finished() {
		System.out.println("Count is "+ count);
	
}
	
}
