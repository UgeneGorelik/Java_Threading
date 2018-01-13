package reetrantLock;

public class App {

	public static void main(String [] args) {
		Runner r=new Runner();
		
		Thread t1= new Thread(new Runnable() {
			
			
			public void run() {
				r.first();
				
			}
		}); 
	
	 
	Thread t2= new Thread(new Runnable() {
		
		
		public void run() {
				r.second();
			
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
	
	r.finished();
	
	
	
}
}