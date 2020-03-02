<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/1/20
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/src/css/bootstrap.css">
    <script src="/src/js/jquery.js"></script>
    <script src="/src/js/bootstrap.js"></script>
    <style>
        .decoration{
            margin-top: 20px;
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
        <h3>Student Information</h3>
        <div class="row">
            <form method="post">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Date Of Birth</th>
                        <th>Image</th>
                    </tr>
                    <tr>
                        <td>${student.getId()}</td>
                        <td>${student.getName()}</td>
                        <td>${student.getEmail()}</td>
                        <td>${student.getAddress()}</td>
                        <td>${student.getDateOfBirth()}</td>
                        <td><img src="${student.getImage()}" alt="Image Not Found"
                                 style="width: 50px; height: 50px; border: 1px solid #cccccc"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>