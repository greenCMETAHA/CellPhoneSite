<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title>Проект интернет-магазина на шаблоне Free Smart Store Website</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="resources/js/css/styleSidebar.css" rel="stylesheet" type="text/css" media="all" />
	<link href='http://fonts.googleapis.com/css?family=Cabin+Condensed' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="sidebar">
		<div class="s-main">
			<div class="s_hdr">
				<h2>Отборы по каталогу</h2>
			</div>
			<div class="text1-nav">
				<form action="Select" method="POST">
					<ul>
						<li><a href="About">О компании</a></li>
						<li><a href="Catalog">Каталог</a></li>
						<li><a href="AdminPanel">Конфигурирование</a></li>
						<c:if test="${requestScope.isAdmin}">
							дополнить...<br>
						</c:if>
				    </ul>
				    <br><br>
				    <input name="search" type="submit" value="Отбор">
			    </form>
			</div>
		</div>
	</div>
</body>  
</html>
