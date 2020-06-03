package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

@WebServlet(name = "UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String approver = request.getParameter("approver");
        String status = request.getParameter("status");
        System.out.println(approver);
        ArrayList<String> list = new ArrayList<>();
        Enumeration<String> keys = request.getParameterNames();
        while(keys.hasMoreElements()){
            list.add(keys.nextElement());
        }
        list.remove("approver");
        list.remove("status");
        Iterator<String> it = list.iterator();
        try{
            QueryModel q = new QueryModel();
            while(it.hasNext()){
                String id = it.next();
                q.updateRequestStatus(id, approver, status);
            }
            response.sendRedirect(request.getContextPath()+"/advisor.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
