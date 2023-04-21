<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.04.2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>Title</title>
</head>
<body>
<div class="container">
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
