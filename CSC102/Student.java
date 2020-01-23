public class Student {
    private int id ;
    private String name ;
    public Student() {
        this(99999999, "unknown") ;
    }
    public Student(int id) {
        this.id = id ;
    }
    public Student(int id, String name) {
        this.id = id ;
        this.name = name ;
    }
    public void setName(String name) {
        this.name = name ;
    }
    public int getID(){
        return this.id;
    }
}