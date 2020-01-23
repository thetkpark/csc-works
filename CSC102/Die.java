/**
 * Die
 */
public class Die {
    private int faceValue;
    Die(){
        this(5);
    }
    Die(int d){
        faceValue = d;
    }
    public int getFaceValue(){
        return faceValue;
    }
}