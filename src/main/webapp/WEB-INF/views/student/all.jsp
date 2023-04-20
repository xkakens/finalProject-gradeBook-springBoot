<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 17/04/2023
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="student" items="${students}">
    <h1>${student.firstName} ${student.lastName}</h1>
    ${student.schoolClass.id}
    <br>
    <a href="/student/${student.id}">Więcej</a>
</c:forEach>
</body>
</html>
