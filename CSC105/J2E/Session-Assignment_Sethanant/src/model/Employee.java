package model;

public class Employee {
    String emp_no;
    String first_name;
    String last_name;
    String gender;
    String birth_date;
    String hire_date;
    String salary;
    String dept_name;
    String title;

    public Employee(String emp_no, String first_name, String last_name, String salary, String dept_name, String birth_date, String hire_date, String gender, String title) {
        this.emp_no = emp_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.dept_name = dept_name;
        this.birth_date = birth_date;
        this.hire_date = hire_date;
        this.gender = gender;
        this.title = title;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
