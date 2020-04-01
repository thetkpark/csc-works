package controller;

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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
           String username = request.getParameter("username");
           String password = request.getParameter("password");

           QueryModel q =new QueryModel();
           ResultSet result = q.getAccount(username);
           if(!result.next()) redirectToLogin(request, response);
           else{
               String actual_password = result.getString("password");
               String emp_no = result.getString("emp_no");

               if(actual_password.equals(password)){
                   HttpSession session = request.getSession(true);
                   session.setAttribute("emp_no", emp_no);
                   getServletContext().getRequestDispatcher("/SQLServlet").forward(request, response);
               }
               else {
                   redirectToLogin(request, response);
               }
           }

        }
        catch (Exception e){
            e.printStackTrace();
            response.setContentType("application/json");
            //For return error to client
            PrintWriter out = response.getWriter();
            response.setStatus(500);
            String error = e.toString();
            String json = String.format("{\"success\": false, \"message\": \"%s\"}", error);
            out.print(json);
        }
    }

    protected void redirectToLogin(HttpServletRequest request, HttpServletResponse response){
        try{
            String message = "Incorrect username or password";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
