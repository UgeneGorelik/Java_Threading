package Refactor;

import java.util.Random;

public class App {
	
	private Account a1= new Account();
	private Account a2= new Account();
	
	public void first() throws InterruptedException{
		
		Random r= new Random();
		for (int i =0;i<1000;i++) {
			Account.transfer(a1, a2, r.nextInt(100));
		}
	}
	
	public void second() throws InterruptedException{
		Random r= new Random();
		for (int i =0;i<1000;i++) {
			Account.transfer(a1, a2, r.nextInt(100));
		}
		
	}
	
	public void finished() {
		System.out.println("Acc 1: "  +a1.getBalance());
		System.out.println("Acc 2: "  +a2.getBalance());
		System.out.println("total balance: "  +(a1.getBalance()+a1.getBalance()));
	}

}
