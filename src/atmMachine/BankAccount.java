//i realize this is probably the worse way to do it but i wanted practice

package atmMachine;

public class BankAccount {
	public final int ID_NUMBER;
	public double accountBalance;
	
	public BankAccount(int id) {
		this.ID_NUMBER = id;
	}
	
	public BankAccount(int id, double initialBalance) {
		this.ID_NUMBER = id;
		this.accountBalance = initialBalance;
	}
}
