/**
 * RandomPrint
 */
public class RandomPrint {

    public void printRandomNums(NumberGenerator nums){
        for(int i=0;i<nums.getLength();i++){
            System.out.print(nums.getValue(i) + " ");
        }
    }

    
}