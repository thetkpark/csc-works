import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Record
 */
public class Record {

    synchronized public void writeData(double timeUsed){
        File file;
        FileWriter fw;
		try {
            file = new File("Em.csv");
            System.out.println(Thread.currentThread());
            fw = new FileWriter(file, true);
            fw.write(timeUsed + ",");
            fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}