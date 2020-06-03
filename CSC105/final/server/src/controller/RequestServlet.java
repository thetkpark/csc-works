package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String studentID = request.getParameter("studentid");
        String room = request.getParameter("room");
        String start = request.getParameter("start").replaceAll("T", " ");
        String end = request.getParameter("end").replaceAll("T", " ");

        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("studentID", studentID);
        request.setAttribute("room", room);
        request.setAttribute("start", formatDateTime(start));
        request.setAttribute("end", formatDateTime(end));
        try{
            QueryModel q = new QueryModel();
            q.addNewRequest(firstname, lastname, studentID, room, start, end);
            getServletContext().getRequestDispatcher("/Submited.jsp").forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String formatDateTime(String dateTime){
        //2020-06-03 14:34
        try{
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm MMMMM dd, yyyy");
            Date date = parser.parse(dateTime);
            return formatter.format(date);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

class Request {
    String firstname;
    String lastname;
    String studentID;
    String room ;
    String start;
    String end;

    public Request(String firstname, String lastname, String studentID, String room, String start, String end) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
        this.room = room;
        this.start = start;
        this.end = end;
    }
}


