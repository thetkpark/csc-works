import java.util.Scanner;


/**
 * Airplane
 */
public class Airplane {

    public static int calculateWeight(int[] row){
        int weight = 0;
        for(int i=0;i<row.length;i++){
            weight = weight + row[i];
        }
        return weight;
    }

    public static int findMinIndex(int[][] seat, int row){
        int min = 99999999;
        int minIndex = 0;
        for(int i=0;i<seat[row].length;i++){
            if(seat[row][i] <= min){
                min = seat[row][i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] passenger = new int[2*n];
        for(int i=0;i<n*2;i++){
            passenger[i] = sc.nextInt();
        }
        int num_l = 0;
        int num_r = 0;
        int weight_l = 0;
        int weight_r = 0;
        int[][] seat = new int[2][n];

        for(int i=0;i<2*n;i++){
            if(weight_l == weight_r){
                if(num_l < n){
                    seat[0][num_l] = passenger[i];
                    num_l++;
                }
                else{
                    //System.out.println("Hello from l==r");
                    int minIndex = findMinIndex(seat, 0);
                    seat[1][num_r] = seat[0][minIndex];
                    num_r++;
                    seat[0][minIndex] = passenger[i];
                }
            }

            else if(weight_l>weight_r){
                if(num_r < n){
                    seat[1][num_r] = passenger[i];
                    num_r++;
                }
                else {
                    //System.out.println("Hello from l > r");
                    int minIndex = findMinIndex(seat, 1);
                    seat[0][num_l] = seat[1][minIndex];
                    num_l++;
                    seat[1][minIndex] = passenger[i];
                }
            }

            else if(weight_r>weight_l){
                if(num_l < n){
                    seat[0][num_l] = passenger[i];
                    num_l++;
                }
                else {
                    //System.out.println("Hello from r > l");
                    int minIndex = findMinIndex(seat, 0);
                    seat[1][num_r] = seat[0][minIndex];
                    num_r++;
                    seat[0][minIndex] = passenger[i];
                }
            }

            weight_l = calculateWeight(seat[0]);
            weight_r = calculateWeight(seat[1]);

            // System.out.println("NumL: "+num_l);
            // System.out.println("NumL: "+num_r);

            // for(int j=0;j<n;j++){
            //     System.out.print(seat[0][j] + " ");
            //     System.out.print(seat[1][j]);
            //     System.out.println("");
            // }
            // System.out.println("");

        }

        for(int i=0;i<n;i++){
            System.out.print(seat[0][i] + " ");
            System.out.print(seat[1][i]);
            System.out.println("");
        }

    }
}