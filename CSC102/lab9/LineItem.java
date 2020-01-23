/**
 * LineItem
 */
public class LineItem {

    private Product product;
    private int quantity;
    private int lineItemId;
    private static int count;

    public LineItem(Product product, int quantity){
        count++;
        this.quantity = quantity;
        this.product = product;
        this.lineItemId = count;
    }

    public int getLineItemId(){
        return this.lineItemId;
    }

    public void setLineItemId(int lineItemId){
        this.lineItemId = lineItemId;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double calculateTotalAmount(){
        return this.quantity*(this.product.getPrice());
    }

    public void printDetail(){
        System.out.println("LineItem ID: " + this.lineItemId +
        "\nProduct: " + this.product.getProductName() + "\nQuantity: " +
        this.quantity + "\nTotalAmount: " + this.calculateTotalAmount());
    }
}