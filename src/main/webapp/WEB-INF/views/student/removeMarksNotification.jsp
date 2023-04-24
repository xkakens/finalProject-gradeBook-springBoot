<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 20:05
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Powiadomienie</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Przed usunięciem tego ucznia należy zadbać o to, aby nie było przypisanych do niego żadnych ocen</h2>
    <br>
    <a href="/student/${student.id}" class="goBackA"><button class="goBack">Powrót</button></a>
</div>
</body>
</html>