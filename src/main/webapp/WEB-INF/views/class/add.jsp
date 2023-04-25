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
    <title>Dodawanie klasy</title>
</head>
<body>
<div class="container">
    <a class="goBackA" href="/class/all">
        <button class="goBack"><<<</button>
    </a>
    <br><br>
    <div class="header-title">
    </div>
    <form action="/class/add" method="post">
        <br>Nazwa klasy</br>
        <input type="text" name="name" id="name"><br>
        <select size="10" name="tutorId">
            <c:forEach var="teacher" items="${teachers}">
                <option value="${teacher.id}"> ${teacher.id}: ${teacher.firstName} ${teacher.lastName}</option>
            </c:forEach>
        </select>
        <br> <br>
        <fieldset>
            <legend>Wybierz przedmioty</legend>
            <c:forEach varStatus="loop" var="subject" items="${subjects}">
                <div>
                    <input type="checkbox" name="subjectName${loop.index}" value="${subject.name}">
                    <label for="${subject.name}"> ${subject.name}</label>
                </div>
            </c:forEach>
        </fieldset>
        <input type="submit" value="Dodaj">
    </form>
</div>
</body>
</html>
