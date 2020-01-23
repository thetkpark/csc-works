import java.util.Scanner;
/**
 * Fibo
 */
public class Fibo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(calFibo(sc.nextInt()));
    }

    public static int calFibo(int index) {
        if(index<=2) return 1;
        return calFibo(1, 1, index);
    }
    public static int calFibo(int first, int sec, int index) {
        //System.out.println(sec);
        if(index<=2) return sec;
        return calFibo(sec, first+sec, index-1);
    }
}