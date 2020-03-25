package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getMSSQLConnection() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String database = System.getenv("MSSQL_DB");
            String host = System.getenv("MSSQL_HOST");
            String user = System.getenv("MSSQL_USER");
            String password = System.getenv("MSSQL_PASSWORD");
            String url = String.format("jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s", host, database, user, password);
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
