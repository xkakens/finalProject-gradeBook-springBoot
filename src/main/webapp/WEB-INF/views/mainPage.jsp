<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.04.2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/views/utils/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/student/all">
        <button class="goBack">Lista uczniów</button>
    </a>
    <sec:authorize access="hasAnyAuthority('ADMIN','teacher')">
        <a class="goBackA" href="/class/all">
            <button class="goBack">Lista klas</button>
        </a>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ADMIN')">
        <a class="goBackA" href="/teacher/all">
            <button class="goBack">Lista nauczycieli</button>
        </a>
        <a class="goBackA" href="/subject/all">
            <button class="goBack">Lista przedmiotów</button>
        </a><br><br>
        <a class="goBackA" href="/user/all">
            <button class="goBack">Lista użytkowników</button>
        </a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h2>Zalogowany jako: <sec:authentication property="principal.username"/></h2>
    </sec:authorize>
</div>
</body>
</html>
