<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Powiadomienie</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <h2>Przed usunięciem tego nauczyciela należy zadbać, aby nie był on wychowawcą żadnej klasy</h2>
    <br>
    <a href="/teacher/all" class="goBackA">
        <button class="goBack">Powrót</button>
    </a>
</div>
</body>
</html>
