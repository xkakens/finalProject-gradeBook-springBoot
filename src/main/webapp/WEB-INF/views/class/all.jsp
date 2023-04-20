<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2023
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>userHome</title>
</head>
<body>
<a href="/class/add">Dodaj klasę</a>
<c:forEach var="schoolClass" items="${classes}">
  <h1>${schoolClass.name}</h1>
  <a href="/class/studentlist/${schoolClass.id}"> Uczniowie </a>
</c:forEach>
</body>
</html>