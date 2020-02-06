/**
 * Node
 */
public class Node {
    Student studentInfo;
    Node next;


    public Node(int id, String name, String address, String phoneNumber, double gpa, Node next){
        studentInfo = new Student(id, name, address, phoneNumber, gpa);
        this.next = next;
    }

    public Node(Student studentInfo, Node next) {
        this.studentInfo = studentInfo;
        this.next = next;
    }

    

    
}