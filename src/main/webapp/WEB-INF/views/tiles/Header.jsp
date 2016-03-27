<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>

<table border="1">
	<tr>
		<td width="205">Наш Магазин</td>
		<td width="205">Город</td>
		<td width="205">
			<a href="ShopAddresses">Адреса магазинов</a><br>
			<a href="WayToPay">Способ оплаты</a>
		</td>
		<td width="205">Телефон справки</td>
		<td  width="192">
			<a href="login">Войти</a><br>
			<a href="Profile">Кабинет</a>|<a href="logout">Выйти</a><br>
			<a href="Basket">Корзина</a>
		</td>
	</tr>
</table>
<table border="1">
	<tr>
		<td width="230">
			<div>
			<form method="post" action="searchThing">
				<input name="searchField" type="text"><button>Поиск</button>			
			</form>
			</div>
		</td>
		<td width=800>
			<a href="Catalog">Телефоны</a>
		</td>
	</tr>
</table>
</body>  
</html>
