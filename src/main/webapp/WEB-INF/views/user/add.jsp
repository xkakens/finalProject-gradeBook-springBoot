<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.04.2023
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dodawanie użytkownika</title>
</head>
<body>
<div class="container">
  ${notification}
  <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a href="javascript:history.back()"><button class="goBack"><<<</button></a>
    <br> <br>
  <form action="/user/add" method="post">
    Nazwa użytkownika:
    <br>
    <input type="text" name="username">
    <br>
    Hasło:
    <br>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Dodaj">
  </form>
</div>
</body>
</html>
