import java.util.Date;

/**
 * Transaction
 */
public class Transaction {

    private int transactionNumber;
    private Date date;
	private double amount;
	
	public Transaction(int tn, Date date, double amount){
		this.transactionNumber = tn;
		this.date = date;
		this.amount = amount;
	}

	public int getTransactionNumber() {
		return this.transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



}