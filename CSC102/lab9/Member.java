/**
 * Member
 */
public class Member extends Customer {
    private double point;

    public Member(String firstname, String lastname, int customerId){
        super(firstname, lastname, customerId);
        this.point = 0;
    }

    public double getPoint(){
        return this.point;
    }

    public void setPoint(double point){
        this.point = point;
    }

    public double convertPoint(double point){
        double converted = point*20;
        this.point = this.point - point;
        return converted;
    }
    
}