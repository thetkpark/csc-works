/**
 * SavingAccount
 */
public class SavingAccount extends BankAccount {
    private double interestRate;

    
    public SavingAccount(){
        this(2, 0.0, 0);
    }

    public SavingAccount(double IR, double amount, int acn){
        super(amount, acn);
        this.interestRate = IR;
    }

    public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
    }
    
    public void addTransaction(Transaction transac){
        Transaction[] transactions = super.getTransactions();
		for(int i=0;i<transactions.length;i++){
			if(transactions[i] == null){
                transactions[i] = transac;
                double amt = super.getBalance();
				super.setBalance(amt+transac.getAmount());
				break;
			}
		}
    }

    

}