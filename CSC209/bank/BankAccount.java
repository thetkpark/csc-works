/**
 * BankAccount
 */
public abstract class BankAccount {

    private Transaction[] transactions;
    private int accountNumber;
	private double balance;
	int transactionCount = 0;

    public BankAccount(){
        this(0.0, 0);
    }

    public BankAccount(double balance, int acn){
        this.accountNumber = acn;
        this.balance = balance;
        this.transactions = new Transaction[100];
    }

	public void printAllTransactions() {
		for(int i=0;i<transactionCount;i++){
			System.out.println(transactions[i].toString());
		}
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
    
    public void addTransaction(Transaction transac){
		transac.setTransactionNumber(transactionCount);
		transactions[transactionCount] = transac;
		transactionCount++;
		if(this.getBalance() + transac.getAmount() > 0){
			this.setBalance(this.getBalance() + transac.getAmount());
		}
	}

	public void addOnlyTransaction(Transaction transac){
		transac.setTransactionNumber(transactionCount);
		transactions[transactionCount] = transac;
		transactionCount++;
	}

}