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
    <title>Title</title>
</head>
<body>
<a href="/class/studentlist/${student.schoolClass.id}"><-- Powrót</a><br>
Imie: ${student.firstName}
<br>
Nazwisko: ${student.lastName}
<br>
Klasa: ${classId}
<br>
<a href="/student/update/${student.id}">Edycja ucznia</a>
</body>
</html>
