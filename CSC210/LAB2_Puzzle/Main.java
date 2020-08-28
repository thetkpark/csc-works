/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        char[][] puzzle = {
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
            {'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'},
            {'e', 'f', 'r', 'o', 'p', 'o', 'k', 'l'},
            {'a', 'b', 'c', 'd', 'e', 'c', 'a', 'n'},
            {'a', 'p', 'e', 'e', 'm', 'l', 'g', 'h'},
            {'d', 'n', 'a', 's', 'm', 'a', 'r', 't'},
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
            {'m', 'n', 'o', 'p', 'q', 'r', 's', 't'},
        };

        int[] position = new int[2];
        position = search(puzzle, "sand");
        for(int i=0;i<2;i++){
            System.out.print(position[i] + " ");
        }
    }

    public static int[] search(char[][] a, String key){
        int[] location = { -1, -1 };
        for(int row=0; row < a.length; row++){
            for(int i=0; i < a[0].length; i++){
                // Horizontal Search
                // i point for each colume
                // Left to right
                int j = 0; //j is pointer for key
                while(i<=a[0].length - key.length() 
                && j < key.length() && a[row][i+j] == key.charAt(j)){
                    j++;
                }
                if(j == key.length()){
                    location[0] = row;
                    location[1] = i;
                    return location;
                }
                // Right to left
                j = 0; //j is pointer for key
                while(i>=key.length()-1 && j<key.length() && a[row][i-j] == key.charAt(j)){
                    j++;
                }
                if(j == key.length()){
                    location[0] = row;
                    location[1] = i;
                    return location;
                }
            }
        }

        for(int col=0; col < a.length; col++){
            for(int i=0; i <= a[0].length - key.length(); i++){
                // Verticle Search
                // i point within a row
                int j = 0; //j is pointer for key
                while(j<key.length() && a[i+j][col] == key.charAt(j)){
                    j++;
                }
                if(j == key.length()){
                    location[0] = col;
                    location[1] = i;
                    return location;
                }
            }
        }
        return location;
    }
}