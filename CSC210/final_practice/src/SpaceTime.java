import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SpaceTime {
    public static int[] countingSort(int[] array){
        int[] result = new int[array.length];
        int[] count = new int[array.length];

        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] > array[j]) count[i]++;
                else count[j]++;
            }
        }
        for(int i=0;i<array.length;i++){
            result[count[i]] = array[i];
        }

        return result;
    }

    public static int[] distributionCount(int[] array){
        int n = array.length;
        int[] result = new int[n];
        int max = findMaxInArray(array);
        int[] freq = new int[max+1];

        for(int i=0;i<n;i++){
            freq[array[i]]++;
        }

        for(int i=1;i<=max;i++){
            freq[i] = freq[i-1] + freq[i];
        }

        for(int i=0;i<n;i++){
            result[freq[array[i]]-1] = array[i];
            freq[array[i]]--;
        }

        return result;
    }

    private static int findMaxInArray(int[] array){
        int maxNum = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(maxNum < array[i]) maxNum = array[i];
        }
        return maxNum;
    }

    public static boolean horspool(String sentense, String pattern){
        boolean founded = false;
        int n = pattern.length();

        // Construct shifting table
        HashMap<Character, Integer> shiftTable = new HashMap<Character, Integer>();
        for(int i=0;i<n-1;i++){
            char key = pattern.charAt(i);
            int shiftValue = n - i - 1;
            shiftTable.put(key, shiftValue);
        }
        // Put last character as length of sentense if not defined earlier
        shiftTable.putIfAbsent(pattern.charAt(n-1), n);

        int i=0;
        while(i<=sentense.length() - pattern.length()){
            System.out.println(i);
            int pointer = n + i - 1;
            System.out.println(pointer);
            int matchCount = 0;
            int patternPointer = n-1;
            while(matchCount != pattern.length() && (sentense.charAt(pointer) == pattern.charAt(patternPointer))){
                matchCount++;
                pointer--;
                patternPointer--;
            }
            if(matchCount == pattern.length()){
                founded = true;
                break;
            }
            Integer shiftValue = shiftTable.get(sentense.charAt(n + i - 1));
            if(shiftValue == null){
                shiftValue = n;
            }
            System.out.println("Shift: " + shiftValue);
            i = i + shiftValue;
        }
        return founded;
    }
//    public static int distributionCount2(int num[]){
//        int max=Max(num);
//        int freq[]=new int [max];
//        for(int i=0;i< freq.length;i++){
//
//        }
//
//    }
    public static int Max(int num[]){
        int max=num[0];
        for(int i=0;i< num.length;i++){
            if(num[i]>=max){
                max=num[i];
            }
        }
        return max;
    }
}
