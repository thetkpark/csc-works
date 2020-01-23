/**
 * Circle
 */
public class Circle {

    double radius;
    final double pi = 3.14159;
    double xcoor;
    double ycoor;
    
    public static int countCircleObject=0;

    public void setRadius(double r){
        radius = r;
        countCircleObject++;
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
    public double getAreaOfCircles(int n){
        return n*getArea();
    }
    public double getDiameter(){
        return 2*radius;
    }
    public void setCenter(int x, int y){
        xcoor = x;
        ycoor = y;
    }

    public void printInfo(){
        System.out.println("The circle have:");
        System.out.println("radius = " + getRadius());
        System.out.println("area = " + getArea());
        System.out.println("diameter = " + getDiameter());
        System.out.println("coordinate =  + ("+xcoor+", "+ycoor+")");
    }

    public static int getNumberOfCircleObject(){
        return countCircleObject;
    }

}