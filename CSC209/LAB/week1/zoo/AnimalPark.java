/**
 * AnimalPark
 */
public class AnimalPark {
    Cage[] cages; //Zookeeper, Responsibility, Assign
    int ammountOfCages;

    public AnimalPark(int maxCages){
        this.ammountOfCages = 0;
        this.cages = new Cage[maxCages];
    }

    public void addCage(Cage c){
        if(ammountOfCages < cages.length){
            cages[ammountOfCages] = c;
            ammountOfCages++;
        }
        else{
            System.out.println("Zoo has too many cages already: Too crowded for animal");
        }
    }

    public void printAllAnimalsAndType(){
        for(int i=0;i<ammountOfCages;i++){
            System.out.println(cages[i].getFenceMaterial() + " " + (i+1));
            Animal[] animals = cages[i].getAnimals();
            for(int j=0;j<animals.length;j++){
                if(animals[j] != null){
                    System.out.println("Name: " + animals[j].getName() + " Type: " + animals[j].getType());
                }
            }
        }

    }
    //narongrit@sit.kmutt.ac.th
    //cc saowaga.ssp@gmail.com
    // sublject: CSC209 lab1 62130500230
    //4 file 
}