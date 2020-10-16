import java.awt.Color;
import java.awt.Graphics;

public class XYPanel extends javax.swing.JPanel {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int[][] p;
    int[] pair;
    int[][] conVexHull;

    public XYPanel(int[][] points, int[] closestPair){
        this.p = points;
        this.pair = closestPair;
    }

    public void setConvex(int[][] ch){
        this.conVexHull = ch;
    }

    public void paintComponent(Graphics page){
        // Paint all points
        for(int i=0; i<p.length; i++){
            page.drawOval(p[i][0], p[i][1], 10, 10);
        }
        // Draw the line of closest pair
        page.setColor(Color.red);
        page.drawLine(p[pair[0]][0], p[pair[0]][1], p[pair[1]][0], p[pair[1]][1]);
        // Convex Hull
        page.setColor(Color.green);
        for(int i=0; i<conVexHull.length; i++){
            page.drawLine(p[conVexHull[i][0]][0], p[conVexHull[i][0]][1], p[conVexHull[i][1]][0], p[conVexHull[i][1]][1]);
        }
    }

}
