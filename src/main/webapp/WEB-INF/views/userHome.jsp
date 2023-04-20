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
    <title>userHome</title>
</head>
<body>
<c:forEach var="schoolClass" items="${classes}">
    ${schoolClass.name}
</c:forEach>
</body>
</html>
