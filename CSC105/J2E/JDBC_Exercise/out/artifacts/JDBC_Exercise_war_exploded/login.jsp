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
    <title>Login</title>
</head>
<body>
    <h1>Login Page</h1>
    <form action="LoginServlet" method="get"> <br>
        firstname: <input type="text" name="firstname"><br>
        lastname:<input type="text" name="lastname"><br>
        username: <input type="text" name="username"><br>
        password: <input type="password" name="password"><br>
        <input type="submit">
    </form>
</body>
</html>
