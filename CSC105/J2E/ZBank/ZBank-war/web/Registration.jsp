<%-- 
    Document   : Registration
    Created on : Mar 11, 2020, 2:44:37 PM
    Author     : CSC102-105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Registration</title>
    </head>
    <body>
        <h1>Customer Registration</h1>
        <form action="RegistrationServlet" method="post">
            <label>Name</label>
            <input type="text" name="name" placeholder="Sia Oh"><br>
            <label>Citizen ID</label>
            <input type="text" name="citizenid" placeholder="11234567891012"><br>
            <label>Birthdate</label>
            <input type="date" name="birthdate"><br>
            <label>Home address</label>
            <input type="text" name="address" placeholder="888/73 Parque"> <br>
            <input type="submit">
        </form>
        
        <div>
            Customer ID: ${customer.customerID}<br>
            Name: ${customer.name}<br>
            Birth Date: ${customer.birthdate}<br>
            Address: ${customer.address}<br>
        </div>
    </body>
</html>
