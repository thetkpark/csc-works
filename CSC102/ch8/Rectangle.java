/**
 * Rectangle
 */
public class Rectangle extends GeometricObject{

    private double width;
    private double height;

    public Rectangle(){
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height){
        this(width, height, "green", true);
    }

    public Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setWidthHeight(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width*height;
    }

    public double getPerimeter(){
        return (2*width) + (2*height);
    }
}