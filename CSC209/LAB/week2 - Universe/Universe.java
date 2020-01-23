import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Universe
 */
public class Universe {

    Vector<Star> starList;
    final String universeFile = "universe.data";

    public Universe(){
        this.starList = new Vector<Star>(10, 5);
    }

    public void addStar(Star star){
        this.starList.add(star);
        this.addStarToFile(star);
    }

    public Star getStar(int i){
        return this.starList.get(i+1);
    }

    public void printAllStars(){
        for(Star s: starList){
            System.out.println(s.toString());
        }
    }

    public void addStarToFile(Star s){
        try {
            RandomAccessFile  raf = new RandomAccessFile(universeFile, "rw"); //everytime the point start at the beginning
            // starNumber (4 bytes) hasLight (1 bytes) 
            // material (10 materials * 20 bytes each = 200)
            // age (8 bytes) diameters(8 bytes) maxTemp(8 bytes) minTemp(8 bytes)
            // Total = 237 bytes 
            
            raf.seek(raf.length()); //move the pointer to the end

            raf.writeInt(s.getStarNumber());
            raf.writeBoolean(s.isHasLight());

            for(String m: s.material){ //add all materials that it has
                byte[] materialInByte = new byte[20];
                materialInByte = m.concat("                    ").getBytes();
                raf.write(materialInByte, 0, 20);
            }
            for(int i=s.material.size(); i<10; i++){ //add empty byte for lefted vector element
                byte[] emptyMaterialInByte = new byte[20];
                emptyMaterialInByte = "                    ".getBytes();
                raf.write(emptyMaterialInByte, 0, 20);
            }

            raf.writeDouble(s.getAge());
            raf.writeDouble(s.getDiameter());
            raf.writeDouble(s.getMaxTemperature());
            raf.writeDouble(s.getMinTemperature());

        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException ex){
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}