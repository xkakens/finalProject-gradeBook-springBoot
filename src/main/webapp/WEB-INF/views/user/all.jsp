<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.04.2023
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Lista uczniów</title>
</head>
<body>
<div class="container">
  <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
  <a class="goBackA" href="javascript:history.back()">
    <button class="goBack"><<<</button>
  </a>
  <a class="goBackA" href="/user/add">
    <button class="goBack">Dodaj użytkownika</button>
  </a>
  <br><br><br>
  <table>
    <thead>
    <th>Nazwa użytkownika</th>
    <th>Akcje</th>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.username}</td>
      <td><a href="/user/update/${user.id}">Zmień role</a></td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>