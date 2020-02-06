/**
 * Main
 */
public class Main {
    //CSC209 Lab4 62130500230
    public static void main(String[] args) {

        SinglyLinkedList stuList = new SinglyLinkedList();
        stuList.addToHead(1, "Tom", "New York", "011", 3.2);
        System.out.println(stuList.head.studentInfo.toString());
        stuList.addToHead(2, "Ann", "BKK", "222", 3.6);
        System.out.println(stuList.head.next.studentInfo.toString());
        System.out.println(stuList.head.studentInfo.toString());
        stuList.addToHead(3, "Jack", "London", "533", 2.9);
        System.out.println(stuList.head.next.next.studentInfo.toString());
        stuList.addToTail(4, "Sarah", "Tokyo", "444", 3.7);
        System.out.println(stuList.head.next.next.next.studentInfo.toString());
        stuList.printAllName();
        stuList.addToTail(5, "Jim", "Berlin", "555", 2.1);
        stuList.addToHead(6, "Nicole", "Paris", "666", 3.4);
        stuList.printAllName();
        
        Student x = stuList.searchById(5);
        System.out.println( x!=null? x.getName() : "Not Found");
        x = stuList.searchByName("Ann");
        System.out.println( x!=null? x.toString() : "Not Found");

        stuList.removeFromHead();
        stuList.printAllName();

        stuList.removeFromTail();
        stuList.printAllName();
        // stuList.removeFromTail();
        // stuList.printAllName();
        // stuList.removeFromTail();
        // stuList.printAllName();
        // stuList.removeFromTail();
        // stuList.printAllName();

        stuList.insert(7, "Kick Buttowasky", "LA", "777", 1.5, 5);
        stuList.printAllName();

    }    
}