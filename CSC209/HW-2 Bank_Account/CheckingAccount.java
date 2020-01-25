/**
 * CheckingAccount
 */
public class CheckingAccount extends BankAccount{
    private double overdraftAmount = 0;

    public CheckingAccount(double amount, int acn){
        super(amount, acn);
    }

	public double getOverdraftAmount() {
		return this.overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
    }
    
    public void addTransaction(Transaction transac){
        if(transac.getAmount() > 0 && this.overdraftAmount != 0){
            double left = transac.getAmount() + this.overdraftAmount;
            if(left>=0){
                this.setBalance(left);
                this.overdraftAmount = 0;
            }
            else{
                this.overdraftAmount += transac.getAmount();
            }
            super.addOnlyTransaction(transac);
        }
        else if(this.getBalance() + transac.getAmount() < 0){
            double left = this.getBalance() + transac.getAmount();
            this.setBalance(0);
            this.overdraftAmount = left;
            super.addOnlyTransaction(transac);
        }

        else {
            super.addTransaction(transac);
        }
		
    }
  
}