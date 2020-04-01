package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryModel {
    Connection conn;
    PreparedStatement preparedStatement;
    public QueryModel() throws Exception {
        conn = DBConnection.getMSSQLConnection();
    }

    public ResultSet getAccount(String username) throws SQLException {
        try{
            String query = String.format("SELECT password, emp_no\n" +
                    "FROM useraccount\n" +
                    "WHERE username = '%s'", username);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public ResultSet getEmployeeInfo(String number) throws SQLException {
        try{
            String query = String.format("SELECT employees.employees.emp_no,employees.employees.first_name, employees.employees.gender,employees.employees.last_name,\n" +
                    "employees.employees.hire_date, dept_name, title ,MAX(salary) AS 'salary', employees.employees.birth_date\n" +
                    "FROM employees\n" +
                    "JOIN salaries s on employees.emp_no = s.emp_no\n" +
                    "JOIN dept_emp d on employees.employees.emp_no = d.emp_no\n" +
                    "JOIN departments d2 on d.dept_no = d2.dept_no\n" +
                    "JOIN titles t on employees.emp_no = t.emp_no\n" +
                    "WHERE employees.employees.emp_no = '%s'\n" +
                    "GROUP BY employees.employees.emp_no, employees.employees.gender,employees.employees.first_name,\n" +
                    "employees.employees.last_name, employees.employees.hire_date, dept_name, title, employees.employees.birth_date", number);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
