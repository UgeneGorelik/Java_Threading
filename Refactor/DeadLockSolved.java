package Refactor;


//here we solve the deadlock by locking lock 1 and lock 2 in correct order
//in deadlockex.java file we will see explanations for deadlock 
public class DeadLockSolved {

	private static Object lock1= new Object();
	private static Object lock2= new Object();
	
	public static void l1() {
		
		//order corrected first lock 1 then lock 2
		synchronized (lock1) {
			
			System.out.println("locked lock1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("waiting for lock2");
			}
			
			synchronized (lock2) {
				System.out.println("locked lock1 and 2");
				
			}
			
		}
	}
	
	
	public static void l2() {
		//order corrected first lock 1 then lock 2	
		synchronized (lock1) {
			
			System.out.println("locked lock1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("waiting for lock2");
			}
			
			synchronized (lock2) {
				System.out.println("locked lock1 and 2");
				
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
