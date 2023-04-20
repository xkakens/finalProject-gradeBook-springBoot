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
<div class="container">
<a href="/class/all"><button class="goBack"><<<</button></a>
<br><br>
<%--    <b>Nauczyciele:</b>--%>
<%--<ul>--%>
<%--<c:forEach var="teacher" items="${teachers}">--%>
<%--    <li class="header">${teacher.id}: ${teacher.firstName} ${teacher.lastName}</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<div class="header-title">
</div>
    <form action="/class/add" method="post">
        <br>Nazwa klasy</br>
        <input type="text" name="name" id="name"><br>
<%--        <br>ID tutora<br>--%>
<%--        <input type="number" name="tutorId">--%>
        <select size="10">
            <c:forEach var="teacher" items="${teachers}">
                <option> ${teacher.id}: ${teacher.firstName} ${teacher.lastName}</option>
            </c:forEach>
        </select>
        <input type="submit">
    </form>
</div>
</body>
</html>
