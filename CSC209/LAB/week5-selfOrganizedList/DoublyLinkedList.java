/**
 * DoublyLinkedList
 */
public class DoublyLinkedList {

    Node head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public void addToTail(String newInfo) {
        if (this.head == null) {
            head = tail = new Node(newInfo, null, this.tail);
        } else {
            this.tail = new Node(newInfo, null, this.tail);
            this.tail.prev.next = this.tail;
        }
    }

    public void printAll(){
        for(Node temp = head; temp != null; temp = temp.next){
            System.out.print(temp.getInfo() + " ");
        }
        System.out.println("");
    }

}