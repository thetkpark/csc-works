<%-- 
    Document   : index
    Created on : Feb 26, 2020, 4:59:38 PM
    Author     : CSC102-105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My calculator</title>
    </head>
    <body>
        <h1>Hello this is my calculator!</h1>
        <form action="SimpleCalculatorServlet" method="GET">
            operand: <input type="number" name="operand">
            operator: <input type="number" name="operator">
            operation: <input type="text" name="operation">
            <input type="submit" value="calculate">
        </form>
        
        <h1>
            result is ${calculator.result}
        </h1>
        
    </body>
</html>
