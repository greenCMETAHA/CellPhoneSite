<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
	Наши магазины:
	
	<br><hr><br>
	<div>
		<ul>
			<c:forEach var="current" items="${requestScope.list}">
				<li><c:out value="${current.getName()}"/>, <c:out value="${current.getDescription()}"/></li>
				
			</c:forEach>
		</ul>
	</div>
	<br><hr><br>
	<a href="index">В начало</a>
</body>  
</html>