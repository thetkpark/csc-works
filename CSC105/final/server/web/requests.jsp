<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 6/3/2020
  Time: 11:35
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
    <h1>Room Reservation Review</h1>
    <% request.getRequestDispatcher("GetAllRequestServlet").include(request, response); %>
    <% ResultSet result = (ResultSet) request.getAttribute("result"); %>

    <form action="UpdateStatusServlet" method="post">
        <table class="table">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Request ID</th>
                    <th>Requester Name</th>
                    <th>Requester ID</th>
                    <th>Room</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Requested Time</th>
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
                    <td><input type="checkbox" name="<%=result.getString("id")%>" value="approve"></td>
                    <td><%=result.getString("id")%></td>
                    <td><%=result.getString("requesterName")%></td>
                    <td><%=result.getString("requesterID")%></td>
                    <td><%=result.getString("room")%></td>
                    <td><%=request.getAttribute("start")%></td>
                    <td><%=request.getAttribute("end")%></td>
                    <td><%=request.getAttribute("submit")%></td>
                </tr>
                <%}%>
            </tbody>
    </table>
        <div class="form-group">
            <input  id="Approve" type="radio" name="status" value="Approve" checked>
            <label for="Approve" >Approve</label><br>
            <input id="Disapprove" type="radio" name="status" value="Disapprove">
            <label for="Disapprove">Disapprove</label><br>
            <label for="approver">Approver Name</label><br>
            <input class="form-control" id="approver" type="text" name="approver" placeholder="Someone"><br>
            <input class="btn btn-outline-primary" type="submit">
        </div>
    </form>
</body>
<style>
    body{
        margin: 1% 1%;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    #approver{
        width: 20%;
    }
</style>
</html>
