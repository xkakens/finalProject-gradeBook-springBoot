<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 19:48
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Usuwanie klasy</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
  <h1 style="color: red;">USUWASZ KLASĘ <span style="color: black;">${schoolClass.name} (id: ${schoolClass.id})</span></h1>
  Czy na pewno chcesz to zrobić?
  <br><br>
  <form action="/class/delete/${schoolClass.id}" method="post">
    <a href="/class/update/${schoolClass.id}" class="goBackA"><button type="button" class="deleteNo">NIE</button></a>
    <button style="margin-left: 15px;" class="deleteYes">TAK</button>
  </form>
</div>
</body>
</html>
