package atmMachine;
import java.util.HashSet;

public class AtmMachine {
	long acctCounter;
	
	
	public AtmMachine() {
		this.acctCounter = 0;
	}
	
	public void openAccount(long acctNum) {
		
	}
	
	public void openAccount(long acctNum, double initialDeposit) {
		
	}
	
	public void closeAccount(long acctNum) {
		
	}
	
	public double checkBalance(long acctNum) {
		return 0.0;
	}
	
	public boolean depositMoney(long acctNum, double depositAmount) {
		return true;
	}
	
	public boolean withdrawMoney(long acctNum, double withdrawAmount) {
		return true;
	}
	
	public static String convertID(long id) {
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
