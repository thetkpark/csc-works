/**
 * Main
 */
public class Main {
    static final int ROW = 8, COLUMN = 8, CELL = 81;
    public static void main(String[] args) {
        int[][] board = {
            {7,0,0,5,8,3,0,0,6},
            {0,0,6,0,0,1,4,0,5},
            {0,5,2,0,0,6,0,8,3},
            {3,0,0,2,0,0,9,5,8},
            {5,0,0,0,7,8,0,6,0},
            {6,4,8,0,1,0,3,0,0},
            {0,6,0,8,0,2,5,0,0},
            {0,0,3,1,5,0,0,7,2},
            {2,1,5,6,0,0,0,3,0}
        };
        System.out.println(isValid(board, 6, 0, 7));
        System.out.println(isValid(board, 1, 6, 2));
        System.out.println(isValid(board, 7, 6, 2));

    }

    public static boolean isValid(int[][] a, int value, int rowX, int columnY) {
        // Check rowX
        for(int i=0; i<COLUMN; i++){
            if (value == a[rowX][i]) return false;
        }
        // Check columnY
        for(int i=0; i<ROW; i++){
            if(value == a[i][columnY]) return false;
        }
        // Check inside the subsquare 3x3
        for(int i=0; i<3; i++){
            for(int j=0; j<3;j++){
                if(a[(rowX/3)*3+i][(columnY/3)*3+j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}