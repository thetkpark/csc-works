/**
 * Plain
 */
public class Plain extends DoublyLinkedList {

    public Plain(){
        super();
    }

    public void access(String value){
        Node temp;
        for(temp=head; temp != null && !temp.info.equalsIgnoreCase(value) ; temp=temp.next);
        if(temp != null){
            // System.out.println(temp.getInfo() + " is founded");
        }
        else{
            // System.out.println(value + " is not founded");
            addToTail(value);
        }
    }
    
}