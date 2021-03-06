<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/1/20
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new customer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/src/css/bootstrap.css">
    <script src="/src/js/jquery.js"></script>
    <script src="/src/js/bootstrap.js"></script>
    <style>
        .decoration{
            margin-top: 20px;
        }

        form{
            position: relative;
            width: 500px;
            height: 600px;
            background: #f2f2f2;
            border: 1px solid #cccccc;
            padding: 10px 10px;
        }
        button{
            position: relative;
            margin: 0 auto;
            width: 120px;
            height: 35px;
            left: 180px;
        }
    </style>
</head>
<body>
<div class="container">
    <p style="color: #00aced; font-size: 30px">
        ${message}
    </p>
    <p>
        <a href="student">Back to student list</a>
    </p>

    <div class="decoration">
        <h3>Input information of student</h3>
        <div class="row">
            <form method="post">
                <div class="form-group">
                    <label>Id</label>
                    <input class="form-control" type="text" name="Id" id="Id">
                </div>
                <div class="form-group">
                    <label>Full Name</label>
                    <input class="form-control" type="text" name="name" id="name">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" type="text" name="email" id="email">
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input class="form-control" type="text" name="address" id="address">
                </div>
                <div class="form-group">
                    <label>Date of birth</label>
                    <input class="form-control" type="text" name="dateOfBirth" id="dateOfBirth">
                </div>
                <div class="form-group">
                    <label>Image</label>
                    <input class="form-control" type="text" name="img" id="img">
                </div>
                <input class="btn btn-success" type="submit" value="Create" >
            </form>
        </div>
    </div>
</div>
</body>
</html>
