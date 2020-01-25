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
        if(this.getBalance() + transac.getAmount() > 0){
            super.addTransaction(transac);
        }
    }

    public void endYear(){
        double amount = getBalance() * getInterestRate() / 100;
        Transaction interest = new Transaction(amount);
        super.addTransaction(interest);
    }

    

}