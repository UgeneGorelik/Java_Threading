package LowLevelSynchExample;


//main class for starting the Low level Consumer  Producer class

public class Runner {

	public static void main(String[] args) {
		//defining new app class
		App a= new App();
		
		//starting threads for consumer and producer
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				try {
					a.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					a.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		//start and wait for threads to run
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
