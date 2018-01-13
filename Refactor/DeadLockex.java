package Refactor;

//example on Deadlock situation
//function l1 is locking lock1 then during its sleep function l2 locking lock 2
//then lock l1 is waiting for l2 to be released
// however l2 after it its waiting for lock 1 to be released and its locked untill l2 will be released


public class DeadLockex {
	
//declaring locks
	private static Object lock1= new Object();
	private static Object lock2= new Object();
	
	public static void l1() {
		
		//locking lock 1
		synchronized (lock1) {
			System.out.println("locked lock1");
		
		//sleep so l2 will be able to lock
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("waiting for lock2");
		}
		
		//nested locking will hapen onlu when lock 2 will be released
		synchronized(lock2) {
			System.out.println("locked lock2");
			
			}
		}
	}
	
	public static void l2() {
		//locking lock 1
		synchronized (lock2) {
			System.out.println("locked lock2");
			//sleep so l2 will be able to lock
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("waiting for lock2");
			}
			
			//nested locking will hapen onlu when lock 2 will be released
			synchronized (lock1) {
				System.out.println("locked lock1");
				
			}
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Thread t1= new Thread(new Runnable() {
			
			
			public void run() {
			l1();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			
			public void run() {
				l2();
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
