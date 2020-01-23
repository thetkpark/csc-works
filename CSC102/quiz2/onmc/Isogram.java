import java.util.Scanner;
/**
 * Isogram
 */
public class Isogram {

    public static boolean isIsogram(String word_new){
        word_new = word_new.toLowerCase();
        int length = word_new.length();
        char[] used = new char[length];

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(word_new.charAt(i) == used[j]) return false;
            }
            used[i] = word_new.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        
        if(isIsogram(word)){
            System.out.println(word + " is an isogram");
        }
        else {
            System.out.println(word + " is not an isogram");
        }

    }
}