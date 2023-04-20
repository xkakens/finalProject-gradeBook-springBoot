<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.04.2023
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student/${student.id}"><-- Powrót</a><br>
    <h1>Zmiana danych ucznia</h1>
    <c:forEach var="schoolClass" items="${classes}">
        ${schoolClass.id}: ${schoolClass.name}
        <br>
    </c:forEach>
    <!-- michał podstawy formularza -->
    <form action="/student/update/${student.id}" method="post">
        <input type="text" name="firstName" value="${student.firstName}">
        <br>
        <input type="text" name="lastName" value="${student.lastName}">
        <br>
        <input type="date" name="dateOfBirth" value="${student.dateOfBirth}">
        <br>
        <input type="number" name="classId" value="${student.schoolClass.id}">
        <br>
        <input type="submit" value="Zapisz">
    </form>
</body>
</html>
