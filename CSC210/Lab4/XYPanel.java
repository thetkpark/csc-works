import java.awt.Graphics;

public class XYPanel extends javax.swing.JPanel {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int[][] p;
    int[] pair;
    
    public XYPanel(int[][] points, int[] closestPair){
        this.p = points;
        this.pair = closestPair;
    }

    public void paintComponent(Graphics page){
        for(int i=0; i<p.length; i++){
            page.drawOval(p[i][0], p[i][1], 10, 10);
        }
    }

}
