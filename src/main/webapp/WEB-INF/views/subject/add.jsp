<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.04.2023
  Time: 17:36
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/script.js" defer></script>
    <title>Tworzenie przedmiotu</title>
</head>
<body>
<div class="container">
    <a class="goBackA" href="/subject/all">
        <button class="goBack"><<<</button>
    </a>
    <h1>Tworzenie przedmiotu</h1>
    <form action="/subject/add" method="post">
        Nazwa<br>
        <input type="text" name="name"/>
        <br><br>
        <h2>Nauczyciele</h2><br>
        <button type="button" class="goBack" onclick="addTeacher()">+</button>
        <button type="button" class="goBack" onclick="removeTeacher()">-</button>
        <input type="hidden" id="hiddenNumber" value="2">
        <div id="teacherList">
            <div>
                <p style="font-size: 20px; font-weight: 900;" name="p2">1. nauczyciel</p>
                <select size="3" name="teacher1" required>
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher.id}"> ${teacher.id}: ${teacher.firstName} ${teacher.lastName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <input type="submit" value="Dodaj"/>
    </form>
</div>

</body>
</html>
