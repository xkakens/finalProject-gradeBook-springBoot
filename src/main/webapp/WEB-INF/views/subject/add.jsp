<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.04.2023
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  <script src="${pageContext.request.contextPath}/js/script.js" defer></script>
  <title>Dodawanie przedmiotu</title>
</head>
<body>
<div class="container">
  <form action="/subject/add" method="post">
    Nazwa<br>
    <input type="text" name="name"/>
    <div id="teacherList">
      <select size="3" name="teacher1">
        <c:forEach var="teacher" items="${teachers}">
          <option value="${teacher.id}"> ${teacher.id}: ${teacher.firstName} ${teacher.lastName}</option>
        </c:forEach>
      </select><br>
    </div>
    <button type="button" onclick="addTeacher()" id="addTeacherButton">Dodaj nauczyciela</button>
    <input type="submit" value="Dodaj"/>
  </form>
</div>

</body>
</html>
