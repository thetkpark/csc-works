/**
 * Private
 */
public class Private extends Soldier{

    private String position;

    public Private(String name){
        this(name, "PRIVATE");
    }

    public Private(String name, String position){
        super(name);
        this.position = position;
    }

    public void showSoldierInfo(){
        super.showSoldierInfo();
        System.out.println("Position: " + this.position);
    }
}