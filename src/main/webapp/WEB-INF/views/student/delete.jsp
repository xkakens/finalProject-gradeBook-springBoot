<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 20:07
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie ucznia</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <h1 style="color: red;">USUWASZ UCZNIA <span style="color: black;">${student.firstName} ${student.lastName} (id: ${student.id})</span></h1>
    <h3>Rodzice:</h3>
    Rodzic 1:
    <br>
    ${student.firstParent.firstName} ${student.firstParent.lastName}
    <br>
    Numer telefonu: ${student.firstParent.phoneNumber}
    <br>
    Rodzic 2:
    <br>
    ${student.secondParent.firstName} ${student.secondParent.lastName}
    <br>
    Numer telefonu: ${student.secondParent.phoneNumber}
    <br>
    Czy na pewno chcesz to zrobić?
    <br><br>
    <form action="/student/delete/${student.id}" method="post">
        <a href="/student/${student.id}" class="goBackA"><button type="button" class="deleteNo">NIE</button></a>
        <button style="margin-left: 15px;" class="deleteYes">TAK</button>
    </form>
</div>
</body>
</html>