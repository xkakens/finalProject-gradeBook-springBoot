<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2023
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Usuwanie oceny</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
  <h1 style="color: red;">USUWASZ OCENĘ <span style="color: black;">${mark.value} o wadze ${mark.importance} (id: ${mark.id})</span></h1>
  <br>
  Opis oceny:<br>
  ${mark.description}
  <br>Przedmiot: ${mark.subject.name}
  <br>Uczeń: ${mark.student.firstName} ${mark.student.lastName} (id: ${mark.student.id}) z klasy ${mark.student.schoolClass.name}
  <br>
  Czy na pewno chcesz to zrobić?
  <br><br>
  <form action="/mark/delete/${mark.id}" method="post">
    <a href="/student/marks/${mark.student.id}" class="goBackA"><button type="button" class="deleteNo">NIE</button></a>
    <button style="margin-left: 15px;" class="deleteYes">TAK</button>
  </form>
</div>
</body>
</html>

