/**
 * Main
 */
public class ThanosUniverse {
    
    //CSC209 Lab2 62130500230
    public static void main(String[] args) {
        Star earth = new Star(1, false, 4000000000.0, 20000, 100 , 0);
        System.out.println(earth.getVolumn());
        
        earth.addMaterial("Nitrogen");
        earth.addMaterial("Water");
        earth.addMaterial("Carbon");
        System.out.println(earth.getMaterial(1));
        System.out.println(earth.getAllMeterial());

        Star Venus = new Star(2, false, 3000000000.0, 15000, 300, 100);
        Star Sun = new Star(3, true, 100000000000.0, 60000, 30000, 15000);
        Sun.addMaterial("Hydrogen");
        Sun.addMaterial("Helium");
        Sun.addMaterial("Oxygen");
        Venus.addMaterial("Iron");
        Venus.addMaterial("Captain Marvel");
        System.out.println(Venus.toString());

        Universe solarSystem = new Universe();
        solarSystem.addStar(Sun);
        solarSystem.addStar(earth);
        solarSystem.addStar(Venus);
        solarSystem.printAllStars();

        solarSystem.readStarFromFile(1);
        solarSystem.readStarFromFile(2);

        System.out.println("Diameter test");
        System.out.println(solarSystem.getDiameter(2));

    }
}