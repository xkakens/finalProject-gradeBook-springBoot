<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 17/04/2023
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>Dane ucznia</title>
</head>
<body>
<div class="container">
    <a href="/class/studentlist/${student.schoolClass.id}">
        <button class="goBack"><<<</button>
    </a><br>
    <h1>${student.firstName} ${student.lastName}</h1>
    <h3>Klasa: ${schoolClass.name}</h3>
    <a href="/student/update/${student.id}">
        <button class="goBack">Edycja danych ucznia</button>
    </a>
</div>
</body>
</html>
