import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Main
 */
public class Main {
    //CSC209 Lab3 62130500230
    public static void main(String[] args) {
        Date startDate;
        Date endDate;
        SimpleDateFormat f = new SimpleDateFormat("dd/MMM/yyy");
        String today;

        try {
            FileWriter fw = new FileWriter("EmpericalTest.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            double sT, eT, x, n;
            
            n = 100000000.0;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Linear is " + today + "\n");
            double sum=0;
            for(double i=1;i<=n;i *= 10){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInLinear(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
            }
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for linear is " + today + "\n");

            
            n=100000;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Quadratic is " + today + "\n");
            sum = 0;
            for(double i=1;i<=n;i *= 10){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInQuadratic(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
            }
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for Quadratic is " + today + "\n");


            n=10000;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Cubic is " + today + "\n");
            sum = 0;
            for(double i=1;i<=n;i *= 10){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInCubic(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
            }
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for Cubic is " + today + "\n");


            n = 1000000000000000000.0;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for Logarithm is " + today + "\n");
            sum = 0;
            for(double i=1;i<=n;i *= 10){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInLogarithm(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
            }
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for Logarithm is " + today + "\n");


            n = 100000000.0;
            startDate = new Date();
            today = f.format(startDate);
            bw.write("Start date for n lg n is " + today + "\n");
            sum = 0;
            for(double i=1;i<=n;i *= 10){
                bw.write(i+",");
                for(int j=0;j<10;j++){
                    sT = System.currentTimeMillis();
                    x = sumInNlgN(1,i);
                    eT = System.currentTimeMillis();
                    bw.write((eT-sT)+",");
                    sum += (eT-sT);
                }
                bw.write(sum/10 + "\n");
            }
            endDate = new Date();
            today = f.format(endDate);
            bw.write("End date for n lg n is " + today + "\n");

            
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