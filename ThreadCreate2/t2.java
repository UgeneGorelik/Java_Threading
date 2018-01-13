package ThreadCreate2;


//way 2 of starting thread

//implementing runnable interface
class Runner implements Runnable{

	//implement the run method that he interface has
	public void run() {
		//print word and sleep
		for (int i=0;i<10;i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class t2 {

	public static void main(String[] args) {
		
		
		//creating thread class with the runner class we created
		Thread t1= new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		//starting the threads
		t1.start();
		t2.start();
		
	}
}
