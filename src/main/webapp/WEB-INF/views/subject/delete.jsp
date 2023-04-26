<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.04.2023
  Time: 16:24
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Usuwanie przedmiotu</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <h1 style="color: red;">USUWASZ PRZEDMIOT <span style="color: black;">${subject.name} (id: ${subject.id})</span>
    </h1>
    Czy na pewno chcesz to zrobić? <span style="color: red;">Wszystkie oceny powiązane z tym przedmiotem zostaną usunięte!</span>
    <br><br>
    <form action="/subject/delete/${subject.id}" method="post">
        <a href="javascript:history.back()" class="goBackA">
            <button type="button" class="deleteNo">NIE</button>
        </a>
        <button style="margin-left: 15px;" class="deleteYes">TAK</button>
    </form>
</div>
</body>
</html>
