<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
	<c:set  var="name" value="compare" />
    <c:set var="compare" value="${sessionScope[compare]}"></c:set>

	<div class="content">
		<hr>
		<h2>Сравнить товары:</h2>
		<hr>
		<table>
		<th></th>
		<tr>
			<td></td>
		</tr>
		
		
		</table>
		
		<hr>
	</div>		
	<c:out value="${requestScope.header}"></c:out>
	<br><br>
	<a href="index">В начало</a>
</body>  
</html>