public class Main {

    public static void main(String[] args) {
	    // Sethanant Pipatpakorn 6213050023
        Heap h = new Heap(10);
        h.enqueue(15);
        h.enqueue(20);
        h.enqueue(9);
        h.enqueue(99);
        h.enqueue(83);
        h.enqueue(22);
        h.enqueue(-100);
        h.enqueue(0);
        h.enqueue(66);
        h.enqueue(200);

        for(int i=0;i<h.size;i++) System.out.print(h.heap[i] + " ");
        System.out.println();
        System.out.println(h.dequeue());
        System.out.println(h.dequeue());
        System.out.println(h.dequeue());
        for(int i=0;i<h.size;i++) System.out.print(h.heap[i] + " ");

        while(!h.isEmpty()){
            System.out.println(h.dequeue());
        }
        for(int i=0;i<h.size;i++) System.out.print(h.heap[i] + " ");
    }
}
