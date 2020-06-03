package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;

public class QueryModel {
    Connection conn;
    PreparedStatement preparedStatement;
    public QueryModel() throws Exception {
        conn = DBConnection.getMSSQLConnection();
    }

    public void addNewRequest(String firstname, String lastname, String studentID, String room, String start, String end) throws SQLException {
        String requester = firstname + " " + lastname;
        String query = String.format("INSERT INTO dbo.Requests (requesterID, requesterName, room, start_time, end_time)\n" +
                "VALUES ('%s', '%s', '%s', '%s', '%s')", studentID, requester, room, start, end);
        execute(query);
    }

    public void updateRequestStatus(String id, String approver, String status) throws SQLException {
        String query = String.format("UPDATE dbo.Requests SET approver='%s', approve_At=CURRENT_TIMESTAMP\n, status='%s'" +
                "WHERE id='%s'", approver, status, id);
        execute(query);
    }

    public ResultSet getAllRequest() throws SQLException {
        String query = "SELECT * FROM dbo.Requests WHERE status = 'Waiting' ORDER BY start_time ASC";
        ResultSet result = executeQuery(query);
        return result;
    }

    public void execute(String query) throws SQLException {
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ResultSet executeQuery (String query) throws SQLException {
        try{
            preparedStatement = conn.prepareStatement(query);
            return preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

}
