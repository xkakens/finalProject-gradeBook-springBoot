<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.04.2023
  Time: 17:27
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Lista przedmiotów</title>
</head>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/views/utils/bodyHeader.jsp" />
    <a class="goBackA" href="javascript:history.back()">
        <button class="goBack"><<<</button>
    </a>
    <a href="/subject/add">
        <button class="goBack">Dodaj przedmiot</button>
    </a>
    <h1>Lista przedmiotów</h1>
    <div class="table-responsive">
        <table>
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nazwa</th>
                <th scope="col">Akcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="subject" items="${subjects}">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                    <td><a href="/subject/update/${subject.id}">Zarządzaj</a><a href="/subject/delete/${subject.id}">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
