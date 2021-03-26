public class MyThreadManager extends Thread {
    Long start, end;
    Long sum = 0L;

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            sum += i;
        }
    }

}
