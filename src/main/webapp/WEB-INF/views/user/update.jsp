<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.04.2023
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title> Zmiana ról użytkownika </title>
</head>
<body>
<div class="container">
  <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
  <a class="goBackA" href="javascript:history.back()">
    <button class="goBack"><<<</button>
  </a>
  <h2>Zmieniasz role użytkownika <span style="color:red;">${user.username}</span></h2>
  <form action="/user/update/${user.id}" method="post">
      <c:forEach varStatus="loop" var="role" items="${roles}">
        <div>
          <input
          <c:forEach var="extT" items="${ext}">
                  <c:if test="${extT.id==role.id}">checked</c:if>
          </c:forEach> type="checkbox" id="roleName${loop.index}" name="roleName${loop.index}" value="${role.name}">
          <label for="roleName${loop.index}"> ${role.name}</label>
        </div>
      </c:forEach>
    <input type="submit" value="Zapisz">
  </form>
</div>
</body>
</html>