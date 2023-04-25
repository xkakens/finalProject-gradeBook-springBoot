<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.04.2023
  Time: 16:24
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Usuwanie przedmiotu</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
  <h1 style="color: red;">USUWASZ PRZEDMIOT <span style="color: black;">${subject.name} (id: ${subject.id})</span></h1>
  Czy na pewno chcesz to zrobić? <span style="color: red;">Wszystkie oceny powiązane z tym przedmiotem zostaną usunięte!</span>
  <br><br>
  <form action="/subject/delete/${subject.id}" method="post">
    <a href="/subject/all" class="goBackA"><button type="button" class="deleteNo">NIE</button></a>
    <button style="margin-left: 15px;" class="deleteYes">TAK</button>
  </form>
</div>
</body>
</html>
