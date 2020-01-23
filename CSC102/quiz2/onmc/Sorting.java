import java.util.Scanner;
import java.util.Arrays;
/**
 * Sorting
 */
public class Sorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        for(int i=0;i<n/2;i++){
            System.out.print(nums[n-i-1] + " " + nums[i] + " ");
        }
        if(n%2!=0){
            System.out.print(nums[n/2]);
        }
    }
}