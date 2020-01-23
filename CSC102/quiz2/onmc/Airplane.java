import java.util.Scanner;
/**
 * Airplane
 */
public class Airplane {

    public static int calWeight(int[] row){
        int weight = 0;
        for(int i=0;i<row.length;i++){
            weight = weight + row[i];
        }
        return weight;
    }

    public static int findIndexMin(int[] row){
        int minIndex = 0;
        for(int i=0;i<row.length;i++){
            if(row[i]<=row[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int passenger[] = new int[2*n];
        int seat[][] = new int[2][n];

        int num_l=0;
        int num_r=0;
        int weight_l = 0;
        int weight_r = 0;

        for(int i=0;i<2*n;i++){
            passenger[i] = sc.nextInt();
        }

        for(int i=0;i<2*n;i++){
            if(weight_l == weight_r){ // put in l
                if(num_l<n){
                    seat[0][num_l] = passenger[i];
                    num_l++;
                }
                else {
                    int minIndex = findIndexMin(seat[0]);
                    seat[1][num_r] = seat[0][minIndex];
                    seat[0][minIndex] = passenger[i];
                    num_r++;
                }
            }

            else if(weight_l > weight_r){ //put in r
                if(num_r<n){
                    seat[1][num_r] = passenger[i];
                    num_r++;
                }
                else {
                    int minIndex = findIndexMin(seat[1]);
                    seat[0][num_l] = seat[1][minIndex];
                    seat[1][minIndex] = passenger[i];
                    num_l++;
                }
            }

            else if(weight_l < weight_r){ //put in l
                if(num_l<n){
                    seat[0][num_l] = passenger[i];
                    num_l++;
                }
                else {
                    int minIndex = findIndexMin(seat[0]);
                    seat[1][num_r] = seat[0][minIndex];
                    seat[0][minIndex] = passenger[i];
                    num_r++;
                }
            }

            weight_l = calWeight(seat[0]);
            weight_r = calWeight(seat[1]);

        }

        for(int i=0;i<n;i++){
            System.out.println(seat[0][i] + " " + seat[1][i]);
        }


    }
}