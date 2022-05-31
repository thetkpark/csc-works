package csc319.j4.employeeassignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    private Integer empNo;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
    @OneToMany(mappedBy = "empNo")
    private Set<Salary> salaries;
}
