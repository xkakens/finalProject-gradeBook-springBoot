<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.04.2023
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<title>Lista uczniów</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="javascript:history.back()">
        <button class="goBack"><<<</button>
    </a>
    <h1>Lista uczniów</h1>
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
                <td><a href="/student/${student.id}">Więcej</a>
                    <sec:authorize access="hasAnyAuthority('ADMIN', 'teacher')">
                    <a href="/mark/add/${student.id}">Dodaj ocenę</a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>