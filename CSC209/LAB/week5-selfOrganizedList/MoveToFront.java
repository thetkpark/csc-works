/**
 * MoveToFront
 */
public class MoveToFront extends DoublyLinkedList {

    public MoveToFront() {
        super();
    }

    public void access(String value) {
        Node temp;
        for (temp = head; temp != null && !temp.info.equalsIgnoreCase(value); temp = temp.next);
        if (temp != null) {
            // System.out.println(temp.getInfo() + " is founded");
            if (temp != tail && temp!=head) {
                // Move to the front
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                // Make temp to be head
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
            else if(temp==tail){
                //move next and prev of nodes around temp
                temp.prev.next = null;
                tail = tail.prev;
                //make temp to be head
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }

        } else { //not found
            // System.out.println(value + " is not founded");
            addToTail(value);
        }
    }

}