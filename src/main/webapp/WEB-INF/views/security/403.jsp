<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/utils/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Brak uprawnień</title>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/utils/bodyHeader.jsp" %>
    <h1>Nie masz dostępu do tej zawartości</h1>
    <a href="javascript:history.back()" class="goBackA"><button class="goBack"><<<</button></a>
</div>
</body>
</html>