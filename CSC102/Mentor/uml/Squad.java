/**
 * Squad
 */
public class Squad implements squadOperation {

    private String name;
    private Soldier[] fireteam;
    private int member=0;
    private Commander squadLeader;
    
    public Squad(String name){
        this.name = name;
    }

    public void addSoldier(Soldier s){
        fireteam[member] = s;
        member++;
    }

    public void removeSoldier(String name){
        for(int i=0;i<member;i++){
            if(fireteam[i].getName().equals(name)){
                fireteam=null;
            }
        }
    }

    public void listSquadMember(){

    }

    public Commander getSquadLeader(){
        return this.squadLeader;
    }

    public void showSquadInfo(){

    }

}