package Refactor;

public class Account {
	
	private int balance =100000;
	
	public void deposit(int v) {
		balance +=v;
		
	}
	
	public void withdrwal(int v) {
		balance +=v;
		
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account a,Account b,int amount) {
		a.withdrwal(amount);
		a.deposit(amount);
	}
	
	

}
