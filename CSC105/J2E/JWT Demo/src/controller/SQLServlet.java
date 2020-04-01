package controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.JsonWebToken;
import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "SQLServlet")
public class SQLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try{
//            String f_name = request.getParameter("firstname");
//            String l_name = request.getParameter("lastname");
//            QueryModel q = new QueryModel();
//            String json = q.(f_name, l_name);
//            PrintWriter out = response.getWriter();
//            response.setContentType("application/json");
//            out.print(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String userid = "";
            HttpSession session = request.getSession(false);
            if(session==null) response.sendRedirect(request.getContextPath() + "/login.html");
            else {
//                System.out.println("Not Null");
                userid = session.getAttribute("userid").toString();
                System.out.println(userid);
            }

            PrintWriter out = response.getWriter();
            String f_name = request.getParameter("firstname");
            String l_name = request.getParameter("lastname");
            QueryModel q = new QueryModel();
            ResultSet result = q.SearchEmployee(f_name, l_name);
            result.next();
            String frist_name = result.getString("first_name");
            String last_name = result.getString("last_name");
            String hire_date = result.getString("hire_date");
            out.print(String.format("\"data\": \"%s %s %s\"", frist_name, last_name, hire_date));
        }catch(Exception e){
            e.printStackTrace();

        }
    }

}
