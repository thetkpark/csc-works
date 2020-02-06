/**
 * Cage
 */
public class Cage {
    int length, width, depth;
    String fenceMaterial; //wood, steel, electric
    double latitude, longitude; //location for GPS
    String groundType; //gress, dirt, sand, water
    Animal[] animals;
    int ammountOfAnimals;

    public Cage(int length, int width, int depth, String fence, double lat, double longi, String ground){
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.fenceMaterial = fence;
        this.latitude = lat;
        this.longitude = longi;
        this.groundType = ground;
        animals = new Animal[10];
        ammountOfAnimals = 0;
    }

    public Cage(int capacity){
        this.length = 0;
        this.width = 0;
        this.depth = 0;
        this.fenceMaterial = "steel";
        this.latitude = 10.1234;
        this.longitude = 100.1111;
        this.groundType = "dirt";
        animals = new Animal[capacity];
        ammountOfAnimals = 0;
    }

    public Animal[] getAnimals(){
        return this.animals;
    }

    public void addAnimal(Animal animal){
        if(ammountOfAnimals < animals.length){
            this.animals[ammountOfAnimals] = animal; 
            ammountOfAnimals++;
        }
        else {
            System.out.println("Cage is fulled");
        } 
    }

    public void printAllAnimals(){
        for(int i=0;i<this.animals.length;i++){
            if(this.animals[i] != null){
                System.out.println(this.animals[i].toString());
            }
        }
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    public int getDepth(){
        return this.depth;
    }

    /**
     * @return the groundType
     */
    public String getGroundType() {
        return groundType;
    }

    /**
     * @param groundType the groundType to set
     */
    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }
    /**
     * @return the fenceMaterial
     */
    public String getFenceMaterial() {
        return fenceMaterial;
    }

    /**
     * @param fenceMaterial the fenceMaterial to set
     */
    public void setFenceMaterial(String fenceMaterial) {
        this.fenceMaterial = fenceMaterial;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

}


