package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {

	private static final double TRANSACTION_FEE = 0.1;
	
	public RestrictedBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}

	protected boolean isWithdrawAllowed(double amount) {
		return this.getBalance() >= amount;
	}


	protected double computeFees() {
		return MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
	}

}
