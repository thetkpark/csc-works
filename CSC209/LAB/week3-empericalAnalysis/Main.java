import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Main
 */
public class Main {
    //CSC209 Lab3 62130500230
    public static void main(String[] args) {
        Date startDate;
        Date endDate;
        SimpleDateFormat f = new SimpleDateFormat("dd/MMM/yyy hh:mm:ss");
        String today;

        try {
            FileWriter fw = new FileWriter("EmpericalTest1.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            double sT, eT, x, n;
            double startTime, finishTime;
            System.out.println("v2");
            n = 10000000000.0;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Linear is " + today + "\n");
            double sum=0;
            startTime = System.currentTimeMillis();
            for(double i=1;i<=n;i *= 2){
                bw.write(i+",");
                for(int j=0;j<20;j++){
                    sT = System.currentTimeMillis();
                    x = sumInLinear(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/20 + "\n");
                sum = 0;
                System.out.println("Linear: " + i);
            }
            finishTime = System.currentTimeMillis();
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for linear is " + today + "\n");
            System.out.println("Finish running linear in " + (finishTime - startTime));


            n=100000;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Quadratic is " + today + "\n");
            sum = 0;
            startTime = System.currentTimeMillis();
            for(double i=1;i<=n;i += 1000){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInQuadratic(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
                sum = 0;
                System.out.println("Quadratic: " + i);
            }
            finishTime = System.currentTimeMillis();
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for Quadratic is " + today + "\n");
            System.out.println("Finish running Quadratic in " + (finishTime - startTime));


            n=5001;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Cubic is " + today + "\n");
            sum = 0;
            startTime = System.currentTimeMillis();
            for(double i=1;i<=n;i += 100){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInCubic(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
                sum = 0;
                System.out.println("Cubic: " + i);
            }
            finishTime = System.currentTimeMillis();
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for Cubic is " + today + "\n");
            System.out.println("Finish running Cubic in " + (finishTime - startTime));

            
            n = 1000000000000000000000000.0;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Logarithm is " + today + "\n");
            sum = 0;
            startTime = System.currentTimeMillis();
            for(double i=1;i<=n;i *=2){
                bw.write(i+",");
                for(int j=0;j<20;j++){
                    sT = System.currentTimeMillis();
                    x = sumInLogarithm(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/20 + "\n");
                sum = 0;
                System.out.println("log: "+i);
            }
            finishTime = System.currentTimeMillis();
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for Logarithm is " + today + "\n");
            System.out.println("Finish Logarithm linear in " + (finishTime - startTime));


            n = 1000000000.0;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for n lg n is " + today + "\n");
            sum = 0;
            startTime = System.currentTimeMillis();
            for(double i=1;i<=n;i *= 2){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInNlgN(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
                sum = 0;
                System.out.println("n lg n: " + i);
            }
            finishTime = System.currentTimeMillis();
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for n lg n is " + today + "\n");
            System.out.println("Finish running n lg n in " + (finishTime - startTime));


            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static double sumInNlgN(double from, double to){
        double ans = 0;
        for(double i=from;i<to;i++){ //n
            for(double j=to;j>=from;j = j/2){ //nlogn
                ans=ans+i;
            }
        }
        return ans;
    }

    public static double sumInCubic(double from, double to){
        double ans = 0;
        for(double i=from;i<=to;i++){
            for(double j=from;j<=to;j++){
                for(double k=from;k<=to;k++){
                    ans+=i;
                }
            }
        }
        return ans;
    }

    public static double sumInLogarithm(double from, double to){ //Logarithm
        double ans=0;
        for(double i=to;i>=from;i = i/2){
            ans = ans + i;
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ans;
    }

    public static double sumInQuadratic(double from, double to){ //Quadratic
        double answer = 0;
        for(double i = from; i<=to; i++){
            for(double j=from;j<=to;j++){
                answer+=j;
            }
        }
        return answer;
    }

    public static double sumInLinear(double from, double to){ //Linear
        double answer = 0;
        for(double i=from; i<=to; i++){ //linear (n)
            answer += i;
        }
        return answer;
    }

}
