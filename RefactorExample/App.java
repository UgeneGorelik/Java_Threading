package RefactorExample;

import java.util.Scanner;

//Example on volatile keyword this word means that the variable should be checked BY ALL threads 

class Processor extends Thread{
	
	//declaring volatile keyword for variable
	private volatile  Boolean running=true;
	
	//function to set running to false
	public void shutdown() {
		running=false;
	}
	
	//while the running is true run
	public void run() {
		while(running) {
			System.out.println("hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
}

public class App {
	public static void main(String[] args) {
		Processor p1= new Processor();
		p1.start();
		//wait for user to press enter
		System.out.println("press return to stop");
		Scanner scanner= new Scanner(System.in);
		scanner.nextLine();
		
		//if he does continue and ser runner to false
		p1.shutdown();
		
		
	}
	
	
}
