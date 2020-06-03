<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 6/3/2020
  Time: 15:41
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
<% request.getRequestDispatcher("GetAllPresentServlet").include(request, response); %>
<% ResultSet result = (ResultSet) request.getAttribute("result"); %>
<% int count = 0; %>
<div id="top">
    <h1>Requests Status</h1>
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Request ID</th>
            <th scope="col">Requester Name</th>
            <th scope="col">Requester ID</th>
            <th scope="col">Room</th>
            <th scope="col">Start Time</th>
            <th scope="col">End Time</th>
            <th scope="col">Status</th>
            <th scope="col">Requested Time</th>
        </tr>
        </thead>
        <%while (result.next()){ %>
        <%
            //2020-06-03 11:23:51.727
            try{
                SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm MMMMM dd, yyyy");
                Date start = parser.parse(result.getString("start_time"));
                Date end = parser.parse(result.getString("end_time"));
                Date submit = parser.parse(result.getString("request_At"));
                request.setAttribute("start", formatter.format(start));
                request.setAttribute("end", formatter.format(end));
                request.setAttribute("submit", formatter.format(submit));
            }
            catch (Exception e){
                e.printStackTrace();
            }

        %>
        <tbody>
        <tr>
            <td scope="row"><%=++count%></td>
            <td><%=result.getString("id")%></td>
            <td><%=result.getString("requesterName")%></td>
            <td><%=result.getString("requesterID")%></td>
            <td><%=result.getString("room")%></td>
            <td><%=request.getAttribute("start")%></td>
            <td><%=request.getAttribute("end")%></td>
            <td><%=result.getString("status")%></td>
            <td><%=request.getAttribute("submit")%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<div id="something">
    <div id="something2">
        <a class="btn btn-outline-primary" href="<%=request.getContextPath() + "/index.jsp"%>" role="button">Home</a>
    </div>
</div>
</body>
<style>
    body{
        margin: 1rem;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
    }

    #top{
        width: 95vw;
    }

    #something2{
        display: flex;
        justify-content: center;
        margin-bottom: 1rem;
    }
</style>
</html>
