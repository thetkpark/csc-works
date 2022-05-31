package csc319.j4.employeeassignment.controller;

import csc319.j4.employeeassignment.model.Employee;
import csc319.j4.employeeassignment.model.Salary;
import csc319.j4.employeeassignment.repository.EmployeeRepository;
import csc319.j4.employeeassignment.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, SalaryRepository salaryRepository) {
        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
    }

    @GetMapping
    public Employee queryEmployee(@RequestParam int empNo) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(empNo);
        if (optionalEmployee.isEmpty()) return null;
        return optionalEmployee.get();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        this.employeeRepository.save(emp);
        return emp;
    }

    @PostMapping("/salary")
    public Salary addSalary(@RequestBody Salary salary) {
        this.salaryRepository.save(salary);
        return salary;
    }
}
