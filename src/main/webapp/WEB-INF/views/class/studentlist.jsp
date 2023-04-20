<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.04.2023
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/class/all"><-- Powrót</a><br>
<a href="/student/add">Dodaj ucznia</a>
<c:forEach var="student" items="${students}">
    <h1>${student.firstName} ${student.lastName}</h1>
    <br>
    <a href="/student/${student.id}">Więcej</a>
</c:forEach>
</body>
</html>