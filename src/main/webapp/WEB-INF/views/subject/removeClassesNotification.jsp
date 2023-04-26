<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.04.2023
  Time: 16:34
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Powiadomienie</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <h2>Przed usunięciem tego przedmiotu należy zadbać, aby żadna klasa się go nie uczyła</h2>
    <br>
    <a href="/subject/all" class="goBackA">
        <button class="goBack">Powrót</button>
    </a>
</div>
</body>
</html>
