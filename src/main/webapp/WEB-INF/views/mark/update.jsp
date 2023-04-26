<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 23/04/2023
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title> Zmiana oceny </title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a class="goBackA" href="/student/marks/{student.id}">
        <button class="goBack">Anuluj</button>
    </a><br>
    <form action="/mark/update/${id}" method="post">
        <input type="number" name="value" value="${mark.value}">
        <input type="number" name="importance" value="${mark.importance}">
        <input type="text" name="description" value="${mark.description}">
        <input type="submit" value="Potwierdź">
    </form>
</div>
</body>
</html>
