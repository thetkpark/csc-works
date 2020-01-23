public abstract class GeometricObject {
    private String color;
    private boolean filled;
    protected GeometricObject() {
        this.color = "white";
    }
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public void printInfo(){
        System.out.println("The Geometric is "+color);
    }
    public abstract double getArea();

    public abstract double getPerimeter();
}