<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
	<c:out value="${requestScope.header}"/>:<br>
	<c:if test="${requestScope.list.size()>0}">
		<ul>
			<c:forEach var="current" items="${requestScope.list}">
				<li><c:out value="${current}"/></li><br>
			</c:forEach>				 
		</ul>
		<hr><br>
	</c:if>
	<br>
	<form action="downloadPhones" method="POST" enctype="multipart/form-data">
		Загрузить файл с телефонами:
		<input type="file"  name="fileExcel" class="upload-file" id="file" value=""/>  
		<button type="submit" >Загрузить</button>
	</form>

	<br><hr><br>
	<form action="downloadPhonePrices" method="POST" enctype="multipart/form-data">
		Загрузить файл с ценами:
		<input type="file"  name="fileExcel" class="upload-file" id="file" value=""/>  
		<button type="submit" >Загрузить</button>
	</form>
	
	<br><hr><br>
	<form action="downloadPhonePhotos" method="POST" enctype="multipart/form-data">
		Загрузить файл с фотографиями:
		<input type="file"  name="fileExcel" class="upload-file" id="file" value=""/>  
		<button type="submit" >Загрузить</button>
	</form>
	
	<br><hr><br>
	<a href="index">В начало</a>
</body>  
</html>
