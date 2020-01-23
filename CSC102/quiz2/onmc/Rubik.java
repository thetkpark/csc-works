import java.util.Scanner;
/**
 * Rubik
 */
public class Rubik {

    public static int[][][] up(int[][][] rubik, int row){
        int[][] temp = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                temp[i][j] = rubik[i][row][j];
            }
        }
        int[][] result = new int[3][3];
        for(int i=0;i<3;i++){
            result[i][0] = temp[2][i];
            result[i][1] = temp[1][i];
            result[i][2] = temp[0][i];
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                rubik[i][row][j] = result[i][j];
            }
        }
        return rubik;
    }

    public static int[][][] left(int[][][] rubik, int row){
        int[][] temp = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                temp[i][j] = rubik[row][i][j];
            }
        }
        int[][] result = new int[3][3];
        for(int i=0;i<3;i++){
            result[i][2] = temp[0][i];
            result[i][1] = temp[1][i];
            result[i][0] = temp[2][i];
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                rubik[row][i][j] = result[i][j];
            }
        }
        return rubik;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] rubik = {
            {   {1,10,19},
                {2,11,20},
                {3,12,21} 
            },
            {   {4,13,22},
                {5,14,23},
                {6,15,24}
            },
            {   {7,16,25},
                {8,17,26},
                {9,18,27}}
        };

        int n = sc.nextInt();
        String act[] = new String[n];
        int row[] = new int[n];

        for(int i=0;i<n;i++){
            act[i] = sc.next();
            row[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            switch (act[i]) {
                case "up":
                    rubik = up(rubik, row[i]);
                    break;
            
                case "down":
                    rubik = up(rubik, row[i]);
                    rubik = up(rubik, row[i]);
                    rubik = up(rubik, row[i]);
                    break;
                case "left":
                    rubik = left(rubik, row[i]);
                    break;
                case "right":
                    rubik = left(rubik, row[i]);
                    rubik = left(rubik, row[i]);
                    rubik = left(rubik, row[i]);
                    break;
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(rubik[i][j][0] + " ");
            }
            System.out.println("");
        }

    }
}