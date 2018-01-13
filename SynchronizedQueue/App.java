package SynchronizedQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//using a synchronized queue Blocking queue
//that waits until there are elements in it then only its being used


public class App {
	
	
	//the Queue declaration
	private static BlockingQueue<Integer> q= new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) {
	//thread for the producer	
		Thread t1= new Thread(new Runnable() {
			
			public  void run() {
				producer();
				
			}
		});
		
	//thread for the consumer	
		Thread t2= new Thread(new Runnable() {
			
			
			public void run() {
				consumer();
				
			}
		});
		t1.start();
		t2.start();
		
		try {
			
		//wait till the threads are finished
			t1.join();
			t2.join();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	//producer function puts something in q 
	private static void producer() {
		int i = 0;
		while (true) {
			try {
				q.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	
	//consumer function that takes from the q
	private static void consumer() {
		int i = 0;
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			Integer val=0;
			try {
				val = q.take();
			} catch (InterruptedException e) {
			 
				e.printStackTrace();
			}
			System.out.println("taken "+ val);
			
		}
	}
}
