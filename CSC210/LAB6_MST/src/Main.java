import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	    Graph g = new Graph(6);
        g.nodeList[0].add(new Edge(0,1,3));
        g.nodeList[0].add(new Edge(0,4,6));
        g.nodeList[0].add(new Edge(0,5,5));
        g.nodeList[1].add(new Edge(1,0,3));
        g.nodeList[1].add(new Edge(1,2,1));
        g.nodeList[1].add(new Edge(1,5,4));
        g.nodeList[2].add(new Edge(2,1,1));
        g.nodeList[2].add(new Edge(2,3,6));
        g.nodeList[2].add(new Edge(2,5,4));
        g.nodeList[3].add(new Edge(3,2,6));
        g.nodeList[3].add(new Edge(3,4,8));
        g.nodeList[3].add(new Edge(3,5,5));
        g.nodeList[4].add(new Edge(4,0,6));
        g.nodeList[4].add(new Edge(4,3,8));
        g.nodeList[4].add(new Edge(4,5,2));
        g.nodeList[5].add(new Edge(5,0,5));
        g.nodeList[5].add(new Edge(5,1,4));
        g.nodeList[5].add(new Edge(5,2,4));
        g.nodeList[5].add(new Edge(5,3,5));
        g.nodeList[5].add(new Edge(5,4,2));
        g.primAlgo();
    }


}
