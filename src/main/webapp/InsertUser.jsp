<%-- 
    Document   : InsertUser
    Created on : Jul 25, 2021, 11:32:47 PM
    Author     : Mariam Ragab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>Add User</title>
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
        <br>
        <br>
        <form method ="post" action ="register" class="col-md-6" style="margin: auto;">
            <div class="col-md-6">
                <label for="inputUsername4" class="form-label">Username</label>
                <input type="text" class="form-control" id="inputUsername4" name="username">
            </div>

            <div class="col-md-6">
                <label for="inputPassword4" class="form-label">Password</label>
                <input type="password" class="form-control" id="inputPassword4" name ="password">
            </div>
            <br>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign up </button>
            </div>

            <c:if test="${!empty requestScope.msg}">
                <p class="invalid">
                    <br>
                <c:out value=" ${requestScope.msg}"></c:out>
                </p>
            </c:if>
        </form>
    </body>
</html>
