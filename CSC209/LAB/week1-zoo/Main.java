/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Animal a1 = new Animal("Jimmy", "green", "Rhino", 5, 'M');
        Animal a2 = new Animal("Tommy", "black", "Seal", 10, 'M');
        Animal a3 = new Animal("Opor", "orange", "tiget", 7, 'F'); 
        System.out.println(a3.getName() + " " + a3.getType());
        System.out.println(a1.toString());
        a1.setType("bear");
        a1.setColor("pink");
        System.out.println(a1.toString());

        System.out.println("");
        Cage c1 = new Cage(20);
        c1.addAnimal(a1);
        c1.addAnimal(a2);
        c1.printAllAnimals();
        c1.addAnimal(a3);
        System.out.println("");
        c1.printAllAnimals();

        System.out.println("");
        System.out.println(c1.animals[1].toString());


        AnimalPark park = new AnimalPark(10);
        park.addCage(c1);
        Animal a4 = new Animal("Jack", "blue", "Parrot", 10, 'F');
        Animal a5 = new Animal("Bill", "Red", "Parrot", 10, 'F');
        Cage c2 = new Cage(5);
        c2.addAnimal(a4);
        c2.addAnimal(a5);
        park.addCage(c2);
        System.out.println("");
        park.printAllAnimalsAndType();
    }
}