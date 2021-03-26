import java.util.Scanner;
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

        Scanner sc = new Scanner(System.in);
        System.out.println("What is x?");
        int x = sc.nextInt();

        MyThreadManager thAdd = new MyThreadManager();
        MyThreadManagerExpo thExpo = new MyThreadManagerExpo();
        MyThreadManagerFibo thFibo = new MyThreadManagerFibo();

        thAdd.start = 1;
        thAdd.end = 10000000;

        thExpo.x = x;
        thFibo.x = x;

        thAdd.start();
        thExpo.start();
        thFibo.start();

        try {
            thAdd.join();
            thExpo.join();
            thFibo.join();

            long answer = (x * thAdd.sum) + thExpo.result - thFibo.result;
            System.out.println("Sum 1 to 10000000: " + thAdd.sum);
            System.out.println(x + "* sum is: " + thAdd.sum);
            System.out.println("2 powered by 10x is: " + thExpo.result);
            System.out.println("Fib(x) is: " + thFibo.result);
            System.out.println("f(x) = " + answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
