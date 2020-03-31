<%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 3/29/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form action="SQLServlet" method="get">
  <label>Name: </label><input type="text" name="first_name"><br>
  <label>Last Name: </label><input type="text" name="last_name"><br>
  <input type="submit">
</form>



<p>Insert</p>
<form action="SQLServlet" method="post">
  <label>Name: </label><input type="text" name="first_name"><br>
  <label>Last Name: </label><input type="text" name="last_name"><br>
  <label>Birth Date: </label><input type="text" name="birth_date"><br>
  <label>Hiring Date: </label><input type="text" name="hire_date"><br>
  <label>Gender: </label><input type="text" name="gender"><br>
  <label>Employee Number: </label><input type="text" name="emp_no"><br>
  <input type="submit">
</form>

</body>
</html>