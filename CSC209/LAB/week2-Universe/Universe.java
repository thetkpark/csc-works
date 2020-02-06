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
            raf.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException ex){
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    public void readStarFromFile(int i){
        try {
            RandomAccessFile readPointer = new RandomAccessFile(universeFile, "r");
            
            //Jump to record
            long locationOf = 237 * (i-1);
            readPointer.seek(locationOf); // move pointer to location we want to get
            
            System.out.println("");
            int starNum = readPointer.readInt();
            System.out.print(starNum + " ");
            
            boolean light = readPointer.readBoolean();
            System.out.print(light? "Has light" : "No light");

            byte[] material = new byte[20];
            for(int j=0;j<10;j++){
                readPointer.read(material, 0, 20);
                String m = new String(material);
                System.out.print(" " + m.trim());
            }

            double age = readPointer.readDouble();
            System.out.print(age + " ");

            double diameters = readPointer.readDouble();
            System.out.print(diameters + " ");

            double maxTemp = readPointer.readDouble();
            System.out.print(maxTemp + " ");

            double minTemp = readPointer.readDouble();
            System.out.print(minTemp + " ");
            
            readPointer.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException ex){
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getDiameter(int i){
        try {
            RandomAccessFile pointer = new RandomAccessFile(universeFile, "r");
            pointer.seek((i-1)*237 + 4 + 1 + 20*10 + 8);
            double dia = pointer.readDouble();
            pointer.close();
            return dia;
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException ex){
            Logger.getLogger(Universe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}