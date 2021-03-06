package model;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryModel {
    Connection conn;
    PreparedStatement preparedStatement;
    public QueryModel() throws Exception {
        conn = DBConnection.getMSSSQLConnection();
    }

    public ResultSet SearchEmployee(String f_name, String l_name) throws Exception{
        try{
            String query = String.format("SELECT first_name, last_name, hire_date, dept_name, MAX(salary) AS 'salary'\n" +
                    "FROM employees\n" +
                    "JOIN dept_emp d on employees.employees.emp_no = d.emp_no\n" +
                    "JOIN departments de on d.dept_no = de.dept_no\n" +
                    "JOIN salaries s on employees.emp_no = s.emp_no\n" +
                    "WHERE first_name = '%s' AND last_name = '%s'\n" +
                    "GROUP BY first_name, last_name, hire_date, dept_name", f_name, l_name);
//            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

//    public String getEmployee(String f_name, String l_name){
//        try{
//            String query = String.format("SELECT * FROM employees WHERE first_name = '%s' AND last_name = '%s'", f_name, l_name);
//            preparedStatement = conn.prepareStatement(query);
//            ResultSet result = preparedStatement.executeQuery();
//            result.next();
//            String frist_name = result.getString("first_name");
//            String last_name = result.getString("last_name");
//            String hire_date = result.getString("hire_date");
//            String emp_no = result.getString("emp_no");
//            String birthdate = result.getString("birth_date");
//            String gender = result.getString("gender");
//            Gson gson = new Gson();
//            return gson.toJson(new Employee(emp_no, birthdate,frist_name, last_name, gender, hire_date));
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return "";
//    }



    public void insertEmployee(String emp_no, String birthdate, String f_name, String l_name, String gender, String hire_date) throws Exception{
        try{
            String query = String.format("INSERT INTO employees.employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", emp_no, birthdate, f_name, l_name, gender, hire_date);
//            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }



}
