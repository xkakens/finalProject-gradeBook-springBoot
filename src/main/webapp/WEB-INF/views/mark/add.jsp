<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 21/04/2023
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dodaj ocenę</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a href="/class/studentlist/${sessionScope.classId}" class="goBackA">
        <button class="goBack"><<<</button>
    </a>
    <h1> Dodaj nową ocenę </h1>
    <br>
    <form action="/mark/add" method="post">
        <br> Ocena <br>
        <input type="number" name="value">
        <br>
        <br> Waga <br>
        <input type="number" name="importance">
        <br>
        <br> Opis <br>
        <input type="text" name="description">
        <br>
        <br><br>
        <select name="subjectName">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.id}">${subject.name}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="Dodaj">

    </form>

</div>
</body>
</html>
