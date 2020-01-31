/**
 * Cubic
 */
public class Cubic extends Thread {

    double from,to;
    Record rc;
    boolean wait;

    public Cubic(double from, double to, Record rc, boolean wait){
        this.from = from;
        this.to = to;
        this.rc = rc;
        this.wait = wait;
    }

    public void run(){
        double sT = System.currentTimeMillis();
        double ans = 0;
        for(double i=from;i<=to;i++){
            for(double j=from;j<=to;j++){
                for(double k=from;k<=to;k++){
                    ans+=i;
                }
            }
        }
        double eT = System.currentTimeMillis();
        rc.writeData(eT-sT);
        try {
            if(wait){
                wait();
            }
            else{
                notifyAll();
            }
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}