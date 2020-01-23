import java.util.Scanner;
import java.util.Arrays;
/**
 * Sorting
 */
public class Sorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0;i<n/2;i++){
            System.out.print(arr[n-i-1] + " ");
            System.out.print(arr[i] + " ");
        }
        if(n%2!=0) System.out.print(arr[(n/2)]);
    }
}