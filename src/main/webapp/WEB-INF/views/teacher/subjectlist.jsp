<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 16:08
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Lista przedmiotów nauczyciela ${teacher.firstName} ${teacher.lastName}</title>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/teacher/all">
        <button class="goBack"><<<</button>
    </a>
    <h1>Lista przedmiotów nauczyciela ${teacher.firstName} ${teacher.lastName}</h1>
    <p style="color: red; text-decoration: underline;">Przypisanie nauczyciela do przedmiotu można zmienić poprzez modyfikację przedmiotu</p>
    <c:forEach var="subject" items="${subjects}">
        ${subject.name}<br>
    </c:forEach>
</div>
</body>
</html>
