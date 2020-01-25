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