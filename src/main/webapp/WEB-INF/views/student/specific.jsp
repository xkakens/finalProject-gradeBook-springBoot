<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 17/04/2023
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dane ucznia</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/class/studentlist/${student.schoolClass.id}">
        <button class="goBack"><<<</button>
    </a>
    <br>
    <a class="goBackA" href="/student/users/${student.id}">
        <button class="goBack">Użytkownicy</button>
    </a><br>
    <h1>${student.firstName} ${student.lastName}</h1>
    <h3>Klasa: ${schoolClass.name}</h3>
    <h3> Dane rodzica 1: </h3>
    <h4> ${student.firstParent.firstName} ${student.firstParent.lastName}<br>Numer
        telefonu: ${student.firstParent.phoneNumber}</h4>
    <h3> Dane rodzica 2: </h3>
    <h4> ${student.secondParent.firstName} ${student.secondParent.lastName}<br>Numer
        telefonu: ${student.secondParent.phoneNumber}</h4>
    <a class="goBackA" href="marks/${student.id}">
        <button class="goBack"> Lista ocen</button>
    </a>
    <a href="/student/update/${student.id}">
        <button class="goBack">Edycja danych ucznia</button>
    </a>
    <br><br>
    <a href="/student/delete/${student.id}" class="goBackA">
        <button class="goBack">Usuń ucznia</button>
    </a>
</div>
</body>
</html>
