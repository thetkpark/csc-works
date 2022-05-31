package csc319.j4.employeeassignment.repository;

import csc319.j4.employeeassignment.model.Salary;
import csc319.j4.employeeassignment.model.SalaryId;
import org.springframework.data.repository.CrudRepository;

public interface SalaryRepository extends CrudRepository<Salary, SalaryId> {
}
