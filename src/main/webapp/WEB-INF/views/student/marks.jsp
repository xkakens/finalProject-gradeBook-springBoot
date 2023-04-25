<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalszyba
  Date: 21/04/2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
  <title> Lista ocen </title>
</head>
<body>
<div class="container">
  <a href="/student/${student.id}" class="goBackA"><button class="goBack"><<<</button></a>
<h1 class="header">Oceny ucznia ${student.firstName} ${student.lastName}</h1>
  <a href="/mark/add/${student.id}"><button class="goBack">Dodaj ocenę</button></a>
  <br><br><br>
  <c:forEach var="subject" items="${subjects}" varStatus="loop">
    <c:if test="${numberOfMarks[loop.index]>0}">
      <div class="subjectMark">
      <h2>${subject.name}</h2><br>
        <c:forEach var="mark" items="${marks}">
          <c:if test="${mark.subject==subject}">
            <div class="bigMarkDiv">
              <div class="tooltip">
              <div class="markDiv">

                <span class="tooltiptext">${mark.description}</span>
                  ${mark.value}

              </div>
              </div>
              <br>
            </div>
          </c:if>
        </c:forEach>
      </div>
    </c:if>
  </c:forEach>
</div>
</body>
</html>
