<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 16:08
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>Lista przedmiotów nauczyciela ${teacher.firstName} ${teacher.lastName}</title>
</head>
<body>

    <div class="container">
        <a class="goBackA" href="/teacher/all"><button class="goBack"><<<</button></a>
        <h1>Lista przedmiotów nauczyciela ${teacher.firstName} ${teacher.lastName}</h1>
        <p style="color: red; text-decoration: underline;">Odsunąć nauczyciela od nauczania przedmiotu można jedynie poprzez edycję przedmiotu</p>
  <c:forEach var="subject" items="${subjects}">
    ${subject.name}<br>
  </c:forEach>
    </div>
</body>
</html>
