/**
 * Isogram
 */
import java.util.Scanner;

public class Isogram {

    public static boolean checkIsogram(String word){

        char[] used = new char[word.length()];

        for(int i=0;i<word.length();i++){
            for(int j=0;j<used.length;j++){
                if(word.charAt(i) == used[j]){
                    return false;
                }
            }
            used[i] = word.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String new_word = word.toLowerCase();
        if(checkIsogram(new_word)){
            System.out.println(word + " is an isogram");
        }
        else System.out.println(word + " is not an isogram");


    }
}