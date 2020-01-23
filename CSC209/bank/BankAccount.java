/**
 * BankAccount
 */
public abstract class BankAccount {

    private Transaction[] transactions;
    private int accountNumber;
    private double balance;

    public BankAccount(){
        this(0.0, 0);
    }

    public BankAccount(double balance, int acn){
        this.accountNumber = acn;
        this.balance = balance;
        this.transactions = new Transaction[100];
    }

	public Transaction[] getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
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
		for(int i=0;i<transactions.length;i++){
			if(transactions[i] == null){
				transactions[i] = transac;
				this.balance = this.balance + transac.getAmount();
				break;
			}
		}
    }

}