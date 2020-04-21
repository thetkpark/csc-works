public class Heap {
    int[] heap;
    int size;

    public Heap() {
        this(100);
    }

    public Heap(int maxMember) {
        this.heap = new int[maxMember];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.heap.length;
    }

    public void enqueue(int newValue){
        // 0.) Is fulled?
        if(isFull()){
            System.out.println("The heap is fulled");
            return;
        }

        // 1.) Add to the end of array
        this.heap[this.size] = newValue;
        int indexOfValue =  this.size;
        this.size++;

        // 2.) Move up
        int parentIndex = (int) Math.floor((indexOfValue-1)/2.0);
        while(indexOfValue > 0 && this.heap[parentIndex] < this.heap[indexOfValue]){
            // Swap parent with child
            int temp = this.heap[parentIndex];
            this.heap[parentIndex] = this.heap[indexOfValue];
            this.heap[indexOfValue] = temp;

            //Move the pointer
            indexOfValue = parentIndex;
            parentIndex = (int) Math.floor((indexOfValue-1)/2.0);
        }
    }

    public int dequeue() {

        // 1.) Take out the root
        int max = this.heap[0];

        // 2.) The last member replace the root
        this.heap[0] = this.heap[this.size-1];
        this.size--;

        // 3.) Move down
        int indexOfReplacedNode = 0;
        int leftChild = 2*indexOfReplacedNode + 1;
        int rightChild = 2*indexOfReplacedNode + 2;
        while((leftChild < size && this.heap[indexOfReplacedNode] < this.heap[leftChild]) ||
                (rightChild<size && this.heap[indexOfReplacedNode] < this.heap[rightChild])){
            int swapIndex;
            // Have only left child
            if(leftChild == this.size-1){
                // Swap with the left child
                swapIndex = leftChild;
            }
            else { // Have both left and right child
                if(this.heap[leftChild] > this.heap[rightChild]) { // If left is bigger
                    swapIndex = leftChild;
                }
                else { // Then right is bigger
                    swapIndex = rightChild;
                }
            }
            swap(this.heap, indexOfReplacedNode, swapIndex);

            // Re calculate the pointers
            indexOfReplacedNode = swapIndex;
            leftChild = 2*indexOfReplacedNode + 1;
            rightChild = 2*indexOfReplacedNode + 2;
        }

        return max;
    }

    public void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
