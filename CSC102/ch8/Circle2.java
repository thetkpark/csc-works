/**
 * Circle2
 */
public class Circle2 implements GeometricObjectInterface {

    private double radius;
    private String color;
    private boolean filled;

    public Circle2(){
        this(1.0);
    }

    public Circle2(double radius){
        this(radius, "white", true);
    }

    public Circle2(double radius, String color, boolean filled){
        this.color = color;
        this.filled = filled;
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    public double getDiameter(){
        return 2*radius;
    }
}