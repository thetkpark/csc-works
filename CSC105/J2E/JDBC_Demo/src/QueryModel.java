import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryModel {
    Connection conn;
    PreparedStatement preparedStatement; //Compiled SQL Query -> Reduce workload of DB

    public QueryModel() throws Exception {
        conn = DBConnection.getMSSQLConnection();
    }

    public ResultSet getEmployee(){
        try{
            String query = String.format("SELECT * FROM employees.employees");
            preparedStatement = conn.prepareStatement(query); //Pre conpile the query
            ResultSet result = preparedStatement.executeQuery(); //Run the query
            while(result.next()){
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                System.out.println(first_name + " " + last_name);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public ResultSet getEmployee(String firstname){
        try{
            String query = String.format("SELECT DISTINCT first_name FROM employees.employees WHERE first_name LIKE '%s' ORDER BY first_name", firstname);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query); //Pre conpile the query
            ResultSet result = preparedStatement.executeQuery(); //Run the query
            while(result.next()){
                String first_name = result.getString("first_name");
//                String last_name = result.getString("last_name");
                System.out.println(first_name + " ");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public void newEmployee(String emp_no, String birthdate, String f_name, String l_name, String gender, String hire_date){
        try{
            String query = String.format("INSERT INTO employees.employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", emp_no, birthdate, f_name, l_name, gender, hire_date);
            System.out.println(query);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
