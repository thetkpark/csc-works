package src;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        try{
        
            File file = new File("lincoln.txt");
            Scanner input = new Scanner(file);
            String a = "";
            while(input.hasNext()){
                a = a + input.nextLine() + "\n";
            }

            Map<String, String> map = new HashMap<String, String>();
            map.put("a", a);
            System.out.println(map.get("a"));
            input.close();
            
        }
        catch (Exception e) {
            throw new Error (e);
        }
    }
}   
