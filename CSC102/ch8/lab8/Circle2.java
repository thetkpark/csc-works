/**
 * Circle2
 */
public class Circle2 implements GeometricObjectInterface {

    private double radius;
    
    public Circle2(){
        this(1.0);
    }
    
    public Circle2(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    public double getPerimeter(){
        return 2*radius*Math.PI;
    }
}