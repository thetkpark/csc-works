<%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 4/1/2020
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Information</title>
    <style>
        #error{
            color: red;
        }
    </style>
</head>
<body>
    <h1>Login Page</h1>
    <h3>Search for your information</h3>
    <h4>The result will return in application/json</h4>
    <form action="LoginServlet" method="get"> <br>
        username: <input type="text" name="username"><br>
        password: <input type="password" name="password"><br>
        <input type="submit">
    </form>
    <p id="error">${message}</p>
</body>
</html>
