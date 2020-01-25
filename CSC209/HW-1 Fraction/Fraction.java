import java.math.BigInteger;

/**
 * Fraction
 */
public class Fraction {

    private int x,y;

    Fraction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "" + x + "/" + y;
    }

    public void add(Fraction f2){
        if(this.y == f2.getY()){
            this.x = this.x + f2.getX();
        }
        else {
            int lcm = this.lcm(this.y, f2.getY());
            this.x = (this.x * (lcm/this.y)) + (f2.getX() * (lcm/f2.getY()));
            this.y = lcm;
        }
        this.reduce();
    }

    public void subtract(Fraction f2){
        if(this.y == f2.getY()){
            this.x = this.x - f2.getX();
        }
        else {
            int lcm = this.lcm(this.y, f2.getY());
            this.x = (this.x * (lcm/this.y)) - (f2.getX() * (lcm/f2.getY()));
            this.y = lcm;
        }
        this.reduce();
    }

    public void multiply(Fraction f2){
        this.x = this.x * f2.getX();
        this.y = this.y * f2.getY();
        this.reduce();
    }

    public void divide(Fraction f2){
        this.x = this.x * f2.getY();
        this.y = this.y * f2.getX();
        this.reduce();
    }

    public void reduce(){
        int gcd = this.gcd(this.x, this.y);
        this.x = this.x / gcd;
        this.y = this.y / gcd;
    }


    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    private int gcd(int a, int b){
        BigInteger n1 = BigInteger.valueOf(a);
        BigInteger n2 = BigInteger.valueOf(b);
        BigInteger gcd = n1.gcd(n2);
        return gcd.intValue();
    }

    private int lcm(int a, int b){
        return a * (b / this.gcd(a, b));
    }

    
}