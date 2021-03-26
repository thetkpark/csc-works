import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        MyThreadManager th1 = new MyThreadManager();
        MyThreadManager th2 = new MyThreadManager();
        MyThreadManager th3 = new MyThreadManager();
        MyThreadManager th4 = new MyThreadManager();
        long serialAnswer = 0;
        long startTime = System.nanoTime();
        for(long i=1; i<=2000000000; i++) {
            serialAnswer += i;
        }
        long endTime = System.nanoTime();
        System.out.println(serialAnswer);
        System.out.println("Time spent is " + (endTime-startTime) + " nanoseconds\n");

        th1.start = 1;
        th1.end = 500000000;
        th2.start = 500000001;
        th2.end = 1000000000;
        th3.start = 1000000001;
        th3.end = 1500000000;
        th4.start = 1500000001;
        th4.end = 2000000000;
        startTime = System.nanoTime();
	    th1.start();
	    th2.start();
	    th3.start();
	    th4.start();
	    try{
	        // Wait for the Thread to finish
            th1.join();
            th2.join();
            th3.join();
            th4.join();
            long answer = th1.sum + th2.sum + th3.sum + th4.sum;
            endTime = System.nanoTime();
            System.out.println(answer);
            System.out.println("Time spent is " + (endTime-startTime) + " nanoseconds");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
