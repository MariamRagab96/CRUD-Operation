<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #404E67;
                background: #F5F7FA;
                font-family: 'Open Sans', sans-serif;
            }
            form{
                margin: auto;
            }
            .invalid{
                color: red;
                font-size: medium;
                align-content: center
            }
        </style>
    </head>
    <body>
        <br><br><br>
        <form class="col-md-6" method="post" action="login">
            <!-- Email input -->
            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example1">Username</label>
                <input type="text" id="form1Example1" class="form-control" name="username"/>

            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example2">Password</label>
                <input type="password" id="form1Example2" class="form-control" name="password"/>

            </div>


            <!-- Submit button -->
            <button type="submit" class="col-md-3 btn btn-primary btn-block">Sign in</button>
            <br>
            <a class ="link"href="InsertUser.jsp" > Sign up</a>

            <c:if test="${!empty requestScope.msg}">
                <p class="invalid">
                    <br>
                    <c:out value=" ${requestScope.msg}"></c:out>
                    </p>
            </c:if>

        </form>  
    </body>
</html>
