public class EmployeeApp {
    public static void main(String[] args){
        try{
            QueryModel q = new QueryModel();
            q.getEmployee();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
