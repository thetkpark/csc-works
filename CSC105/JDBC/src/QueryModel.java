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
}
