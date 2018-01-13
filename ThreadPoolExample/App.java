package ThreadPoolExample;

//example on using Threadpool

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//declare class to run as Threads Runnable
class Processor implements Runnable {
	
	private int id;
	
	//constructor recieves id
	public Processor(int id) {
		this.id=id;
	}
	
	//the everrider run function from Thread
	public void run() {
		System.out.println("Statring "+ id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
				
	}
}


public class App {

	public static void main(String [] args) {
		
		//Declare the threadpool executor having 2 threads
		ExecutorService executor= Executors.newFixedThreadPool(2);
		
		//add the tasks that the threadpook executor should run
		for(int i=0;i<5;i++) {
			executor.submit(new Processor(i));
		}
		
		//shutdown after all have started
		executor.shutdown();
		
		System.out.println("all submitted");
		
		//wait 1 day till al the threads are finished 
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		System.out.println("all completed");
		
	}
	
}
