package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
           if(session == null){
               String firstname = request.getParameter("firstname");
               String lastname = request.getParameter("lastname");
               String username = request.getParameter("username");
               String password = request.getParameter("password");
               QueryModel q =new QueryModel();
               String actual_password = q.getPassword(username);
               System.out.println("pass from db" + actual_password);
               System.out.println("pass from user" + password);
               System.out.println(firstname);
               if(actual_password.equals(password)){
                   session = request.getSession(true);
                   session.setAttribute("firstname", firstname);
                   session.setAttribute("lastname", lastname);
                   getServletContext().getRequestDispatcher("/SQLServlet").forward(request, response);
               }
               else {
                   getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
               }
           }
           else {
               String firstname = request.getParameter("firstname");
               String lastname = request.getParameter("lastname");
               session.setAttribute("firstname", firstname);
               session.setAttribute("lastname", lastname);
               getServletContext().getRequestDispatcher("/SQLServlet").forward(request, response);
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
