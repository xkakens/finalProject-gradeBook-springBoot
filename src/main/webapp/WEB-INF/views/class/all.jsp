<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.04.2023
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

    <title>Lista klas</title>
</head>
<body>
<div class="container">
    <a class="goBackA" href="/mainPage">
        <button class="goBack"><<<</button>
    </a>
    <a href="/class/add">
        <button class="goBack">Dodaj klasę</button>
    </a>
    <h1>Lista klas</h1>
    <div class="table-responsive">
        <table>
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nazwa</th>
                <th scope="col">Wychowawca</th>
                <th scope="col">Rozszerzane przedmioty</th>
                <th scope="col">Akcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="schoolClass" items="${classes}" varStatus="loop">
                <tr>
                    <td>${schoolClass.id}</td>
                    <td>${schoolClass.name}</td>
                    <td>${schoolClass.tutor.firstName} ${schoolClass.tutor.lastName} (${schoolClass.tutor.id})</td>
                    <td>${ext[loop.index]}</td>
                    <td><a href="/class/update/${schoolClass.id}">Zarządzaj</a><a href="/class/studentlist/${schoolClass.id}">Pokaż
                        listę uczniów</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>