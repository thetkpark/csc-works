import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
    LinkedList nodeList[];
    int NUM_NODES;
    public Graph(int nodes) {
        this.NUM_NODES = nodes;
        nodeList = new LinkedList[this.NUM_NODES];
        for(int i=0; i<this.nodeList.length; i++){
            nodeList[i] = new LinkedList();
        }
    }

    public void primAlgo(){
        LinkedList<Edge> treeVertices = new LinkedList<Edge>();
        LinkedList<Edge> remainingVertices = new LinkedList<Edge>();
        ListIterator<Edge> iterator;
        Edge e;
        int min = Integer.MAX_VALUE;
        treeVertices.add(new Edge(0,0,-1));
        for(int i=1; i<NUM_NODES; i++) {

            iterator = nodeList[0].listIterator();
            // Search if A(0) can go to node i
            for (e = iterator.next(); e.to != i && iterator.hasNext(); e = iterator.next()) { }
            // If can go to node i
            if(e.to == i){
                if(e.distance < min){
                    remainingVertices.addFirst(e);
                    min = e.distance;
                }
                else {
                    remainingVertices.add(e);
                }
            }
            // Node A cannot go to node i
            else {
                remainingVertices.add(new Edge(0, i, Integer.MAX_VALUE));
            }
        }
        // Printout
        iterator = remainingVertices.listIterator();
        while (iterator.hasNext()){
            Edge x = iterator.next();
            System.out.println(x.to + "(" + x.from + "," + x.distance + ")");
        }
        System.out.println();
        Edge minEdge = remainingVertices.removeFirst();
        treeVertices.add(minEdge);

        ListIterator<Edge> iteratorForRemain;
        Edge eRemain;
        while (!remainingVertices.isEmpty()) {
            min = Integer.MAX_VALUE;
            int minIndex = 0;
            iteratorForRemain = remainingVertices.listIterator();
            // Check if which remaining vertices that has distance more than new node in treeVertices
            for (int i=0; iteratorForRemain.hasNext(); i++){
                eRemain = iteratorForRemain.next();
                iterator = nodeList[minEdge.to].listIterator();
                while(iterator.hasNext()){
                    e = iterator.next();
                    if(e.to == eRemain.to && e.distance < eRemain.distance){
                        eRemain.from = e.from;
                        eRemain.distance = e.distance;
                    }
                }
                if(eRemain.distance < min){
                    minIndex = i;
                    min = eRemain.distance;
                }
            }
            iterator = remainingVertices.listIterator();
            while (iterator.hasNext()){
                Edge x = iterator.next();
                System.out.print(x.to + "(" + x.from + "," + x.distance + "), ");
            }
            System.out.println();
            minEdge = remainingVertices.remove(minIndex);
            treeVertices.addFirst(minEdge);
        }

        System.out.println("\nMinimum Spanning Tree compose of the following edges\n");
        iterator = treeVertices.listIterator();
        while (iterator.hasNext()){
            Edge x = iterator.next();
            System.out.print(x.to + "(" + x.from + "," + x.distance + ") ");
        }
    }
}
