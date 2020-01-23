/**
 * Customer
 */
public class Customer {

    private String firstname;
    private String lastname;
    private int customerId;

    protected Customer(String firstname, String lastname, int customerId){
        this.firstname = firstname;
        this.lastname = lastname;
        this.customerId = customerId;
    } 

    public String getFirstname(){
        return this.firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public void getCustomerId(int customerId){
        this.customerId = customerId;
    }
}