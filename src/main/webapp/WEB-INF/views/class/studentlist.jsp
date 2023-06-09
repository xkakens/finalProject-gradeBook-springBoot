<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.04.2023
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Lista uczniów</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/class/all">
        <button class="goBack"><<<</button>
    </a>
    <a href="/student/add">
        <button class="goBack">Dodaj ucznia</button>
    </a>
    <h1>Lista uczniów klasy ${schoolClass.name}</h1>
    <table>
        <thead>
        <th>ID</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Akcje</th>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td><a href="/student/${student.id}">Więcej</a><a href="/mark/add/${student.id}">Dodaj ocenę</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>