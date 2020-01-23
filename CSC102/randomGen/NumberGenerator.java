/**
 * NumberGenerator
 */
public class NumberGenerator {

    private int[] nums;

    public NumberGenerator(int n){
        this.nums = new int[n];
    }

    public void generateRandomNums (){
        for(int i=0;i<nums.length;i++){
            this.nums[i] = (int) (Math.random() * 60) +20;
        }
    }

    public int getLength(){
        return this.nums.length;
    }

    public int getValue(int n){
        return this.nums[n];
    }
}