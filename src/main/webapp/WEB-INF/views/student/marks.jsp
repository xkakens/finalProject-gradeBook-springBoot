<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 21/04/2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  <title> Lista ocen </title>
</head>
<body>
<div class="container">
  <a href="/student/${student.id}" class="goBackA"><button class="goBack"><<<</button></a>
<h1 class="header">Oceny ucznia ${student.firstName} ${student.lastName}</h1>
  <a href="/mark/add/${student.id}"><button class="goBack">Dodaj ocenę</button></a>
  <br><br><br>
<table>
  <thead>
  <tr>
    <th> Ocena </th>
    <th> Opis </th>
    <th> Przedmiot</th>
    <th> Waga</th>
    <th> Akcje </th>
  </tr>
  </thead>
  <tbody>
  <c:forEach varStatus="loop" var="mark" items="${marks}">
    <tr>
      <td>${mark.value}</td>
      <td><div class="tooltip">Opis
        <span class="tooltiptext">${mark.description}</span>
      </div></td>
      <td>${mark.subject.name}</td>
      <td>${mark.importance}</td>
      <td><a href="/mark/update/${mark.id}">Zmień</a>&nbsp;&nbsp;&nbsp;<a href="/mark/delete/${mark.id}">Usuń</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
</body>
</html>
