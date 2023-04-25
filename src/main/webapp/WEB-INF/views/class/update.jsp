<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 23/04/2023
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title> Zarządzanie klasą </title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
  <a class="goBackA" href="/class/all"><button class="goBack"><<<</button></a><br>
  <br>
  <a class="goBackA" href="/class/delete/${schoolClass.id}"><button class="goBack">Usuń klasę</button></a>
  <h2>Edycja danych klasy</h2>
  <form action="/class/update/${schoolClass.id}" method="post">
    <input type="text" name="name" value="${schoolClass.name}">
    <select size="10" name="tutorId">
      <c:forEach var="teacher" items="${teachers}">
        <option <c:if test="${schoolClass.tutor.id == teacher.id}">selected </c:if>value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
      </c:forEach>
    </select>
    <br> <br>
    <fieldset>
      <legend>Wybierz przedmioty</legend>
      <c:forEach varStatus="loop" var="subject" items="${subjects}">
        <div>
          <input <c:forEach var="extT" items="${ext}"><c:if test="${extT.name==subject.name}">checked</c:if></c:forEach> type="checkbox" name="subjectName${loop.index}" value="${subject.name}">
          <label for="${subject.name}"> ${subject.name}</label>
        </div>
      </c:forEach>
    </fieldset>
    <input type="submit">
  </form>
</div>
</body>
</html>
