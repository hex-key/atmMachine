package atmMachine;
import java.util.HashSet;
import java.util.Iterator;

public class ATM {
	private int acctCounter;
	private HashSet<BankAccount> accounts;	 
	
	public ATM() {
		this.acctCounter = 0;
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
		if (!idInUse) {
			accounts.add(new BankAccount(acctNum));
		} else {
			System.out.println("That ID is already in use.");
		}
	}
	
	public void openAccount(int acctNum, double initialDeposit) {
		
	}
	
	public void closeAccount(int acctNum) {
		
	}
	
	public double checkBalance(int acctNum) {
		return 0.0;
	}
	
	public boolean depositMoney(int acctNum, double depositAmount) {
		return true;
	}
	
	public boolean withdrawMoney(int acctNum, double withdrawAmount) {
		return true;
	}
	
	public static String convertID(int id) {
		String s = Long.toString(id);
		// pad zeroes until 10 digit number 
		for (int i = 0; i < 10 - s.length(); i++) {
			s = "0" + s;
		}
		return s;
	}

	public static void main(String[] args) {
		

	}

}
