import java.util.Scanner;
/**
 * InsideOut
 */
public class InsideOut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        for(int i=1;i<=word.length()/2;i++){
            System.out.print(word.charAt(word.length()/2 - i));
        }
        if(word.length()%2!=0){
            System.out.print(word.charAt(word.length()/2));
        }
        for(int i=1;i<=word.length()/2;i++){
            System.out.print(word.charAt(word.length()-i));
        }
    }
}