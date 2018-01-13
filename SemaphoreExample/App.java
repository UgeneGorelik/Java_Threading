package SemaphoreExample;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//Semaphore can be used to limit the amount of runs this thread can be ran


public class App {
	
	public static void main(String [] args) {
		Connection a= new Connection();
		a.connect();
		
		//Declare threadpool
		ExecutorService exec = Executors.newCachedThreadPool();
		//submit jobs to threadpool
		for(int i =0;i<100;i++) {
		
		//submit jobs as Threads
			exec.submit(new Runnable() {
				
				
				public void run() {
					Connection.getINstance().connect();
					
				}
			});
		}
		//Shutdown threadpool
		exec.shutdown();
		try {
		//wait for threadpool to finish
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
