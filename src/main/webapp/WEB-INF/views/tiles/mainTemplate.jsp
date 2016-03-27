<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content="MediaCenter, Template, eCommerce">
    <meta name="robots" content="all">
    <title>Продажа телtфонов</title>
 </head>
<body>
    <tiles:insertAttribute name="Header" />
    
    <table border="1">
    	<tr>
    		<td width="230">
    			<tiles:insertAttribute name="Menu"></tiles:insertAttribute>
    		</td>
    		<td width="800">
				<tiles:insertAttribute name="Body"></tiles:insertAttribute>    		
    		</td>
    	</tr>
    </table>
	<tiles:insertAttribute name="Footer"></tiles:insertAttribute>
</body>
</html>