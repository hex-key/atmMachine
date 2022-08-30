package atmMachine;

public class BankAccount {
	public final long ID_NUMBER;
	public double accountBalance;
	
	public BankAccount(long id) {
		this.ID_NUMBER = id;
	}
	
	public BankAccount(long id, double initialBalance) {
		this.ID_NUMBER = id;
		this.accountBalance = initialBalance;
	}
	
	public void deposit(double amount) {
		
	}
	
	public void withdraw(double amount) {
		
	}
}
