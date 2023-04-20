<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.04.2023
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Title</title>
</head>
<body>
<a href="/class/all"><--- Powrót</a>
<br>
<c:forEach var="teacher" items="${teachers}">
    <h1>${teacher.id}: ${teacher.firstName} ${teacher.lastName}</h1>
    <br>
</c:forEach>
    <form action="/class/add" method="post">
        <input type="text" name="name" placeholder="nazwa">Nazwa<br>
        <input type="number" name="tutorId">ID tutora<br>
        <input type="submit">
    </form>
</body>
</html>
