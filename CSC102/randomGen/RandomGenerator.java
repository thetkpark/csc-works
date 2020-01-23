import java.util.Scanner;
/**
 * RandomGenerator
 * Author: Sethanant Pipatpakorn 62130500230
 */
public class RandomGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NumberGenerator num1 = new NumberGenerator(n);
        num1.generateRandomNums();

        RandomPrint print1 = new RandomPrint();
        print1.printRandomNums(num1);
    }
}