package atmMachine;
import java.util.HashSet;
import java.util.Iterator;

public class ATM {
	private HashSet<BankAccount> accounts;	 
	
	public ATM() {
		this.accounts = new HashSet<BankAccount>();
	}
	
	public void openAccount(int acctNum) {
		// check that this account doesn't already exist
		Iterator<BankAccount> it = this.accounts.iterator();
		boolean idInUse = false;
		while (it.hasNext()) {
			if (it.next().ID_NUMBER == acctNum) { 
				idInUse = true; 
				break; 
			}
		}
		// create account if the id isn't in use
		if (!idInUse) {
			accounts.add(new BankAccount(acctNum));
		} else {
			System.out.println("That ID is already in use.");
		}
	}
	
	public void openAccount(int acctNum, double initialDeposit) {
		// check that this account doesn't already exist
		Iterator<BankAccount> it = this.accounts.iterator();
		boolean idInUse = false;
		while (it.hasNext()) {
			if (it.next().ID_NUMBER == acctNum) { 
				idInUse = true; 
				break; 
			}
		}
		// create account if the id isn't in use
		if (!idInUse) {
			accounts.add(new BankAccount(acctNum, initialDeposit));
		} else {
			System.out.println("That ID is already in use.");
		}
	}
	
	public void closeAccount(int acctNum) {
		// remove the account if it exists
		Iterator<BankAccount> it = this.accounts.iterator();
		boolean acctRemoved = false;
		BankAccount a;
		while (it.hasNext()) {
			a = it.next();
			if (a.ID_NUMBER == acctNum && a.accountBalance == 0.0) {
				acctRemoved = this.accounts.remove(a); 
				break; 
			}
		}
		// report to user 
		if (acctRemoved) {
			System.out.println("Account was successfully removed.");
		} else {
			System.out.println("The account was not found or the balance was non-zero.");
		}
	}
	
	public double checkBalance(int acctNum) {
		double balance = 0.0;
		// find account
		Iterator<BankAccount> it = this.accounts.iterator();
		BankAccount a;
		while (it.hasNext()) {
			a = it.next();
			if (a.ID_NUMBER == acctNum) {
				// change return value to balance once found
				balance = a.accountBalance;
				break; 
			}
		}
		return balance;
	}
	
	public boolean depositMoney(int acctNum, double depositAmount) {
		if (depositAmount <= 0) { return false; }
		boolean success = false;
		// find account
		Iterator<BankAccount> it = this.accounts.iterator();
		BankAccount a = null;
		int id = 0;
		double bal = 0;
		while (it.hasNext()) {
			a = it.next();
			if (a.ID_NUMBER == acctNum) {
				id = a.ID_NUMBER;
				bal = Math.round((a.accountBalance + depositAmount) * 100)/100.0;
				success = true;
				break; 
			}
		}
		
		// "modify" account if it was found 
		if (success) {
			this.accounts.remove(a);
			openAccount(id, bal);
		}
		
		return success;
	}
	
	public boolean withdrawMoney(int acctNum, double withdrawAmount) {
		if (withdrawAmount <= 0) { return false; }
		boolean success = false;
		// find account
		Iterator<BankAccount> it = this.accounts.iterator();
		BankAccount a = null;
		int id = 0;
		double bal = 0;
		while (it.hasNext()) {
			a = it.next();
			if (a.ID_NUMBER == acctNum) {
				// if withdraw more than balance, no
				if (withdrawAmount > a.accountBalance) { return false; }
				// otherwise continue 
				id = a.ID_NUMBER;
				bal = Math.round((a.accountBalance - withdrawAmount) * 100)/100.0;
				success = true;
				break; 
			}
		}
		
		// "modify" account if it was found 
		if (success) {
			this.accounts.remove(a);
			openAccount(id, bal);
		}
		
		return success;
	}
	
	// tester for closing account
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.openAccount(1);
		atm.depositMoney(1,  1000);
		atm.closeAccount(1); // should not work as balance is 1000 
		atm.withdrawMoney(1, 1000);
		System.out.println(atm.checkBalance(1)); // should be 0.0
		atm.closeAccount(1); //should close properly
		System.out.println(atm.checkBalance(1)); // should be 0.0
		atm.closeAccount(3238); // should not work as acct does not exist 
	}

}
