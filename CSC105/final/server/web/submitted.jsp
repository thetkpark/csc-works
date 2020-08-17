<%--
  Created by IntelliJ IDEA.
  User: the_t
  Date: 6/3/2020
  Time: 11:24
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
    <div id="success" class="alert alert-success" role="alert">
        <h4 class="alert-heading">Your request has been submitted</h4>
        <p>The advisor will review your request as soon as possible</p>
        <div class="accordion" id="accordionExample">
            <div id="card" class="card">
                <div class="card-header" id="headingOne">
                    <h2 class="mb-0">
                        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Your request
                        </button>
                    </h2>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                    <div class="card-body">
                        <p class="font-weight-bold">Firstname</p>
                        <p class="font-weight-normal"><%=request.getAttribute("firstname")%></p> <br>
                        <p class="font-weight-bold">Lastname</p>
                        <p class="font-weight-normal"><%=request.getAttribute("firstname")%></p> <br>
                        <p class="font-weight-bold">Student ID</p>
                        <p class="font-weight-normal"><%=request.getAttribute("studentID")%></p> <br>
                        <p class="font-weight-bold">Room</p>
                        <p class="font-weight-normal"><%=request.getAttribute("room")%></p> <br>
                        <p class="font-weight-bold">Start Time</p>
                        <p class="font-weight-normal"><%=request.getAttribute("start")%></p> <br>
                        <p class="font-weight-bold">End Time</p>
                        <p class="font-weight-normal"><%=request.getAttribute("end")%></p> <br>
                    </div>
                </div>
            </div>
        </div>
        <div id="something">
            <div id="something2"></div>
            <a class="btn btn-primary" href="<%=request.getContextPath() + "/index.jsp"%>" role="button">Home</a>
        </div>
    </div>
</body>
<style>
    body{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    #success{
        width: 50vw;
    }

    #something{
        margin-top: 1rem;
        display: flex;
        align-items: flex-end;
    }

    #something2{
        width: 90%;
    }



</style>
</html>
