<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie nauczyciela</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1 style="color: red;">USUWASZ NAUCZYCIELA <span style="color: black;">${teacher.firstName} ${teacher.lastName} id: ${teacher.id}</span></h1>
        Czy na pewno chcesz to zrobić?
        <br><br>
        <form action="/teacher/delete/${teacher.id}" method="post">
            <a href="/teacher/all" class="goBackA"><button type="button" class="deleteNo">NIE</button></a>
            <button style="margin-left: 15px;" class="deleteYes">TAK</button>
        </form>
    </div>
</body>
</html>
