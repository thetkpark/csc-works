/**
 * Main
 */
public class Main {

    // Sethanant Pipatpakorn 62130500230
    // Selection Sort 03/19/2020
    public static void main(String[] args) {
        int[] data = { 30, 5, 60, 11, 4, 200, 99, 6, 01, 3, 67 };
        selectionSort(data);

        for(int i=0;i<data.length;i++){
            System.out.print(data[i] + " ");
        }
    }

    public static void selectionSort(int[] data) {
        for(int i=0; i<data.length ; i++){
            int min = i;
            for(int j=i+1; j<data.length; j++){
                if(data[j] < data[min]) min = j;
            }

            if(min != i){
                int swap = data[i];
                data[i] = data[min];
                data[min] = swap;
            }
        }
    }
}