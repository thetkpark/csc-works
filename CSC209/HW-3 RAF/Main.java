import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Vector;

public class Main{

    final static String fileName = "dataset.data";

    public static void main(String[] args) {
        initFile();

        Vector<Integer> numbers = new Vector<Integer>(10);
        for(int i=1;i<=10;i++){
            int num = readFromFile(i);
            numbers.add(num);
            Collections.sort(numbers);
        }

        System.out.println("\nFrom the Vector");
        for(int x: numbers) {
            System.out.print(x + " ");
        }

        System.out.println("\nFrom the file");
        for(int i=1;i<=10;i++){
            int num = readFromFile(i);
            System.out.print(num + " ");
        }

    }

    public static void initFile(){
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            for (int i = 0; i < 10; i++) {
                raf.writeInt((int) Math.round(Math.random() * 100));
            }

            System.out.println("Original file");
            raf.seek(0);
            for(int i=1;i<=10;i++){
                int num = raf.readInt();
                System.out.print(num + " ");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readFromFile(int i){
        try {
            RandomAccessFile readPointer = new RandomAccessFile(fileName, "r");
            int location = (i-1)*4;
            readPointer.seek(location);
            int num = readPointer.readInt();
            return num;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


}

