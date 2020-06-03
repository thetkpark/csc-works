<%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 6/3/2020
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>SIT Room Reservation</title>
  </head>
  <body>
  <h1>Student Room Reservation</h1>
  <form action="RequestServlet" method="post">
    <label for="firstname">Firstname</label>
    <input class="form-control" id="firstname" type="text" name="firstname" placeholder="Sethanant" required><br>
    <label for="lastname">Lastname</label>
    <input class="form-control" id="lastname" type="text" name="lastname" placeholder="Pipatpakorn" required><br>
    <label for="stdID">Student ID</label>
    <input class="form-control" id="stdID" type="text" name="studentid" placeholder="62130500230" required><br>
    <label for="room">Room Number</label>
    <input class="form-control" id="room" type="text" name="room" placeholder="CB2301" required><br>
    <label for="start">Start DateTime</label>
    <input class="form-control" id="start" type="datetime-local" name="start" required> <br>
    <label for="end">End DateTime</label>
    <input class="form-control" id="end" type="datetime-local" name="end" required> <br>
    <input type="submit" class="btn btn-primary"/>
  </form>
  </body>
  <style>
    body{
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }
    form{
      margin-top: 7vh;
      width: 30vw;
    }
  </style>
</html>
