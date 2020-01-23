/**
 * CircleCaller
 */
public class CircleCaller {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("C1");
        System.out.println("Circle Counter: " + Circle.circleCounter);
        System.out.println("Radius: " + c1.getRadius() + "\t Center: " + c1.getCenter());
        
        Circle c2 = new Circle(5.3);
        System.out.println("C2");
        System.out.println("Circle Counter: " + Circle.circleCounter);
        System.out.println("Radius: " + c2.getRadius() + "\t Center: " + c2.getCenter());
        
        Circle c3 = new Circle(1.2,4,10);
        System.out.println("C3");
        System.out.println("Circle Counter: " + Circle.circleCounter);
        System.out.println("Radius: " + c3.getRadius() + "\t Center: " + c3.getCenter());

    }
}