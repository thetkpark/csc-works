/**
 * Student
 */
public class Student {
    int id;
    String name;
    String address;
    String phoneNumber;
    double gpa;

    public Student(int id){
        this(id, "", "", "", 0.0);
    }

    public Student(int id, String name, String address, String phoneNumber, double gpa) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gpa = gpa;
    }

    

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getGpa() {
		return this.gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
    }
    

    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", name='" + name + "'" +
            ", address='" + address + "'" +
            ", phoneNumber='" + phoneNumber + "'" +
            ", gpa='" + gpa + "'" +
            "}";
    }






}