/**
 * ShoppingTest
 */
public class ShoppingTest {

    public static void main(String[] args) {
        
        Customer julia = new Customer("Julia", "Smith", 1001);
        Member bob = new Member("Bob", "Roger", 2005);

        Product pepsi = new Product("Pepsi", 100, 35);
        Product juice = new Product("Splash", 200, 15);
        Product milk = new Product("NongPho", 300, 12);

        LineItem l1 = new LineItem(pepsi, 50);
        LineItem l2 = new LineItem(juice, 100);
        LineItem l3 = new LineItem(milk, 200);
        LineItem l4 = new LineItem(pepsi, 100);

        Order order1 = new Order(julia);
        order1.addLineItem(l1);
        order1.addLineItem(l2);
        order1.removeLineItemByArrayIndex(0);
        //--Order1---
        order1.printLineItems();
        order1.addLineItem(l4);
        order1.printLineItems();

        System.out.println("");

        Order order2 = new Order(bob);
        order2.addLineItem(l3);
        order2.addLineItem(l4);

        order2.printLineItems();

        System.out.println(order2.getTotalAmount());
        bob.setPoint(order2.getTotalAmount());
        System.out.println(bob.getPoint());
    }
}