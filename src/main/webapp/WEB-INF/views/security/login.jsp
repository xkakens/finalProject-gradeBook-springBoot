<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.04.2023
  Time: 19:19
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Logowanie</title>
</head>
<body>
<div class="container">
    <h1>Logowanie</h1>
    <form method="post">
        <div><label> Nazwa użytkownika: <input type="text" name="username"/> </label></div>
        <br><br>
        <div><label> Hasło:<br> <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Zaloguj się"/></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
