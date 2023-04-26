<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.04.2023
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Użytkownicy</title>
</head>
<body>
    <div class="container">
        ${notification}
            <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
        <a href="/student/${student.id}" clas="goBackA">
            <button class="goBack"><<<</button>
        </a>
        <h2>Lista użytkowników mających dostęp do ucznia ${student.firstName} ${student.lastName}:</h2>
        <c:forEach var="user" items="${users}">
            ${user.username}<form action="/user/removestudent/${student.id}/${user.id}" method="post"><input type="submit" value="Usuń"></form><br>
        </c:forEach>
        <form action="/user/addstudent/${student.id}" method="post">
        Dodaj<input type="text" name="username"><input type="submit" value="Dodaj">
        </form>
    </div>
</body>
</html>
