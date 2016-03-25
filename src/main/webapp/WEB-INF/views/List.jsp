<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Список телефонов</title>
</head>
<body>

Список контрагентов:<br>
<hr>
<br>

<c:set var="name" value="list" />	
<c:forEach var="current" items="${requestScope.list}">
	<c:out value="${current.getId()}"/>, <c:out value="${current.getName()}"/>;<br>


</c:forEach>







<br>
<hr>
<br>

<a href="index">Назад, на главную</a>


</body>
</html>