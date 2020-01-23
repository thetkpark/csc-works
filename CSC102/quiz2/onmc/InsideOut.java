import java.util.Scanner;
/**
 * InsideOut
 */
public class InsideOut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int n = word.length();
        int index = n/2;
        for(int i=index-1;i>=0;i--){
            System.out.print(word.charAt(i));
        }
        if(n%2!=0){
            System.out.print(word.charAt(n/2));
            index = n/2 + 1;
        }
        for(int i=n-1;i>=index;i--){
            System.out.print(word.charAt(i));
        }
    }
}