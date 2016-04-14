<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
   <div class="footer">
   	  <div class="wrapper">	
	     <div class="section group">
				<div class="col_1_of_4 span_1_of_4">
						<h4>Информация</h4>
						<ul>
						<li><a href="About">О нас</a></li>
						<li><a href="Developer">Разработчик</a></li>
						</ul>
					</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Как купить</h4>
						<ul>
						<li><a href="ShopAddresses">Наши магазины</a></li>
						<li><a href="WayToPay">Способ оплаты</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Мой профиль</h4>
						<ul>
							<li><a href="Login">Войти</a></li>
							<li><a href="Basket">Корзина</a></li>
						</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Контакты:</h4>
						<ul>
							<li><span>телефон</span></li>
							<li><span>glebas@tut.by</span></li>
							<li><span><a href="https://www.locomotions.ru" target="_blank"> </a></span></li>
						</ul>
						<div class="social-icons">
							<h4>Наши ссылки:</h4>
					   		  <ul>
							      <li class="facebook"><a href="https://www.facebook.com/profile.php?id=100005508341216" target="_blank"> </a></li>
							      <li class="twitter"><a href="https://twitter.com/greenCMETAHA" target="_blank"> </a></li>
							      <li class="googleplus"><a href="https://plus.google.com/106953812330765325240/posts" target="_blank"> </a></li>
							      <li class="contact"><a href="mailto:glebas@tut.by" target="_blank"> </a></li>
							      <div class="clear"></div>
						     </ul>
   	 					</div>
				</div>
			</div>
			<div class="copy_right">
				<p>Разработано: Васильченко Глеб, ака <a href="https://vk.com/greencmetaha">greenCMETAHA</a>. 2016 г.   </p>
		   </div>
     </div>
    </div>
    <script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
	  			containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
	 		};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
    <link href="resources/js/css/flexslider.css" rel='stylesheet' type='text/css' />
							  <script defer src="resources/js/js/jquery.flexslider.js"></script>
							  <script type="text/javascript">
								$(function(){
								  SyntaxHighlighter.all();
								});
								$(window).load(function(){
								  $('.flexslider').flexslider({
									animation: "slide",
									start: function(slider){
									  $('body').removeClass('loading');
									}
								  });
								});
							  </script>
</body>  
</html>
