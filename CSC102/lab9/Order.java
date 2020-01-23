/**
 * Order
 */
public class Order {

    private LineItem lineItem[];
    private Customer customer;

    private int orderId;
    private double totalAmount;
    private static int count;

    public Order(Customer customer){
        this.orderId = count++;
        this.totalAmount = 0;
        this.lineItem = new LineItem[20];
        this.customer = customer;
    }

    public void addLineItem(LineItem lineItem, int index){
        if(this.lineItem[index]==null){
            this.lineItem[index] = lineItem;
            System.out.println("Add line item successfully");
        }
        else System.out.println("This array is not empty. Line item cannot be added");
    }

    public void addLineItem(LineItem lineItem){
        boolean addSuccess = false;
        for(int i=0;i<this.lineItem.length;i++){
            if(this.lineItem[i]==null){
                this.lineItem[i] = lineItem;
                addSuccess = true;
                break;
            }
        }
        if(addSuccess) System.out.println("Add line item successfuly");
        else System.out.println("Your basket is full. Cannot add a line item");
    }

    public void removeLineItemByArrayIndex(int index){
        this.lineItem[index] = null;
    }

    public void calculateTotalAmount(){
        double sum = 0;
        for(int i=0;i<this.lineItem.length;i++){
            if(this.lineItem[i] != null){
                sum = sum + this.lineItem[i].calculateTotalAmount();
            }
        }
        this.totalAmount = sum;
    }

    public double getTotalAmount(){
        calculateTotalAmount();
        return this.totalAmount;
    }

    public int getOrderId(){
        return this.orderId;
    }

    public void printLineItems(){
        for(int i=0;i<this.lineItem.length;i++){
            if(this.lineItem[i] != null){
                this.lineItem[i].printDetail();
            }
        }
    }

}