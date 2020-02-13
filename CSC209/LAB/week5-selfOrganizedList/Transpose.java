/**
 * Transpose
 */
public class Transpose extends DoublyLinkedList {

    public Transpose(){
        super();
    }

    public void access(String value){
        Node temp;
        for (temp = head; temp != null && !temp.info.equalsIgnoreCase(value); temp = temp.next);
        if(temp!=null){
            if(head==temp){} //if at the front -> do nothing
            else {
                String tempValue = temp.getInfo();
                temp.info = temp.prev.info;
                temp.prev.info = tempValue;
            }
        }
        else{ //if not found -> add
            addToTail(value);
        }
        
        
        // if (temp != null) {
        //     if(temp==head.next){
        //         head.next = temp.next;
        //         head.prev = temp;
        //         temp.next.prev = temp.next;
        //         temp.next = head;
        //         head = temp;
        //     }
        //     else if(temp!=head && temp!=tail){ //temp is in the middle
        //         temp.prev.prev.next = temp;
        //         temp.prev.next = temp.next;
        //         temp.next.prev = temp.prev;
        //         temp.prev = temp.prev.prev;
        //         temp.next.prev.prev = temp;
        //         temp.next = temp.next.prev;
        //     }
            // else if(temp==tail){

            // }
            

        // } else { //not found
        //     // System.out.println(value + " is not founded");
        //     addToTail(value);
        // }

    }
}