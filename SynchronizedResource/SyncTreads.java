package SynchronizedResource;

//example on thread synchronization

public class SyncTreads {

	//variable to be incremented by threads
	private int count;
	
	public static void main(String[] args) {
		//create class that runs threads
		SyncTreads s1= new SyncTreads(); 
		s1.dowork();
	}
  
	//this function is SYNCHRONIZED means
	//when thread runs it it gets closed and until it finshes
	//noone can run it and the tthreads that do wants will wait in queuq
	public synchronized void increment() {
		count++;
	}
	public void dowork() {
		
		//thread that tries to acsses synchronized function
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
			for (int i=0;i<1000;i++) {
				increment();
			}
				
			}
		});
	//thread that tries to acsses synchronized function	
	 Thread t2= new Thread(new Runnable() {
		
		@Override
		public void run() {
			for (int i=0;i<1000;i++) {
				increment();
			}
			
		}
	});
	 t1.start();
	 t2.start();
	 
	
	 //join keyword wait till thread will finish
	 try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	 
	 System.out.println("Count is "+count);
	}
	
	
	
}
