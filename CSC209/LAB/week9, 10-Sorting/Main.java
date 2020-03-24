/**
 * Main
 */
public class Main {

    // Sethanant Pipatpakorn 62130500230
    // Sorting 
    public static void main(String[] args) {
        int[] data = { 30, 5, 60, 11, 4, 200, 99, 6, 01, 3, 67 };
//         selectionSort(data);
//        insertionSort(data);
//        bubbleSort(data);
        quickSort(data, 0, data.length-1);
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

    public static void quickSort(int[] data, int first, int last){
        if(first >= last) return; //There is only one item -> No need to do anything //Base Case
        int pivot = first;
        int lower = first+1, upper = last;

        while(lower <= upper){ // Lower is still on the left and upper on the right
            while(lower < data.length && data[lower] < data[pivot]){
                lower++; // Searching for a bigger (than pivot) value
            }
            while(upper >= 0 && data[upper] > data[pivot]){
                upper--; //Search for a smaller (than pivot) value
            }
            if(lower < upper) {
                swap(data, lower, upper); //If lower doesn't move pass the upper -> Swap lower and upper
                lower++; upper--;
            }
            else {
                lower++;
            }
        }

        //Swap the pivot data
        swap(data, pivot, upper);

        quickSort(data, first, upper-1);
        quickSort(data, upper+1, last);
    }

    public static void swap(int[] data, int x, int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    
    
}