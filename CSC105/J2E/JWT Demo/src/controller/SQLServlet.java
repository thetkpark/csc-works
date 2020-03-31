package controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.JsonWebToken;
import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "SQLServlet")
public class SQLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            JsonWebToken jwt = new JsonWebToken();
            String token = request.getHeader("token");
            boolean isValid = jwt.verifyJWT(token);
            response.setContentType("application/json");
            out.print("\"Valid\": " + isValid);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            JsonWebToken jwt = new JsonWebToken();
            String token = jwt.createJWT();
            response.setHeader("token", token);
        }catch(Exception e){
            e.printStackTrace();

        }
    }

}
