public class MyThreadManagerExpo extends Thread{
    int x;
    long result = 1;

    @Override
    public void run() {
        for(int i=1; i<=10*x; i++) {
            result *= 2;
        }
    }
}
