<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.04.2023
  Time: 20:23
  To change this template use File | Settings | File Templates.
  bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<script src="${pageContext.request.contextPath}/js/script.js" defer></script>
<title>Zmiana danych przedmiotu</title>
</head>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/views/utils/bodyHeader.jsp" />
    <a class="goBackA" href="javascript:history.back()">
        <button class="goBack"><<<</button>
    </a>
    <h1>Zmiana danych przedmiotu</h1>
    <form action="/subject/update/${subject.id}" method="post">
        Nazwa<br>
        <input type="text" name="name" value="${subject.name}"/>
        <br><br>
        <h2>Nauczyciele</h2><br>
        <button type="button" class="goBack" onclick="addTeacher()">+</button>
        <button type="button" class="goBack" onclick="removeTeacher()">-</button>
        <input type="hidden" id="hiddenNumber" value="${length+1}">
        <div id="teacherList">
            <c:forEach var="teacher" items="${subject.teachers}" varStatus="loop">
                <div id="div${loop.index+1}">
                    <p style="font-size: 20px; font-weight: 900;" name="p2">${loop.index+1}. nauczyciel</p>
                    <select size="3" name="teacher${loop.index+1}" required>
                        <c:forEach var="teacher2" items="${teachers}">
                            <option value="${teacher2.id}"
                                    <c:if test="${teacher2.id==teacher.id}">selected</c:if>> ${teacher2.id}: ${teacher2.firstName} ${teacher2.lastName}</option>
                        </c:forEach>
                    </select>
                </div>
            </c:forEach>
        </div>
        <input type="submit" value="Zapisz"/>
    </form>
</div>
</body>
</html>
