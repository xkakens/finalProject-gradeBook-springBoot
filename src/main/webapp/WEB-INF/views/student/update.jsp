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
    <title>Zmiana danych ucznia</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
<a class="goBackA" href="/student/${student.id}"><button class="goBack"><<<</button></a><br>
    <h1>Zmiana danych ucznia</h1>
    <h3>${student.firstName} ${student.lastName}</h3>
    <br>
    <!-- michał podstawy formularza -->
    <form action="/student/update/${student.id}" method="post">
        <input type="text" name="firstName" value="${student.firstName}">
        <br>
        <input type="text" name="lastName" value="${student.lastName}">
        <br>
        <input type="date" name="dateOfBirth" value="${student.dateOfBirth}">
        <br>
        <select size="10" name="classId">
            <c:forEach var="schoolClass" items="${classes}">
                <option value="${schoolClass.id}"> ${schoolClass.id}: ${schoolClass.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Zapisz">
    </form>
</div>
</body>
</html>
