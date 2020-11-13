public class Main {

    public static void main(String[] args) {
//	    String trainingFile = "creditRisk_Clean_NoCreditHistory_training.arff";
//	    String testingFile = "creditRisk_Clean_NoCreditHistory_testing.arff";
//	    String PredictFile = "predict.arff";
//
//	    LoanML loan = new LoanML(9, trainingFile, testingFile, PredictFile);
//		loan.trainAndTestDataSet();
//		loan.predictDataSet();
//		int[] numbers = {10,4,7,2,5,3};
//		distributionCount(numbers);
		sieveOfEratosthenes(100);
    }

    public static void distributionCount(int[] arr){
    	int maxNumInArray = getMaxNumberInArray(arr);
    	// Create a freq array to count the freqency of each number in array
    	int[] freq = new int[maxNumInArray+1];
    	// Create result array for the sorted array
    	int [] result = new int[arr.length];
    	// Count the frequency of each number in array
    	for(int i=0; i<arr.length; i++){
    		freq[arr[i]]++;
		}
    	// Calculate accumulative frequency of the frequency
		for(int i=1; i<=maxNumInArray; i++){
			freq[i] = freq[i-1] + freq[i];
		}
		// From the last number in array
		// Get the appropriate index for that number and put it in that index
		// Decrease the accumulative freq by 1 for that number
		for(int i=arr.length-1; i>=0; i--){
			result[freq[arr[i]]-1] = arr[i];
			freq[arr[i]]--;
		}
		// Display the output
		for(int i=0; i<arr.length; i++){
			System.out.print(result[i] + " ");
		}
	}

	public static int getMaxNumberInArray(int[] arr){
    	int maxValue = Integer.MIN_VALUE;
    	for(int i=0; i<arr.length; i++){
    		if(arr[i]>maxValue){
    			maxValue = arr[i];
			}
		}
    	return maxValue;
	}

	public static void sieveOfEratosthenes(int n){
    	int[] a = new int[n+1];
    	// Set all the value to be 1 (Prime)
    	for(int i=2; i<=n;i++){
    		a[i] = 1;
		}

    	for(int i=2; i<Math.floor(Math.sqrt(n)); i++){
    		if(a[i] != 0){
    			int j = i*i; // Next non-prime with factor of i
    			while(j<=n){
    				a[j] = 0; // Mark that number as non-prime
    				j = j + i;
				}
			}
		}
    	// Print all the prime(index) (value != 0)
    	for(int i=2; i<n+1; i++){
    		if(a[i] != 0) System.out.print(i + " ");
		}

	}


}
