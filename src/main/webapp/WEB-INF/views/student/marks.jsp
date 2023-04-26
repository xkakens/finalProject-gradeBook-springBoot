<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 21/04/2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<title> Lista ocen </title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <a href="javascript:history.back()" class="goBackA">
        <button class="goBack"><<<</button>
    </a>
    <h1 class="header">Oceny ucznia ${student.firstName} ${student.lastName}</h1>
    <sec:authorize access="hasAnyAuthority('ADMIN', 'teacher')">
    <a href="/mark/add/${student.id}">
        <button class="goBack">Dodaj ocenę</button>
    </a>
    </sec:authorize>
    <br><br><br>
    <c:forEach var="subject" items="${subjects}" varStatus="loop">
        <c:if test="${numberOfMarks[loop.index]>0}">
            <div class="subjectMark">
                <h2>${subject.name}</h2><br>
                <c:forEach var="mark" items="${marks}">
                    <c:if test="${mark.subject==subject}">
                        <a class="goBackA" <sec:authorize access="hasAnyAuthority('ADMIN', 'teacher')">
                           href="/mark/update/${mark.id}"</sec:authorize>>
                        <div class="bigMarkDiv">
                            <div class="tooltip">
                                <div class="markDiv">
                                    <span class="tooltiptext">${mark.description}</span>
                                        ${mark.value}
                                </div>
                            </div>
                            <br>
                        </div>
                        </a>
                    </c:if>
                </c:forEach>
            </div>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
