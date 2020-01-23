public class TestInheritance {
    public static void main(String[] args){
        System.out.println("---Create a Circle c1---");
        Circle c1 = new Circle();
        GeometricObject g1 = new GeometricObject("white", true);
        if(c1 instanceof GeometricObject){
            System.out.println("c1 is a GeometricObject");}
        if(c1 instanceof Circle){
            System.out.println("c1 is a Circle");}
        if(c1 instanceof Object){
            System.out.println("c1 is an Object");}
            System.out.println("---Create a GeometricObject g1---");
        if(g1 instanceof Circle){
            System.out.println("g1 is a Circle");}
        if(g1 instanceof GeometricObject){
            System.out.println("g1 is a GeometricObject");}
            System.out.println("---Create a GeometricObject g2---");
        GeometricObject g2 = (GeometricObject) new Circle();
        if(g2 instanceof Circle){
            System.out.println("g2 is a Circle");}
        if(g2 instanceof GeometricObject){
            System.out.println("g2 is a GeometricObject");}
    }
}