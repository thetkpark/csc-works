public class EmployeeApp {
    public static void main(String[] args){
        try{
            QueryModel q = new QueryModel();
            q.getEmployee("M%");
            q.newEmployee("123456", "01-01-2000", "fist", "last", "M", "02-02-2000");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
