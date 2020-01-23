###Main Class (Driver Class)

```java
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SavingAccount sa1 = new SavingAccount(1, 1000, 1);
        Transaction t1 = new Transaction(200);
        Transaction t2 = new Transaction(-400);
        Transaction t3 = new Transaction(500);
        Transaction t4 = new Transaction(-2000);

        sa1.addTransaction(t1);
        sa1.addTransaction(t2);
        sa1.addTransaction(t3);
        System.out.println("1000 + 200 - 400 + 500");
        System.out.println(sa1.getBalance());
        sa1.printAllTransactions();
        System.out.println("");

        sa1.endYear();
        System.out.println("1300 + the interest");
        System.out.println(sa1.getBalance());
        sa1.printAllTransactions();
        System.out.println("");

        sa1.addTransaction(t4);
        System.out.println("Make transaction amount more than balance");
        System.out.println(sa1.getBalance());
        sa1.printAllTransactions();
        System.out.println("");

        CheckingAccount ca1 = new CheckingAccount(2000, 1);
        Transaction t5 = new Transaction(1000);
        Transaction t6 = new Transaction(-4000);
        Transaction t7 = new Transaction(500);
        Transaction t8 = new Transaction(5000);

        ca1.addTransaction(t5);
        System.out.println("2000 + 1000");
        System.out.println("Balance: " + ca1.getBalance());
        System.out.println("Overdraft: " + ca1.getOverdraftAmount());
        ca1.printAllTransactions();
        System.out.println("");
        
        ca1.addTransaction(t6);
        System.out.println("Make transaction amount more than balance");
        System.out.println("Balance: " + ca1.getBalance());
        System.out.println("Overdraft: " + ca1.getOverdraftAmount());
        ca1.printAllTransactions();
        System.out.println("");

        ca1.addTransaction(t7);
        System.out.println("Add money to pay overdraft amount");
        System.out.println("Balance: " + ca1.getBalance());
        System.out.println("Overdraft: " + ca1.getOverdraftAmount());
        ca1.printAllTransactions();
        System.out.println("");

        ca1.addTransaction(t8);
        System.out.println("Pay all the overdraft amount");
        System.out.println("Balance: " + ca1.getBalance());
        System.out.println("Overdraft: " + ca1.getOverdraftAmount());
        ca1.printAllTransactions();
        System.out.println("");
    }
}
```



### Output

```
1000 + 200 - 400 + 500
1300.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='200.0'}
{ transactionNumber='2', date='Thu Jan 23 23:09:27 ICT 2020', amount='-400.0'}
{ transactionNumber='3', date='Thu Jan 23 23:09:27 ICT 2020', amount='500.0'}

1300 + the interest
1313.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='200.0'}{ transactionNumber='2', date='Thu Jan 23 23:09:27 ICT 2020', amount='-400.0'}
{ transactionNumber='3', date='Thu Jan 23 23:09:27 ICT 2020', amount='500.0'}
{ transactionNumber='4', date='Thu Jan 23 23:09:27 ICT 2020', amount='13.0'}

Make transaction amount more than balance
1313.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='200.0'}
{ transactionNumber='2', date='Thu Jan 23 23:09:27 ICT 2020', amount='-400.0'}
{ transactionNumber='3', date='Thu Jan 23 23:09:27 ICT 2020', amount='500.0'}
{ transactionNumber='4', date='Thu Jan 23 23:09:27 ICT 2020', amount='13.0'}

2000 + 1000
Balance: 3000.0
Overdraft: 0.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='1000.0'}

Make transaction amount more than balance
Balance: 0.0
Overdraft: -1000.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='1000.0'}
{ transactionNumber='2', date='Thu Jan 23 23:09:27 ICT 2020', amount='-4000.0'}

Add money to pay overdraft amount
Balance: 0.0
Overdraft: -500.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='1000.0'}
{ transactionNumber='2', date='Thu Jan 23 23:09:27 ICT 2020', amount='-4000.0'}
{ transactionNumber='3', date='Thu Jan 23 23:09:27 ICT 2020', amount='500.0'}

Pay all the overdraft amount
Balance: 4500.0
Overdraft: 0.0
{ transactionNumber='1', date='Thu Jan 23 23:09:27 ICT 2020', amount='1000.0'}
{ transactionNumber='2', date='Thu Jan 23 23:09:27 ICT 2020', amount='-4000.0'}
{ transactionNumber='3', date='Thu Jan 23 23:09:27 ICT 2020', amount='500.0'}
{ transactionNumber='4', date='Thu Jan 23 23:09:27 ICT 2020', amount='5000.0'}
```



### Bank Account Class

```java
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
```



### Saving Account Class

```java
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
```



### Checking Account Class

```Java
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
```



### Transcation Class

```java
import java.util.Date;

/**
 * Transaction
 */
public class Transaction {

    private int transactionNumber;
    private Date date;
	private double amount;
	
	public Transaction(double amount){
		this.transactionNumber = 0;
		this.date = new Date();
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

	public String toString() {
		return "{" +
			" transactionNumber='" + (getTransactionNumber() +1) + "'" +
			", date='" + getDate() + "'" +
			", amount='" + getAmount() + "'" +
			"}";
	}

}
```

