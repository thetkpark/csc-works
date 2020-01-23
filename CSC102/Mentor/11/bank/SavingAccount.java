/**
 * SavingAccount
 */
public class SavingAccount {

    private int accountNumber;
    private String name;
    private double balance;
    private double interestRate;

    public SavingAccount(int accNum, String name, double bal, double interest){
        this.accountNumber = accNum;
        this.name = name;
        this.balance = bal;
        this.interestRate = interest;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void depositBalance(double balance){
        this.balance -= balance;
    }

    /**
     * @return the interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}