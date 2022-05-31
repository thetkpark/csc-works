package csc319.j4.employeeassignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SalaryId implements Serializable {
    @Id
    private Integer empNo;
    @Id
    private Date fromDate;
}
