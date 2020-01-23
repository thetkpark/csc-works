/**
 * Soldier
 */
public class Soldier{

    private String name;
    private String rank;
    private Squad squad;

    public Soldier(String name){
        this(name, "Rookie");
    }

    public Soldier(String name, String rank){
        this.name = name;
        this.rank = rank;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getRank(){
        return this.rank;
    }

    public void setRank(String job){
        this.rank = job;
    }

    public void showSoldierInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Rank: " + this.rank);
        if(this.squad != null){
            System.out.println("Squad: " + this.squad);
            System.out.println("Commander: " + this.squad.getSquadLeader());
        }
        else System.out.println("No squad");
    }
}