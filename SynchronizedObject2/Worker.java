package SynchronizedObject2;

import java.util.List;
import java.util.ArrayList;

///example of how to synchronize processes within the same object
//if we do just syncronized on 2 functions in the same object
//it will take a lot of time because the thread wont be able to use any 
//of the functions inside the class
//however if we create a Lock object then it will be the one that locks
//the other process we want to lock

public class Worker {
	
	//creating  lock objects
	private Object lock1= new Object();
	private Object lock2= new Object();
	
	//lists that will be processed
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	//function to process list1
	public   void stageOne() {
		
		//we are locking the process using lock1 object  
		synchronized (lock1) {
			
		
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//processing the list 
		list1.add(1);
		}
	}
	
	public  void stageTwo() {
		
		//locking the process using lock 2 object
		synchronized (lock2) {
			
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//processing list 2
		list2.add(2);
		}
		
	}
	
	//call to stage one and two processes
	public void process(){
		for (int i=0;i<1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("hello");
		//thread one for processing
		Thread t1= new Thread(new Runnable() {
			
			
			public void run() {
				process();
				
			}
		}); 
		
		//thread 2 for processing
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
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
		
		process();
		System.out.println("l1="+list1.size()+"l2="+list2.size());
	}

}
