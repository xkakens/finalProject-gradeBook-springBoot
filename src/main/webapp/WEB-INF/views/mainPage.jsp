<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.04.2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>
    <div class="container">
        <a href="/class/all"><button class="goBack">Lista klas</button></a>
        <a href="/teacher/all"><button class="goBack">Lista nauczycieli</button></a>
    </div>
</body>
</html>
