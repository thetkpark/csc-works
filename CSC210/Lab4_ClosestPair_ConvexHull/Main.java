import javax.swing.JFrame;

/**
 * ClosestPair
 */
public class Main {

    public static void main(String[] args) {
        int[][] point = new int[10][2];
        point[0][0] = 100; point[0][1] = 50;
        point[1][0] = 200; point[1][1] = 150;
        point[2][0] = 150; point[2][1] = 300;
        point[3][0] = 100; point[3][1] = 500;
        point[4][0] = 500; point[4][1] = 180;
        point[5][0] = 250; point[5][1] = 120;
        point[6][0] = 80; point[6][1] = 40;
        point[7][0] = 100; point[7][1] = 150;
        point[8][0] = 400; point[8][1] = 360;
        point[9][0] = 50; point[9][1] = 190;

        // Closest Pair
        int[] clostestPair = new int[2];
        clostestPair = findClosestPair(point);
        System.out.println(clostestPair[0] + " " + clostestPair[1]);

        JFrame frame = new JFrame("Closest Pair Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        XYPanel panel = new XYPanel(point, clostestPair);
        frame.getContentPane().add(panel);

        // Convex Hull problem
        int[][] boundary = findConvex(point);
        panel.setConvex(boundary);

        frame.pack();
        frame.setVisible(true);
    }

    public static int[][] findConvex(int[][] p){
        int[][] boundary = new int[p.length][2];
        int a,b,c, cOfPoint;
        int count=0;
        for(int i=0; i<p.length-1; i++){
            for(int j=i+1; j<p.length; j++){
                a = p[j][1] - p[i][1];
                b = p[i][0] - p[j][0];
                c = p[i][0] * p[j][1] - p[j][0] * p[i][1];
                int moreThanC = 0, lessThanC = 0, k=0;
                for(k=0; k<p.length; k++){
                    cOfPoint = a*p[k][0] + b*p[k][1];
                    if(cOfPoint >= c) moreThanC++;
                    if(cOfPoint <= c) lessThanC++;
                    if(moreThanC != (k+1) && lessThanC != (k+1)) break;
                }
                if(k==p.length){
                    boundary[count][0] = i;
                    boundary[count][1] = j;
                    count++;
                }
            }
        }
        return boundary;
    }

    public static int[] findClosestPair(int[][] p){
        int closest1 = 0, closest2 = 0; // Closest Pair
        double closestDistanceSquare = Integer.MAX_VALUE;
        for(int i=0; i<p.length-1; i++){
            for(int j=i+1; j<p.length; j++){
                double x = p[i][0] - p[j][0];
                double y = p[i][1] - p[j][1];

                double distanceSquare = Math.pow(x, 2) + Math.pow(y, 2);
                if(distanceSquare < closestDistanceSquare) {
                    closest1 = i;
                    closest2 = j;
                    closestDistanceSquare = distanceSquare;
                }
            }
        }

        int[] temp = {closest1, closest2};
        return temp;
    }
}