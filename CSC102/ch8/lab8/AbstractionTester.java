/**
 * AbstractionTester
 */
public class AbstractionTester {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.setWidthHeight(5, 10);
        r1.setColor("yellow");
        r1.setFilled(true);
        System.out.println(r1.getWidth());
        System.out.println(r1.getWidth());
        System.out.println(r1.getColor());
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
    }
}