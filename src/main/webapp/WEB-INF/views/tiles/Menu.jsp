<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
	<a href="About">О компании</a><br>
	<a href="Catalog">Каталог</a><br>
	<a href="AdminPanel">Конфигурирование</a><br>
	<c:if test="${requestScope.isAdmin}">
		дополнить...<br>
	</c:if>
</body>  
</html>
