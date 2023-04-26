<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 26/04/2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>Ustaw użytkownika</title>
</head>
<body>
<a href="javascript:history.back()" class="goBackA">
    <button class="goBack"><<<</button>
</a>
<form action="/teacher/${teacher.id}/set-user" method="post">
    <input type="text" name="username" placeholder="Wyszukaj użytkownika...">
    <input type="submit" value="Potwierdź">
</form>
</body>
</html>
