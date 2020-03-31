package controller;

import model.JsonWebToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try{
//            JsonWebToken jwt = new JsonWebToken();
//            String token = jwt.createJWT();
//            response.setHeader("token", token);
//        }catch(Exception e){
//            e.printStackTrace();
//
//        }
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(10);
        session.setAttribute("userid", "123456");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            JsonWebToken jwt = new JsonWebToken();
//            String token = request.getHeader("token");
//            boolean isValid = jwt.verifyJWT(token);
//            if(!isValid){
//                getServletContext().getRequestDispatcher("Login.jsp").forward(request, response);
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        HttpSession session = request.getSession(false);
//        if(session == null){
//            response.sendRedirect(request.getContextPath() + "/Login.jsp");
//        }

        HttpSession session = request.getSession(false);
        session.invalidate();

    }
}
