<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 23/04/2023
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Zmiana oceny </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <a class="goBackA" href="/student/marks/{student.id}"><button class="goBack">Anuluj</button></a><br>
        <form action="/mark/update/${id}" method="post">
            <input type="number" name="value" value="${mark.value}">
            <input type="number" name="importance" value="${mark.importance}">
            <input type="text" name="description" value="${mark.description}">
            <input type="submit" value="Potwierdź">
        </form>
    </div>
</body>
</html>
