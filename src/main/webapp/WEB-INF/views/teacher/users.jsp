<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 26/04/2023
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ustaw użytkownika</title>
</head>
<body>
<div class="container">
    ${notification}
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a href="/teacher/all" clas="goBackA">
        <button class="goBack"><<<</button>
    </a>
    <h2>Nauczyciel: ${teacher.firstName} ${teacher.lastName}</h2>
        <h2>Użytkownik: ${teacher.user.username}</h2> <a href="/teacher/${teacher.id}/set-user"> Przypisz użytkownika </a>
</div>
</body>
</html>
