package model;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getMSSSQLConnection() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = "EXAMPLE";
            String host = "202.44.9.117:1433";
            String user = "csc105";
            String password = "csprogramming";
            String url = String.format("jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s", host, database, user, password);
            Connection conn = DriverManager.getConnection(url);
            return conn;

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
