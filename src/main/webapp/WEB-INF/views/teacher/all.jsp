<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2023
  Time: 13:51
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Lista nauczycieli</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/mainPage">
        <button class="goBack"><<<</button>
    </a>
    <a href="/teacher/add">
        <button class="goBack">Dodaj nauczyciela</button>
    </a>
    <h1>Lista nauczycieli</h1>
    <div class="table-responsive">
        <table>
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Imię i nazwisko</th>
                <th scope="col">Akcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.firstName} ${teacher.lastName}</td>
                    <td><a href="/teacher/subjectlist/${teacher.id}">Przedmioty</a><a
                            href="/teacher/delete/${teacher.id}">Usuń</a>
                        <a href="/teacher/${teacher.id}/users" > Użytkownik </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>