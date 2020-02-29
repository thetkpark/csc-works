public class Stack {
    private int[] info;
    private int size;

    public Stack(int capacity){
        this.info = new int[capacity];
        this.size = 0;
    }

    public void push(int value){
        if(size != info.length) {
            info[size] = value;
            size++;
        }
    }

    public int pop(){
        int x=-1;
        if(!isEmpty()){
            x = info[size-1];
            size--;
        }
        return x;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize() {
        return this.size;
    }
}
