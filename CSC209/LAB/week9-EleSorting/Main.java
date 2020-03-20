/**
 * Main
 */
public class Main {

    // Sethanant Pipatpakorn 62130500230
    // Sorting 
    public static void main(String[] args) {
        int[] data = { 30, 5, 60, 11, 4, 200, 99, 6, 01, 3, 67 };
//         selectionSort(data);
        insertionSort(data);
//        bubbleSort(data);
        printAll(data);
    }

    public static void printAll(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("");
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

    public static void insertionSort(int[] data){
        for(int i=1;i<data.length;i++){
            int temp = data[i];
            int j=i-1;
            for(; j>=0 && data[j]>temp; j--){
                data[j+1] = data[j];
            }
            data[j+1] = temp;
        }
    }

    public static void bubbleSort(int[] data){
        for(int i=0;i<data.length;i++){
            for(int j=data.length-1; j>i; j--){
                if(data[j] < data[j-1]){
                    int swap = data[j];
                    data[j] = data[j-1];
                    data[j-1] = swap;
                }
            }
        }
    }
    
    
}