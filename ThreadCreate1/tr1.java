package ThreadCreate1;

//Way 1 of implementing threads


//class that extends threads class
class Runner extends Thread{

	//override the run method that he interface has
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

public class tr1 {


	public static void main(String[] args) {
		
		//implements new class
		Runner run1 = new Runner();
		//start it  thread
		run1.start();
		Runner run2= new Runner();
		run2.start();

	}

}
