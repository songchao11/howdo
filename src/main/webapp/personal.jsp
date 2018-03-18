<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的收藏</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="static/js/userinfo.js"></script>

<link type="image/x-icon" href="//v5-static.ehowcdn.com/favicon.ico" rel="shortcut icon apple-touch-icon"/>
<link rel="stylesheet" type="text/css" href="//dynamic02.ehowcdn.com/services/modules/css/common_header,corporate-skin,article-consolidated-widgets-desktop/12e08054/"/><link type="text/css" href="//v5-static.ehowcdn.com/content/compressed/homepage-1fa83ddb.css" rel="stylesheet"/>
<meta http-equiv=“X-UA-Compatible” content=“IE=edge”>
<script>window._omnitureLinkSetDomain = 'extended.dmtracker.com';</script>


<script src="//dynamic01.ehowcdn.com/services/modules/js/common_header/0dbdbf9e/"></script><script type="text/javascript" src="//native.sharethrough.com/assets/sfp.js" defer></script><script type="text/javascript" src="//www.zergnet.com/zerg-inf-multi.js"></script>
<style type="text/css">
	#Header{
		position:fixed;
	}
	html{
		background-color: #f4f4f4;
	}
	.user_menu {
		width: 125px;
		height: 30px;
		float: right;
		margin-top: -25px;
		text-align: center;
	}
	.dropdown-menu {
		margin-top: -1px;
		margin-left: 81%;
	}
	.user_menu a{
		color: white;
		text-decoration:none;
	}
	.side_navigation{
		/*border: 1px solid red;*/
		margin-top: 85px;
		width: 180px;
		margin-left: 40px;
		height: 500px;
		position:fixed;
		background-color: white;
	}
	.right_content{
		/*border: 1px solid black;*/
		width: 1070px;
		height: 670px;
		margin-top: 85px;
		margin-left: 250px;
		float: left;
		background-color: white;
	}
	.article_page{
		margin-top: -20px;
		text-align: center;
	}
</style>
</head>
<body class="Corporate Homepage " data-skin="corporate">

<!-- 导航栏 start -->
<header id="Header" data-section="header" class="header-non-responsive js-headroom">
<section class="header-section">
<div class="container-fluid container-non-responsive">
<div class='fl'>
<a href="//www.ehow.com/" class="logo-container"><img src="//v5-static.ehowcdn.com/media/images/logos/logov3.png" alt="eHow Logo" class="logo" data-gtm-event="nav header" data-gtm-info="logo"/></a>
<span class='nav hidden-xs'>
<label for="menu-toggle" class="label">发现<div class='elegant-icons arrow'>C</div></label>
<input type="checkbox" id="menu-toggle">
<div class='dropdown'>
<div class='category-links'>
<ul>
<li><a href="/home/" data-gtm-event="navHeaderMore">Home Decor &amp; Repair</a></li>
<li><a href="/crafts/" data-gtm-event="navHeaderMore">Crafts</a></li>
<li><a href="/food/" data-gtm-event="navHeaderMore">Food &amp; Drink</a></li>
</ul>
<ul>
<li><a href="/garden/" data-gtm-event="navHeaderMore">Garden</a></li>
<li><a href="/fashion/" data-gtm-event="navHeaderMore">Fashion &amp; Beauty</a></li>
<li><a href="/holidays/" data-gtm-event="navHeaderMore">Holidays</a></li>
</ul>
</div>
<div class='sponsored-programs'>
<ul>
</ul>
</div>
</div>
</span>
</div>
<div>
<div class='eHowUserMenu fr'></div>
<form method="get" action="/sitesearch.html" id="searchHeader">
<label class="elegant-icons magnifying-glass hidden-xs">&#x55;</label>
<input type="text" name="s" style="color: black;" value="" autofocus onfocus="this.value = this.value;" placeholder="Search">
<input name="skin" type="hidden" value="corporate"/>
<button class="submit gh-bttn" type="submit">
<span class="hidden-xs">Search</span>
<span class="elegant-icons magnifying-glass visible-xs">&#x55;</span>
</button>
<input name="t" type="hidden" value="all"/>
</form>
</div>
<div class="user_menu">
	
</div>
</div>
</section>
</header>
<!-- 导航栏 end -->
<div class="non-responsive-spacer"></div>
<div class="inner-container">
</div>
<!-- 侧边导航栏 -->

<div class="side_navigation">
	<ul class="nav nav-pills nav-stacked">
	  <li role="presentation" class="active"><a href=""><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
	  <li role="presentation"><a href="attention.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;我的关注</a></li>
	  <li role="presentation"><a href="article.jsp"><span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;我的文章</a></li>
	  <li role="presentation"><a href="write.jsp"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;写&nbsp;文&nbsp;章</a></li>
	  <li role="presentation"><a href="information.jsp"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;个人信息</a></li>
	</ul>
</div>
<div class="right_content">
	
	<div class='row'>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/how_12343042_surprisingly-easy-gourmet-chicken-recipes.html" data-title="23 Surprisingly Easy Chicken Recipes" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/d8e69996-4e06-48d3-bc73-6fa7dbb3b314.jpg" data-summary="Whether you enjoy your chicken oven-fried, skewered or curried, here are 18 delicious and surprisingly easy chicken recipes." data-favorites="uninitialized">
		<a class='tile-image' href="/how_12343042_surprisingly-easy-gourmet-chicken-recipes.html" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/d8e69996-4e06-48d3-bc73-6fa7dbb3b314.jpg" alt="23 Surprisingly Easy Chicken Recipes" data-target="https://www.ehow.com/how_12343042_surprisingly-easy-gourmet-chicken-recipes.html" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/how_12343042_surprisingly-easy-gourmet-chicken-recipes.html" data-gtm-event="featured text">23 Surprisingly Easy Chicken Recipes</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		<div class="social-thumb-container">
		<a href="/contributor/chrystl_sanchez/" data-gtm-event="featured content contributor"><img class="social-thumb" src="//img-aws.ehowcdn.com/60x60/cme/cme_public_images/www_demandstudios_com/sitelife.studiod.com/ver1.0/Content/images/store/14/1/3ea24825-f02c-4d95-8189-de3055027f51.Small.jpg" onerror="$(this).parent().parent().remove();"></a>
		<div class="social-hover-container">
		<div class="social-hover">
		<a href="/contributor/chrystl_sanchez/"><img src="//img-aws.ehowcdn.com/60x60/cme/cme_public_images/www_demandstudios_com/sitelife.studiod.com/ver1.0/Content/images/store/14/1/3ea24825-f02c-4d95-8189-de3055027f51.Small.jpg" data-gtm-event="featured content contributor"></a>
		<div class="name"><a href="/contributor/chrystl_sanchez/" data-gtm-event="featured content contributor">Chrystl Sanchez</a></div>
		<div class="year">Contributed this</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/13709283/homemade-raspberry-linzer-cookies-recipe" data-title="Homemade Raspberry Linzer Cookies Recipe" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/41fa9279-0b8a-479e-8384-bccef7b476b0.jpg" data-summary="Learn how to make easy and delicious raspberry jam filled Homemade Linzer Cookies for Valentine's Day!" data-favorites="uninitialized">
		<a class='tile-image' href="/13709283/homemade-raspberry-linzer-cookies-recipe" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/41fa9279-0b8a-479e-8384-bccef7b476b0.jpg" alt="Homemade Raspberry Linzer Cookies Recipe" data-target="https://www.ehow.com/13709283/homemade-raspberry-linzer-cookies-recipe" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/13709283/homemade-raspberry-linzer-cookies-recipe" data-gtm-event="featured text">Homemade Raspberry Linzer Cookies Recipe</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		<div class="social-thumb-container">
		<a href="/contributor/thalia_ho/" data-gtm-event="featured content contributor"><img class="social-thumb" src="//img-aws.ehowcdn.com/60x60/cme/cme_public_images/www_demandstudios_com/sitelife.studiod.com/ver1.0/Content/images/store/7/14/1751344e-b27b-4429-ae53-42de53cce1b8.Small.jpg" onerror="$(this).parent().parent().remove();"></a>
		<div class="social-hover-container">
		<div class="social-hover">
		<a href="/contributor/thalia_ho/"><img src="//img-aws.ehowcdn.com/60x60/cme/cme_public_images/www_demandstudios_com/sitelife.studiod.com/ver1.0/Content/images/store/7/14/1751344e-b27b-4429-ae53-42de53cce1b8.Small.jpg" data-gtm-event="featured content contributor"></a>
		<div class="name"><a href="/contributor/thalia_ho/" data-gtm-event="featured content contributor">Thalia Ho</a></div>
		<div class="year">Contributed this</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/13708689/family-favorite-sweet-potato-casserole-recipe" data-title="Family Favorite Sweet Potato Casserole Recipe" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/e167bc38-7db8-4779-a70d-b5d37ac15fba.jpg" data-summary="Make family favorite sweet potato casserole and wow everyone at the table with this delicious and easy classic recipe!" data-favorites="uninitialized">
		<a class='tile-image' href="/13708689/family-favorite-sweet-potato-casserole-recipe" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/e167bc38-7db8-4779-a70d-b5d37ac15fba.jpg" alt="Family Favorite Sweet Potato Casserole Recipe" data-target="https://www.ehow.com/13708689/family-favorite-sweet-potato-casserole-recipe" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/13708689/family-favorite-sweet-potato-casserole-recipe" data-gtm-event="featured text">Family Favorite Sweet Potato Casserole Recipe</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		<div class="social-thumb-container">
		<a href="/contributor/leigh_ann_chatagnier/" data-gtm-event="featured content contributor"><img class="social-thumb" src="//img-aws.ehowcdn.com/60x60/studiod/ver1.0/Content/images/store/0/14/00df86cd-74dd-4806-8e01-e577a38af473.Small.jpg" onerror="$(this).parent().parent().remove();"></a>
		<div class="social-hover-container">
		<div class="social-hover">
		<a href="/contributor/leigh_ann_chatagnier/"><img src="//img-aws.ehowcdn.com/60x60/studiod/ver1.0/Content/images/store/0/14/00df86cd-74dd-4806-8e01-e577a38af473.Small.jpg" data-gtm-event="featured content contributor"></a>
		<div class="name"><a href="/contributor/leigh_ann_chatagnier/" data-gtm-event="featured content contributor">Leigh Ann Chatagnier</a></div>
		<div class="year">Contributed this</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/13709065/how-to-make-a-sleek-convenient-wine-glass-holder" data-title="How to Make a Sleek &amp; Convenient Wine Glass Holder" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/02554237-f197-4835-a924-b578355910a9.jpg" data-summary="Here's a quick and easy tutorial for a wine glass holder that you can customize to your personal taste. It carries four glasses and a wine bottle–perfect for entertaining." data-favorites="uninitialized">
		<a class='tile-image' href="/13709065/how-to-make-a-sleek-convenient-wine-glass-holder" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/02554237-f197-4835-a924-b578355910a9.jpg" alt="How to Make a Sleek &amp; Convenient Wine Glass Holder" data-target="https://www.ehow.com/13709065/how-to-make-a-sleek-convenient-wine-glass-holder" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/13709065/how-to-make-a-sleek-convenient-wine-glass-holder" data-gtm-event="featured text">How to Make a Sleek &amp; Convenient Wine Glass Holder hello everybody put you hands aaaaaaaaaaaaaaa</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		<div class="social-thumb-container">
		<img class="social-thumb" src="//s3-us-west-1.amazonaws.com/contentlab.studiod/profile/12/1/9ca23611ee9a4a0c8a43289f46148f0e" onerror="$(this).parent().remove();">
		<div class="social-hover-container">
		<div class="social-hover">
		<img src="//s3-us-west-1.amazonaws.com/contentlab.studiod/profile/12/1/9ca23611ee9a4a0c8a43289f46148f0e">
		<div class="name">Rachel Metz</div>
		<div class="year">Contributed this</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/13709260/diy-no-sew-tooth-fairy-pillow" data-title="DIY No-Sew Tooth Fairy Pillow" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/30ac8ff4-b38f-492f-9742-6c5159df9cb3.jpg" data-summary="Turn the milestone of losing one's baby tooth into an enchanting experience with this whimsical DIY no-sew tooth fairy pillow.  " data-favorites="uninitialized">
		<a class='tile-image' href="/13709260/diy-no-sew-tooth-fairy-pillow" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/30ac8ff4-b38f-492f-9742-6c5159df9cb3.jpg" alt="DIY No-Sew Tooth Fairy Pillow" data-target="https://www.ehow.com/13709260/diy-no-sew-tooth-fairy-pillow" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/13709260/diy-no-sew-tooth-fairy-pillow" data-gtm-event="featured text">DIY No-Sew Tooth Fairy Pillow</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/13709063/diy-cupids-arrow-cake-pops" data-title="DIY Cupid's Arrow Cake Pops" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/27a7f88e-2be0-4af5-ba3b-76878677c2ab.jpg" data-summary="Whether you're celebrating Valentine's Day or Singles Awareness Day, you'll definitely enjoy these Cupid's arrow cake pops with a bloody twist. " data-favorites="uninitialized">
		<a class='tile-image' href="/13709063/diy-cupids-arrow-cake-pops" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/27a7f88e-2be0-4af5-ba3b-76878677c2ab.jpg" alt="DIY Cupid&#039;s Arrow Cake Pops" data-target="https://www.ehow.com/13709063/diy-cupids-arrow-cake-pops" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/13709063/diy-cupids-arrow-cake-pops" data-gtm-event="featured text">DIY Cupid's Arrow Cake Pops</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		<div class="social-thumb-container">
		<img class="social-thumb" src="//s3-us-west-1.amazonaws.com/contentlab.studiod/profile/12/1/9ca23611ee9a4a0c8a43289f46148f0e" onerror="$(this).parent().remove();">
		<div class="social-hover-container">
		<div class="social-hover">
		<img src="//s3-us-west-1.amazonaws.com/contentlab.studiod/profile/12/1/9ca23611ee9a4a0c8a43289f46148f0e">
		<div class="name">Rachel Metz</div>
		<div class="year">Contributed this</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
		<div class='tile-box js-tile-box' data-url="www.ehow.com/13708787/tater-tot-nachos-recipe" data-title="Tater Tot Nachos Recipe" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/a678d257-25ef-4b56-9511-fc6892ebad42.jpg" data-summary="Turn one of your favorite ways to eat potatoes into the best nachos you have ever eaten!  Tater tot nachos are going to be your new favorite induldence!" data-favorites="uninitialized">
		<a class='tile-image' href="/13708787/tater-tot-nachos-recipe" data-gtm-event="featured image">
		<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/a678d257-25ef-4b56-9511-fc6892ebad42.jpg" alt="Tater Tot Nachos Recipe" data-target="https://www.ehow.com/13708787/tater-tot-nachos-recipe" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
		</a>
		<div class='tile-title'>
		<a href="/13708787/tater-tot-nachos-recipe" data-gtm-event="featured text">Tater Tot Nachos Recipe</a>
		</div>
		<div class='tile-people'>
		<div class="social">
		<div class="social-thumb-container">
		<a href="/contributor/leigh_ann_chatagnier/" data-gtm-event="featured content contributor"><img class="social-thumb" src="//img-aws.ehowcdn.com/60x60/studiod/ver1.0/Content/images/store/0/14/00df86cd-74dd-4806-8e01-e577a38af473.Small.jpg" onerror="$(this).parent().parent().remove();"></a>
		<div class="social-hover-container">
		<div class="social-hover">
		<a href="/contributor/leigh_ann_chatagnier/"><img src="//img-aws.ehowcdn.com/60x60/studiod/ver1.0/Content/images/store/0/14/00df86cd-74dd-4806-8e01-e577a38af473.Small.jpg" data-gtm-event="featured content contributor"></a>
		<div class="name"><a href="/contributor/leigh_ann_chatagnier/" data-gtm-event="featured content contributor">Leigh Ann Chatagnier</a></div>
		<div class="year">Contributed this</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
		<div class='tile column col-xs-6 col-sm-4 col-md-3'>
<div class='tile-box js-tile-box' data-url="www.ehow.com/13664138/how-to-make-chilis-queso-dip-tutorial" data-title="How to Make Chili's Queso Dip" data-image="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/c4eb04ec-9e55-4141-ab65-7e50dc8126fd.jpg" data-summary="Make Chili's queso dip at home with just a few simple ingredients and always have a crowd pleasing appetizer on hand!" data-favorites="uninitialized">
<a class='tile-image' href="/13664138/how-to-make-chilis-queso-dip-tutorial" data-gtm-event="featured image">
<img src="//img-aws.ehowcdn.com/374x258/cme/photography.prod.demandstudios.com/c4eb04ec-9e55-4141-ab65-7e50dc8126fd.jpg" alt="How to Make Chili&#039;s Queso Dip" data-target="https://www.ehow.com/13664138/how-to-make-chilis-queso-dip-tutorial" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
</a>
<div class='tile-title'>
<a href="/13664138/how-to-make-chilis-queso-dip-tutorial" data-gtm-event="featured text">How to Make Chili's Queso Dip</a>
</div>
<div class='tile-people'>
<div class="social">
<div class="social-thumb-container">
<a href="/contributor/leigh_ann_chatagnier/" data-gtm-event="featured content contributor"><img class="social-thumb" src="//img-aws.ehowcdn.com/60x60/studiod/ver1.0/Content/images/store/0/14/00df86cd-74dd-4806-8e01-e577a38af473.Small.jpg" onerror="$(this).parent().parent().remove();"></a>
<div class="social-hover-container">
<div class="social-hover">
<a href="/contributor/leigh_ann_chatagnier/"><img src="//img-aws.ehowcdn.com/60x60/studiod/ver1.0/Content/images/store/0/14/00df86cd-74dd-4806-8e01-e577a38af473.Small.jpg" data-gtm-event="featured content contributor"></a>
<div class="name"><a href="/contributor/leigh_ann_chatagnier/" data-gtm-event="featured content contributor">Leigh Ann Chatagnier</a></div>
<div class="year">Contributed this</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
	</div>

	<%--分页--%>
	<div class="article_page">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>

<script type="text/javascript">
	$(function(){
		showUser();
	});
</script>
</body>
</html>