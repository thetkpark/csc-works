/**
 * Circle
 */
public class Circle {

    public static int circleCounter = 0;

    private double radius;
    private double xcoor, ycoor;
    private final double pi = Math.PI;

    Circle(){
        circleCounter++;
    }

    Circle(double radius){
        this.radius = radius;
        circleCounter++;
    }

    Circle(double radius, double xcoor, double ycoor){
        this.radius = radius;
        this.xcoor = xcoor;
        this.ycoor = ycoor;
        circleCounter++;
    }

    public void setRadius(double r){
        radius = r;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return pi*radius*radius;
    }
    public double getPerimeter(){
        return 2*pi*radius;
    }
    public double getDiameter(){
        return radius*2;
    }
    public void setCenter(double x, double y){
        xcoor = x;
        ycoor = y;
    }
    public double getAreaOfCircles(int n){
        return n*getArea();
    }
    public String getCenter(){
        return xcoor + ", " + ycoor;
    }
    public void printInfo(){
        System.out.println("The circle have:");
        System.out.println("radius = " + getRadius());
        System.out.println("area = " + getArea());
        System.out.println("diameter = " + getDiameter());
        System.out.println("perimeter = " + getPerimeter());
        System.out.println("coordinate =  + ("+xcoor+", "+ycoor+")");
    }
}