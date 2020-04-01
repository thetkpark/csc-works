package controller;

import com.google.gson.Gson;
import model.Employee;
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            QueryModel q = new QueryModel();
            String empno = session.getAttribute("emp_no").toString();
            ResultSet result = q.getEmployeeInfo(empno);

            while (result.next()){
                String emp_no = result.getString("emp_no");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String salary = result.getString("salary");
                String dept_name = result.getString("dept_name");
                String birth_date = result.getString("birth_date");
                String hire_date = result.getString("hire_date");
                String gender = result.getString("gender");
                String title = result.getString("title");

                Employee employee = new Employee(emp_no, first_name, last_name, salary, dept_name, birth_date, hire_date, gender, title);
                Gson gson = new Gson();
                out.print(gson.toJson(employee));
            }

        }
        catch(Exception e){
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
}
