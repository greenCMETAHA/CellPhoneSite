<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title>Проект интернет-магазина на шаблоне Free Smart Store Website</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="resources/js/css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="resources/js/css/menu.css" rel="stylesheet" type="text/css" media="all"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	<script src="resources/js/js/script.js" type="text/javascript"></script>
	<script type="text/javascript" src="resources/js/js/jquery-1.7.2.min.js"></script> 
	<script type="text/javascript" src="resources/js/js/nav.js"></script>
	<script type="text/javascript" src="resources/js/js/move-top.js"></script>
	<script type="text/javascript" src="resources/js/js/easing.js"></script>
	<script type="text/javascript" src="resources/js/js/nav-hover.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Monda' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Doppio+One' rel='stylesheet' type='text/css'>
	<script type="text/javascript">
	  $(document).ready(function($){
	    $('#dc_mega-menu-orange').dcMegaMenu({rowItems:'4',speed:'fast',effect:'fade'});
	  });
	</script>
</head>
<body>

<div class="wrap">
	<div class="header">
		<div class="header_top">
			<div class="logo">
				<a href="index.html"><img src="resources/js/images/logo.png" alt="" /></a>
			</div>
			  <div class="header_top_right">
			    <div class="search_box">
				    <form action="searchThing" method="POST">
				    	<input type="text" name="searchField" value="Search for Products" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search for Products';}"><input type="submit" value="SEARCH">
				    </form>
			    </div>
			    <div class="shopping_cart">
					<div class="cart">
						<a href="#" title="View my shopping cart" rel="nofollow">
							<strong class="opencart"> </strong>
								<span class="cart_title">Cart</span>
									<span class="no_product">(empty)</span>
							</a>
						</div>
			      </div>
	    <div class="languages" title="language">
	    	<div id="language" class="wrapper-dropdown" tabindex="1">EN
				<strong class="opencart"> </strong>
				<ul class="dropdown languges">					
					 <li>
					 	<a href="#" title="English">
							<span><img src="resources/js/images/gb.png" alt="en" width="26" height="26"></span><span class="lang">English</span>
						</a>
					 </li>
					 <li>
						<a href="$" title="Russian">
							<span><img src="resources/js/images/cu.png" alt="ru" width="26" height="26"></span><span class="lang">Russian</span>
						</a>
					 </li>					
			   </ul>
		     </div>
		     <script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#language') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown').removeClass('active');
				});

			});

		</script>
		 </div>
			<div class="currency" title="currency">
					<div id="currency" class="wrapper-dropdown" tabindex="1">$
						<strong class="opencart"> </strong>
						<ul class="dropdown">
							<li><a href="#"><span>$</span>Dollar</a></li>
							<li><a href="#"><span>€</span>Euro</a></li>
						</ul>
					</div>
					 <script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#currency') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown').removeClass('active');
				});

			});

		</script>
   </div>
		   <div class="login">
		   	   <span><a href="Login"><img src="resources/js/images/login.png" alt="" title="Login"/></a></span>
		   </div>
		 <div class="clear"></div>
	 </div>
	 <div class="clear"></div>
 </div>
	<div class="menu">
	  <ul id="dc_mega-menu-orange" class="dc_mm-orange">
		 <li><a href="index">В начало</a></li>
    <li><a href="FullCatalog">Каталог</a>
    <ul>
      <li><a href="Catalog">Мобильные телефоны</a>
        <ul>
			<c:forEach var="current" items="${requestScope.listMobileTypes}" >
				<li><a href="Catalog?phoneType=${current.getId()}"> <c:out value="${current.getName()}"/></a></li>
			</c:forEach>   				     
        </ul>
      </li>
      <li><a href="DesctopCatalog">Планшеты</a>
        <ul>
          <li>Пока не сделано</li>
        </ul>
      </li>
    </ul>
  </li>
  <li><a href="Catalog">Производители</a>
    <ul>
		<c:forEach var="current" items="${requestScope.listManufacturers}" >
			<li><a href="Catalog?manufacturer=${current.getId()}"> <c:out value="${current.getName()}"/></a></li>
		</c:forEach>   				     
    </ul>
  </li>
  <li><a href="About">О нас</a></li>
  <li><a href="WayToPay">Способ оплаты</a></li>
  <li><a href="ShopAddresses">Адреса магазинов</a></li>
  <div class="clear"></div>
</ul>
</body>  
</html>
