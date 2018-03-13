<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑文章</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link type="image/x-icon" href="//v5-static.ehowcdn.com/favicon.ico" rel="shortcut icon apple-touch-icon"/>
<link rel="stylesheet" type="text/css" href="//dynamic02.ehowcdn.com/services/modules/css/common_header,corporate-skin,article-consolidated-widgets-desktop/12e08054/"/><link type="text/css" href="//v5-static.ehowcdn.com/content/compressed/homepage-1fa83ddb.css" rel="stylesheet"/>
<meta http-equiv=“X-UA-Compatible” content=“IE=edge”>
<script>window._omnitureLinkSetDomain = 'extended.dmtracker.com';</script>

<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>

<script src="//dynamic01.ehowcdn.com/services/modules/js/common_header/0dbdbf9e/"></script><script type="text/javascript" src="//native.sharethrough.com/assets/sfp.js" defer></script><script type="text/javascript" src="//www.zergnet.com/zerg-inf-multi.js"></script>
<style type="text/css">
	#Header{
		position:fixed;
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
		width: 215px;
		height: 500px;
		position:fixed;
		background-color: #f4f4f4;
	}
	.right_content{
		/*border: 1px solid black;*/
		width: 1070px;
		/*height: 100px;*/
		margin-top: 85px;
		margin-right: 30px;
		float: right;
	}
	.article_title{
		/*border: 1px solid red;*/
		height: 50px;
	}
	#a_title{
		width: 625px;
		height: 35px;
		background-color: #f4f4f4;
		outline: none;
	}
	.content{
		background-color: #f4f4f4;
	}
	#btn_draft{
		height: 35px;
		margin-left: 72px;
	}
	#btn_article{
		height: 35px;
		margin-left: 5px;
	}
	.side_navigation ul li a{
		margin-left: 10px;
	}
	.article_title select{
		background-color: #f4f4f4;
		width: 200px;
		height: 35px;
		outline: none;
		border: none;
		
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
	  <li role="presentation" class="active"><a href=""><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;写&nbsp;文&nbsp;章</a></li>
	  <li role="presentation"><a href="information.jsp"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;个人信息</a></li>
	</ul>
</div>
<div class="right_content">
	
	<div class="article_title">
		<select id="cate_select">
			<option value ="0">请选择文章类型</option>
		</select>
		<input type="text" id="a_title" placeholder="  输入文章标题"/>
		<input type="submit" value="保存草稿" id="btn_draft" />
		<input type="submit" value="发布文章" id="btn_article" />
	</div>
	<div class="content">
		<script id="editor" type="text/plain" style="width:100%;height: 575px; background-color: #f4f4f4;"></script>
	</div>
</div>

<script type="text/javascript">

	var ue = UE.getEditor('editor');

	$(function(){
		showUser();
		showArticleCategory();
	});
	function showUser(){
		//清空 .user_menu div里面的东西
		$(".user_menu").empty(); 
		$.ajax({
			url: "${APP_PATH}/user",
			type: "GET",
			success: function(result){
				if(result.code == 100){
					var a_user = $("<a></a>").addClass("dropdown-toggle").attr("href","#").attr("data-toggle","dropdown")
					.attr("role","button").attr("aria-haspopup","true").attr("aria-expanded","false").append(result.extend.user.nickname)
					.append($("<span></span>").addClass("caret"));
					var a_ul = $("<ul></ul>").addClass("dropdown-menu").append($("<li></li>").append($("<a></a>").attr("href","personal.jsp").append("个人中心")))
					.append($("<li></li>").addClass("divider").attr("role","separator"))
					.append($("<li></li>").append($("<a></a>").append("退出登录").attr("href","logout")));
					$("<span></span>").append(a_user).append(a_ul).appendTo(".user_menu");
				}else if(result.code == 200){
					var a_login = $("<a></a>").append("登录").attr("href","login.jsp");
					var a_text = $("<span></span>").append("&nbsp;|&nbsp;");
					var a_register = $("<a></a>").append("注册").attr("href","register.jsp");
					$("<span></span>").append(a_login).append(a_text).append(a_register).appendTo(".user_menu");
				}
			}
		});
	}
	$("#btn_draft").click(function(){
		var title = $("#a_title").val();
		var content = UE.getEditor('editor').getContent();
		if(title != "" && content != ""){
			
		}else{
			
		}
	});

	function showArticleCategory(){
		$.ajax({
			url: "${APP_PATH}/article/categorys",
			type: "GET",
			success: function(result){
				var cates = result.extend.cates;
				$.each(cates, function(index,item){
					$("<option></option>").append(item.name).attr("value",item.id).appendTo("#cate_select");
				});
			}
		});
	}
</script>
</body>
</html>