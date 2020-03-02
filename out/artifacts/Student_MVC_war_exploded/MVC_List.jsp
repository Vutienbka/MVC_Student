<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/1/20
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student satisfy a condition</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/src/css/bootstrap.css">
    <script src="/src/js/jquery.js"></script>
    <script src="/src/js/bootstrap.js"></script>
    <style>
        tr{
            text-align: center;
        }
        .container{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>student List</h2>
    <p><a href="${pageContext.request.contextPath}?action=create">Create New Student</a></p>
<%--    <p><a href="student?action=create">Create New Student</a></p>--%>
    <table class="table table-striped table-bordered">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td> <c:out value="${student.getName()}"></c:out></td>
                <td> <c:out value="${student.getEmail()}"></c:out></td>
                <td><c:out value="${student.getAddress()}"></c:out></td>
                <td><a href="${pageContext.request.contextPath}?action=view&Id=${student.getId()}">View</a></td>
                <td><a href="${pageContext.request.contextPath}?action=edit&Id=${student.getId()}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}?action=delete&Id=${student.getId()}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
