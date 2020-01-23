/**
 * Week5
 */
public class Week5 {

    public static void main(String[] args) {
        Student[] std = new Student[4];
        std[0] = new Student(01, "name");
        System.out.println(std[0].id);
    }
}
class Student{
    int id;
    String name;
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}