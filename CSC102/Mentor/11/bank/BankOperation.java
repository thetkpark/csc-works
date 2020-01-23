import java.util.ArrayList;
import java.util.List;

/**
 * BankOperation
 */
public class BankOperation {

    private List<BankCustomer> customers = new ArrayList<BankCustomer>();

    public void newCustomer(BankCustomer customer){
        this.customers.add(customer);
    }

    public void newAccount(BankCustomer customer, SavingAccount account){
        customer.addAccount(account);
    }
}