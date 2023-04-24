<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
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
        <h2>Przed usunięciem tego nauczyciela należy zadbać, aby nie był on wychowawcą żadnej klasy</h2>
        <br>
        <a href="/teacher/all" class="goBackA"><button class="goBack">Powrót</button></a>
    </div>
</body>
</html>
