/**
 * SinglyLinkedList
 */
public class SinglyLinkedList {
    Node head, tail;
    
    public SinglyLinkedList(){ // construct empty list
        head = tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addToHead(int id, String name, String address, String phoneNumber, double gpa){
        //1. Create a new node which point to previous head
        //2. Put values into the node
        //3. next will point to previous head
        //4. head point to this node
        head = new Node(id, name, address, phoneNumber, gpa, head);
        if(this.tail == null) this.tail = this.head;
    }

    public void addToTail(int id, String name, String address, String phoneNumber, double gpa){
        //1. Create new node
        //2. add values to the node
        //3. next points to null
        //4. current tail node points to the new node
        //5. tail move to the new node 
        if(this.isEmpty()){ //if head == null (linked list is empty)
            this.head = this.tail = new Node(id, name, address, phoneNumber, gpa, null);
        }
        else {
            this.tail.next = new Node(id, name, address, phoneNumber, gpa, null);
            this.tail = this.tail.next;
        }
    }

    public void printAllName(){
        for(Node temp = head; temp != null; temp = temp.next){
            System.out.print(temp.studentInfo.getName() + "->");
        }
        System.out.println("");
    }

    public Student searchById(int id){
        Node temp;
        for(temp = head; temp != null; temp = temp.next){
            if(temp.studentInfo.getId() == id){
                return temp.studentInfo;
            }
        }
        return null;
    }

    public Student searchByName(String name){
        Node temp;
        for(temp = head; temp != null; temp = temp.next){
            if(temp.studentInfo.getName().equalsIgnoreCase(name)){
                return temp.studentInfo;
            }
        }
        return null;
    }

    public void removeFromHead(){
        if(this.head == this.tail) this.head = this.tail = null; //there is only one node
        else this.head = this.head.next;
    }

    public void removeFromTail(){
        if(this.head == this.tail) this.head = this.tail = null; //there is only one node
        else {
            Node temp = this.head;
            while(temp.next.next != null) temp = temp.next;
            temp.next = null;
        }
    }

    public void insert(int id, String name, String address, String phoneNumber, double gpa, int position){
        //1. Search P-1th Node
        //2. create a new node
        //3. put values in the new node
        //4. new node point to the temp,next node
        //5. p-1th node point to the new node
        
        Node temp = this.head;
        int count = 1;
        while(count<position-1 && temp.next!=null){
            count++;
            temp = temp.next;
        }
        temp.next = new Node(id, name, address, phoneNumber, gpa, temp.next);
        
    }

    
}