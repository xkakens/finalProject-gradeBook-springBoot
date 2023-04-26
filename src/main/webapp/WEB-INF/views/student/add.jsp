<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dodawanie ucznia</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/class/studentlist/${classId}">
        <button class="goBack"><<<</button>
    </a><br>
    <h1>Dodawanie studenta</h1>
    <form action="/student/add" method="post">
        <input type="text" placeholder="Imię" name="firstName"/><br>
        <input type="text" placeholder="Nazwisko" name="lastName"><br>
        <br>
        <h2>Rodzic 1</h2>
        <input type="number" value="0" name="parentOnePhoneNumber"/><br>
        <input type="text" name="parentOneFirstName"><br>
        <input type="text" name="parentOneLastName"><br>
        <br>
        <h2>Rodzic 2</h2>
        <input type="number" value="0" name="parentTwoPhoneNumber"/><br>
        <input type="text" name="parentTwoFirstName"><br>
        <input type="text" name="parentTwoLastName"><br>
        <input type="date" name="dateOfBirth"><br>
        <input type="submit" value="Zapisz">
    </form>
</div>
</body>
</html>
