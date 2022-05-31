package csc319.j4.employeeassignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Reference;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Salary {
    @Id
    private Integer empNo;
    private Integer salary;
    @Id
    private Date fromDate;
    private Date toDate;
}
