import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Thread th1 = new MyThreadManager();
        Thread th2 = new MyThreadManager();
	    th1.start();
	    th2.start();
	    try{
	        // Wait for the Thread to finish
            th1.join();
            th2.join();
            long answer = ((MyThreadManager) th1).sum + ((MyThreadManager) th2).sum;
            System.out.println(answer);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
