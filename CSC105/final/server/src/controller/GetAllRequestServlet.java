package controller;

import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "GetAllRequestServlet")
public class GetAllRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            QueryModel q = new QueryModel();
            ResultSet result = q.getAllRequest();
            request.setAttribute("result", result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
