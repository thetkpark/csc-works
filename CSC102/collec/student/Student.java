package student;
/**
 * Student
 */
public class Student {
    private int studentID;
    private String name;
    private String faculty;

    public Student(int studentID, String name, String faculty){
        this.studentID = studentID;
        this.name = name;
        this.faculty = faculty;
    }
    
    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getInfo(){
        return "ID: " + this.studentID + "\nName: " + this.name + "\nFaculty: " + this.faculty;
    }

    
}