<%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 3/25/2020
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JDBC Exercise</title>
  </head>
  <body>
    <h1>Search employee</h1>
    <h2>GET /JDBC_Exercise_war_exploded/SQLServlet</h2>
    <p>Provide the "firstname" and "lastname" parameters when make the request</p>
    <p>Return type: application/json</p>
    <p>Example: localhost:8080/JDBC_Exercise_war_exploded/SQLServlet?firstname=Maya&lastname=Anido</p>

    <h1>Insert new employee</h1>
    <h2>POST /JDBC_Exercise_war_exploded/SQLServlet</h2>
    <p>Provide the "emo_no", "firstname", "lastname", "gender", "birthdate", and "hire_date" arameters when make the request</p>
    <p>Return type: application/json</p>
    <p>Example: localhost:8080/JDBC_Exercise_war_exploded/SQLServlet?firstname=Someone&lastname=Somelastname&emp_no=9843121&birthdate=01-01-1999&gender=F&hire_date=01-01-1999</p>
  </body>
</html>
