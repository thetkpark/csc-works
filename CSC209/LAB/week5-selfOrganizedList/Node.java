/**
 * Node
 */
public class Node {

    String info;
    Node next, prev;


    public Node(String info, Node next, Node prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }



    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "{" +
            " info='" + getInfo() + "'" +
            ", next='" + getNext() + "'" +
            ", prev='" + getPrev() + "'" +
            "}";
    }
     
    
}