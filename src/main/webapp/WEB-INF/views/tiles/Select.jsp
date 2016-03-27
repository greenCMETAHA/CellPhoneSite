<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>

	<form action="Select" method="POST">
		Отборы по каталогу
		<br>
		<br>

		<input name="search" type="submit" value="Отбор">
	</form>
</body>  
</html>
