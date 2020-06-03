package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String host = "202.44.9.117";
            String databaseName = "db62130500230";
            String user = "db62130500230";
            String password = "MvdR1985";
            String url = String.format("jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s",host,databaseName,user,password);
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
