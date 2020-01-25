/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3,4);
        Fraction f2 = new Fraction(7,12);
        Fraction f3 = new Fraction(10,6);
        System.out.print(f3.toString() + " is reduced to ");
        f3.reduce();
        System.out.print(f3.toString());
        System.out.println("");

        System.out.print(f1.toString() + " + " + f2.toString() + " = ");
        f1.add(f2);
        System.out.print(f1.toString());
        System.out.println("");

        System.out.print(f3.toString() + " - " + f1.toString() + " = ");
        f3.subtract(f1);
        System.out.print(f3.toString());
        System.out.println("");

        System.out.print(f2.toString() + " * " + f3.toString() + " = ");
        f2.multiply(f3);
        System.out.print(f2.toString());
        System.out.println("");

        System.out.print(f1.toString() + " / " + f3.toString() + " = ");
        f1.divide(f3);
        System.out.print(f1.toString());
        System.out.println("");
    }
    
}