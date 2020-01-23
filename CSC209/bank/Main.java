import java.util.Date;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SavingAccount sa1 = new SavingAccount(1.5, 1000, 1);
        SavingAccount sa2 = new SavingAccount();
        Transaction t1 = new Transaction(1, new Date(), 200);
        Transaction t2 = new Transaction(2, new Date(), -400);
        Transaction t3 = new Transaction(3, new Date(), 500);

        sa1.addTransaction(t2);
        System.out.println(sa1.getBalance());
    }
}