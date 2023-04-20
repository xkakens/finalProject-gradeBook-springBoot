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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>Title</title>
</head>
<body>
<a href="/class/all"><--- Powrót</a>
<br>
<<<<<<< HEAD
<c:forEach var="teacher" items="${teachers}">
    <h1 class="header">${teacher.id}: ${teacher.firstName} ${teacher.lastName}</h1>
    <br>
</c:forEach>
=======
<%--<c:forEach var="teacher" items="${teachers}">--%>
<%--    <h1>${teacher.id}: ${teacher.firstName} ${teacher.lastName}</h1>--%>
<%--    <br>--%>
<%--</c:forEach>--%>
<div class="header-title">
    <h2 class="card-title">
        Dodaj nowego nauczyciela</h2>
</div>
>>>>>>> ca994eb4b4439471071bb78566ef384bfdcd84e2
    <form action="/class/add" method="post">
        <input class="form-control" type="text" name="name" placeholder="nazwa" id="name"><br>
        <input type="number" name="tutorId">ID tutora<br>
        <input type="submit">
    </form>
</body>
</html>
