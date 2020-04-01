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

@WebServlet(name = "SQLServlet")
public class SQLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            QueryModel q = new QueryModel();
            String emp_no = request.getParameter("emp_no").toString();
            String birthdate = request.getParameter("birthdate").toString();
            String f_name = request.getParameter("firstname").toString();
            String l_name = request.getParameter("lastname").toString();
            String gender = request.getParameter("gender").toString();
            String hire_date = request.getParameter("hire_date").toString();

            q.insertEmployee(emp_no, birthdate, f_name, l_name, gender, hire_date);
            response.setStatus(201);
            out.print("\"success\": true");
        }
        catch(Exception e){
            e.printStackTrace();
            //For return error to client
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setStatus(500);
            String error = e.toString();
            String json = String.format("\"success\": false, \"message\": \"%s\"", error);
            out.print(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            QueryModel q = new QueryModel();
            Object f_name = session.getAttribute("firstname");
            Object l_name = session.getAttribute("lastname");
            ResultSet result = q.SearchEmployee(f_name.toString(), l_name.toString());
            Boolean empty = true;
            while (result.next()){
                empty = false;
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String salary = result.getString("salary");
                String dept_name = result.getString("dept_name");
                String hire_date = result.getString("hire_date");
                String json = String.format("{ \"firstname\": \"%s\", \"lastname\": \"%s\", \"hire_date\": \"%s\", \"department\": \"%s\", \"salary\": \"%s\" }",
                        first_name, last_name, hire_date, dept_name, salary);
                out.print(json);
            }
            //Check if there is no result
            if(empty){
                String json = "\"error\": \"Not Found\"";
                response.setStatus(404);
                out.print(json);
            }

        }
        catch(Exception e){
            e.printStackTrace();
            response.setContentType("application/json");
            //For return error to client
            PrintWriter out = response.getWriter();
            response.setStatus(500);
            String error = e.toString();
            String json = String.format("\"success\": false, \"message\": \"%s\"", error);
            out.print(json);
        }
    }
}
