import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Bisection
 */
public class Bisection {

    public static double f(double c1, double c2, double x){
        return c1+c2*(x-Math.sin(x));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c1 = sc.nextDouble();
        double c2 = sc.nextDouble();
        double tolerance = sc.nextDouble();

        if(f(c1,c2,a)*f(c1,c2,b) < 0){
            double tol = 1;
            double xns = 0;
            while(tol>tolerance){
                xns = (a + b) / 2;
                if(f(c1,c2,a) * f(c1,c2,xns) < 0){
                    b = xns;
                }
                else a = xns;
                tol = (b-a)/2;
            }
            double number = (a+b)/2;
            DecimalFormat numberFormat = new DecimalFormat("#.000000");
            System.out.println(numberFormat.format(number));
        }
    }

}