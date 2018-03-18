<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人信息</title>
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
		width: 1070px;
		height: 670px;
		margin-top: 85px;
		margin-left: 250px;
		float: left;
		background-color: white;
	}
	.article_management{
		margin-left: 25px;
		margin-top: 20px;
	}
	.article_management span{
		font-weight: bold;
	}
	.article_tabs{
		margin-left: 25px;
		margin-top: 20px;
		border-bottom:1px solid #e9e9e9;
		width:1017px;
	}
	.article_tabs ul li{
		float: left;
		list-style: none;
	}
	.article_tabs ul li a{
		font-size: 14px;
	}
	.info_left{
		border-right:1px solid #e9e9e9;
		height: 560px;
		width:160px;
		margin-left: 25px;
		float: left;
	}
	.info_left_headpic{
		width: 100px;
		height: 100px;
		margin-top: 29px;
		margin-left: 16px;
		margin-bottom: 15px;
	}
	.info_left_txt{
		margin-left: 37px;
		font-size: 14px;
		margin-top: 15px;
	}
	.info_right{
		width: 560px;
		height: 531px;
		/*border:1px solid red;*/
		float: left;
		margin-left: 30px;
		margin-top: 29px;
	}
	.info_right table tr td{
		width:135px;
		height: 45px;
	}
	.info_button{
		float: left;
		margin-left: 200px;
		width:40px;
		margin-top: 29px;
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
	  <li role="presentation"><a href="personal.jsp"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
	  <li role="presentation"><a href="attention.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;我的关注</a></li>
	  <li role="presentation"><a href="article.jsp"><span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;我的文章</a></li>
	  <li role="presentation"><a href="write.jsp"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;写&nbsp;文&nbsp;章</a></li>
	  <li role="presentation" class="active"><a href=""><span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;个人信息</a></li>
	</ul>
</div>
<div class="right_content">

	<div class="article_management">
		<span>|</span> 个人信息管理
	</div>
	<div class="article_tabs">
		<ul class="nav nav-pills" id="pills-tab" role="tablist">
			<li >
				<a >基本资料</a>
			</li>
			<li >
				<a >修改密码</a>
			</li>
		</ul>
	</div>
	<div class="info_left">
		<div class="info_left_headpic"><img src="http://119.23.77.220/images/cat.jpg"></div>
		<div><a class="info_left_txt">修改头像</a></div>
	</div>
	<div class="info_right">
		<table>
			<tr>
				<td>账号:</td>
				<td>godcc</td>
			</tr>
			<tr>
				<td>昵称:</td>
				<td>天王盖地虎</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>男</td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td>23</td>
			</tr>
			<tr>
				<td>生日:</td>
				<td>2月26日</td>
			</tr>
			<tr>
				<td>星座:</td>
				<td>双鱼座</td>
			</tr>
			<tr>
				<td>居住地:</td>
				<td>芜湖</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>1197308689@qq.com</td>
			</tr>
			<tr>
				<td>个性签名:</td>
				<td>天王盖地虎，小鸡炖蘑菇，蘑菇不在家，转头日二哈天王盖地虎，小鸡炖蘑菇，蘑菇不在家，转头日二哈</td>
			</tr>
		</table>
	</div>
	<div class="info_button"><a>修改</a></div>
	
</div>

<script type="text/javascript">
	$(function(){
		showUser();
	});
</script>
</body>
</html>