package LowLevelSynchExample;

import java.util.LinkedList;

//example of low level thread synchrinization
//we are by ourself creating a lock object that will lock when the limit variable
//we defined is max and lock will be undone when it is less then max or when there is 
//something in the queue (variable q.size is bigger that zero

public class App {
	//linked list to be used by producer and consumer
	private LinkedList<Integer> l= new LinkedList<Integer>();
	private final int LIMIT= 10;
	//defining lock object
	private Object lock= new Object();
		
	
	public void producer() throws InterruptedException{
		int val = 0;
		while(true) {
			//synchronized by lock object
			synchronized (lock) {
		//untill there is space in list it will be locked
				while(l.size()==LIMIT) {
				 lock.wait();
				 }
		//add 	val to list
				l.add(val++);
			}
			
		}
		
	}
    
	public void consumer() throws InterruptedException{
		while(true) {
			
		//untill there is something in the q it the lock will be locked
			synchronized (lock) {
				while(l.size()==0) {
					lock.wait();
				}
			
			System.out.println("list size= "+ l.size());
			int val=l.removeFirst();
			System.out.println("value is " + val);
			}
			Thread.sleep(100);
		}
		
	}
	
	
}
