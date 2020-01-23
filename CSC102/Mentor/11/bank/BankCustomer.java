import java.util.ArrayList;
import java.util.List;
/**
 * BankCustomer
 */
public class BankCustomer {

    private String name;
    private String Birthday;
    private List<SavingAccount> savingAccount;

    BankCustomer(String name, String Birthday){
        this.name = name;
        this.Birthday = Birthday;
        this.savingAccount = new ArrayList<SavingAccount>();
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

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return Birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public void addAccount(SavingAccount account){
        this.savingAccount.add(account);
    }

    public void deleteAccount(SavingAccount account){
        this.savingAccount.remove(account);
    }

}