<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.04.2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dodawanie nauczyciela</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/teacher/all">
        <button class="goBack"><<<</button>
    </a>
    <h1>Dodawanie nauczyciela</h1>
    <br>
    <form action="/teacher/add" method="post">
        Imię<br>
        <input type="text" name="firstName"/>
        <br><br>
        Nazwisko<br>
        <input type="text" name="lastName"/>
        <input type="submit" value="Zapisz"/>
    </form>
</div>
</body>
</html>
