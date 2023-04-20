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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

    <title class="header">Klasy</title>
</head>
<body>
<a href="/class/add">Dodaj klasę</a>


<div class="card-header d-flex justify-content-between">
    <div class="header-title">
        <h2 class="card-title">Lista klas</h2>
    </div>
</div>
<div class="table-responsive">
<table id="class-list-table" class="table table-striped table-bordered mt-4 " role="grid" aria-describedby="class-list-page-info">
    <thead>
    <tr>
        <th scope="col">Nazwa</th>
        <th scope="col">ID</th>
        <th scope="col">Imię wychowawcy</th>
        <th scope="col">Nazwisko wychowawcy</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="schoolClass" items="${classes}">
            <tr>
                <td>${schoolClass.name}</td>
                <td>${schoolClass.id}</td>
                <td>${schoolClass.tutor.firstName}</td>
                <td>${schoolClass.tutor.lastName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>