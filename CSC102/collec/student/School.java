package student;

import java.util.ArrayList;
import java.util.Iterator;


public class School {

    private ArrayList<Student> students;

    public School(){
        this.students = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public int getStudentCount(){
        return this.students.size();
    }

    public void getStudentInfo(){
        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            Student st = it.next();
            System.out.println(st.getInfo());
        }
    }

    
}