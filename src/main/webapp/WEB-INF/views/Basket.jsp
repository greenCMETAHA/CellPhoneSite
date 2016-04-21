<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
	<c:set  var="name" value="basket" />
    <c:set var="basket" value="${sessionScope[name]}"></c:set>
	Список покупок:<br>
	<div class="clear"></div>
	<c:forEach var="current" items="${basket}">
		<img height="70" src="resources/jpg/${current.getGood().getMainPhoto()}" alt="" />   <c:out value="${current.getName()}"/><br>
		<c:out value="${current.getQuantuty()}"/><br>
		по цене: <c:out value="${current.getPrice()}"/><br>
		на сумму: <c:out value="${current.getQuantuty()*current.getPrice()}"/>
		<div class="clear"></div>
		<hr>		
	</c:forEach>
</body>  
</html>