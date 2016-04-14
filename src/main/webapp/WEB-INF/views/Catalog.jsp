<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>

<div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>Каталог товаров:</h3>
    		</div>
    		<div class="sort">
    		<p>Отсортировать:
    			<select>
    				<option>По наименованию</option>
    				<option>По цене</option>
    				<option>Наличие</option>
    			</select>
    		</p>
    		</div>
    		<div class="show">
    		<p>Показывать по:
    			<select>
    				<option>4</option>
    				<option>8</option>
    				<option>12</option>
    				<option>16</option>
    				<option>20</option>
    			</select>
    		</p>
    		</div>
    		<div class="page-no">
    			<p>Страница<ul>
    				<li><a href="#">1</a></li>
    				<li class="active"><a href="#">2</a></li>
    				<li><a href="#">3</a></li>
    				<li>[<a href="#"> >>></a >]</li>
    				</ul></p>
    		</div>
    		<div class="clear"></div>
    	</div>
        <div class="section group">
	      	<c:forEach var="current" items="${requestScope.list}">
				<div class="grid_1_of_4 images_1_of_4">
 					<table>
					<td width="200"> 
						<a href="ShowOne?good=${current.getId()}"><img height="200" src="resources/jpg/${current.getMainPhoto()}" alt="" /></a>
					</td>
					<td width="5"></td> 
					<td>
						 <h2><a href="ShowOne?good=${current.getId()}"><c:out value="${current.getName()}"/></a></h2>
						 <p><c:out value="${current.getManufacturer().getName()}"/></p>
						 <p>
							 <c:if test="${current.getPriceWithDiscount()!=current.getLastPrice().getPrice()}">
								<span class="strike">$<c:out value="${current.getStringPriceWithDiscount()}"/></span>							 
							 </c:if>
						 	 <span class="price">$<c:out value="${current.getLastPrice().getStringPrice()}"/></span></p>
						 <p align="left"><c:out value="${current.getDescription(200)}"/></p>
						 	 
						 	
						 <div class="button"><span><img src="resources/js/images/cart.jpg" alt="" />
						  	<a href="ShowOne?good=${current.getId()}" class="cart-button">В корзину</a></span>
						 </div>
					     <div class="button"><span><a href="ShowOne?good=${current.getId()}" class="details">Подробно</a></span>
					     </div>
					</td>
					</table>
				</div>
				<div class="clear"></div>
			</c:forEach>
		</div>
   		<div class="clear"></div>
    </div>
 </div>
</div>
</body>  
</html>