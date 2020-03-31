/**
 * Main
 */
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Sethanant Pipatpakorn 62130500230
    // Sorting 
    public static void main(String[] args) {
        int[] data = { 30, 5, 60, 11, 4, 200, 99, 6, 1, 3, 67 };
        int[] a = { 30, 5555, 460, 1111, 4, 200, 99, 606, 3781, 3, 167 };
//         selectionSort(data);
//        insertionSort(data);
//        bubbleSort(data);
//        quickSort(data, 0, data.length-1);
//        mergeSort(data, 0, data.length-1);
        radixSort(a);
        printAll(a);
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

    public static void mergeSort(int[] data, int first, int last){
        if(first<last){ //Partitioning
            int mid = (first+last)/2;
            mergeSort(data, first, mid);
            mergeSort(data, mid+1, last);
            merge(data, first, last); //Cannot divide more -> Merge
        }
    }

    public static void merge(int[] data, int first, int last){
        int[] result = new int[last-first+1];
        int mid = (first+last)/2;
        int left = first;
        int right = mid+1; //Point to first element of the right
        int i = 0; //Pointer of the result
        while(left<=mid && right<=last){ //If there is something left in the left and right
            if(data[left] < data[right]){ //Left has something smaller
                result[i] = data[left];
                left++; //Move left pointer by one
            }
            else {
                result[i] = data[right];
                right++; //Move right pointer by 1
            }
            i++; //Finish then move the point to the next empyty slot
        }
        //Copy data that still remain in left or right
        while(left<=mid){
            result[i] = data[left];
            left++;
            i++;
        }
        while(right<=last){
            result[i] = data[right];
            right++;
            i++;
        }
        //Copy the result array back to original array
        for(i=0;i<=last-first;i++){
            data[first+i] = result[i];
        }
    }

    public static void radixSort(int[] data){
        Queue<Integer>[] pile = new Queue[10]; //Create Queue for each digit
        for(int i = 0 ;i<10;i++){
            pile[i] = new LinkedList<>();
        }

        int max = data[0]; //Find max value
        for(int i=0;i<data.length;i++){
            if(max < data[i]) max = data[i];
        }

        int passes = 0; 
        while(max>0){ //Determine how many digit of the max value (Number of passes)
            max = max/10;
            passes++;
        }
        int radix = 1;
        for(int i=0;i<passes; i++){
            for(int j=0; j<data.length; j++){ //Put data into each pile
                int pileNumber = (data[j]/radix)%10;
                pile[pileNumber].add(data[j]);
            }

            int dataCount = 0;
            for(int pileNumber=0; pileNumber<10; pileNumber++){ //Put each pile back to the data
                while(!pile[pileNumber].isEmpty()){
                    data[dataCount] = pile[pileNumber].poll();
                    dataCount++;
                }
            }
            radix = radix * 10; //Move the radix by 1 digit
        }
    }


    public static void swap(int[] data, int x, int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    
    
}