package SemaphoreExample;
import java.util.concurrent.Semaphore;

//a singletone Class  

public class Connection {
	
	private static Connection c = new Connection();
	
	//resource to be incremented
	private int count = 0;
	//Declare Semaphore with amount of 10 (means there are 10 times this job can run)
	private Semaphore s= new Semaphore(10);
	
	Connection() {
		
	}
	
	public static Connection getINstance() {
		return c;
	}
	
	public void connect() {
		
		//run this as syncronized 
		synchronized (this) 
		{
		  try {
		//check if there is semaphore exists if so lock one instance of semaphore	  
			s.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		count++;
		System.out.println("no of connections: "+count);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
			
		
		synchronized (this) {
			count--;
			
		}
		//release semapore and semaphore added to total count
		s.release();
		
		}
		
	}

}
