<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

	<h2><c:out value="${requestScope.errNumber}"/></h2><br>
    <c:out value="${requestScope.errMessage}"/></p>
    <br><hr><br>
    <a href="index">  Перейти на главную страницу</a>
