/**
 * Commander
 */
public class Commander extends Soldier implements squadOperation {

    private Squad squad;

    public Commander(String name){
        super(name);
    }

    public void assignSquad(Squad s){
        this.squad = s;
    }

    public Squad showAssignSquad(){
        return this.squad;
    }

    public void addSoldier(Soldier s){
    
    }

    public void removeSoldier(String name){

    }

    public void listSquadMember(){
        
    }
}