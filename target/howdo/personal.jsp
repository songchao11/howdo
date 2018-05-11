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
		text-align: center;
	}
	.art_img{
		width: 287px;
		height: 175px;
	}
	.tile_title{
		height: 22px;
	}
	.row{
		height:493px;
	}
	.no_content{
		margin-top: 240px;
		margin-left: 360px;
		font-size: 24px;
		font-family: '微软雅黑', 'Microsoft Yahei';
	}
</style>
</head>
<body class="Corporate Homepage " data-skin="corporate">

<!-- 导航栏 start -->
<header id="Header" data-section="header" class="header-non-responsive js-headroom">
<section class="header-section">
<div class="container-fluid container-non-responsive">
<div class='fl'>
<a href="main.jsp" class="logo-container"><img src="//v5-static.ehowcdn.com/media/images/logos/logov3.png" alt="eHow Logo" class="logo" data-gtm-event="nav header" data-gtm-info="logo"/></a>
<span class='nav hidden-xs'>
<%--<label for="menu-toggle" class="label">发现<div class='elegant-icons arrow'>C</div></label>--%>
<%--<input type="checkbox" id="menu-toggle">--%>
<%--<div class='dropdown'>--%>
<%--<div class='category-links'>--%>
<%--<ul>--%>
<%--<li><a href="/home/" data-gtm-event="navHeaderMore">Home Decor &amp; Repair</a></li>--%>
<%--<li><a href="/crafts/" data-gtm-event="navHeaderMore">Crafts</a></li>--%>
<%--<li><a href="/food/" data-gtm-event="navHeaderMore">Food &amp; Drink</a></li>--%>
<%--</ul>--%>
<%--<ul>--%>
<%--<li><a href="/garden/" data-gtm-event="navHeaderMore">Garden</a></li>--%>
<%--<li><a href="/fashion/" data-gtm-event="navHeaderMore">Fashion &amp; Beauty</a></li>--%>
<%--<li><a href="/holidays/" data-gtm-event="navHeaderMore">Holidays</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--<div class='sponsored-programs'>--%>
<%--<ul>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
</span>
</div>
<div>
<div class='eHowUserMenu fr'></div>
<form method="get" action="main.jsp" id="searchHeader">
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

	</div>

	<%--分页--%>
	<div class="article_page">

	</div>

<script type="text/javascript">
	$(function(){
		showUser();
		showArticle(1);
	});

    function showArticle(page){
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
        var userId = userEntity.id;//登录人的id
        var size = 8;
        $.ajax({
            url: "${APP_PATH}/article/collect/"+userId+"/"+page+"/"+size,
            type: "GET",
            success: function(result){
                console.log(result);
                if(result.extend.pageInfo.pages != 0){
                    buildArticleTable(result);
                    build_page_nav(result);
				}else{
                    $(".row").append($("<div></div>").addClass("no_content").append("暂无收藏!"));
				}
            }
        });
    }
    function buildArticleTable(result){
        $(".row").empty();
        var articles = result.extend.pageInfo.list;
        $.each(articles, function(index,item){
            var title_image = $("<a></a>").addClass("tile-image").attr("onclick","to_detail("+item.id+")").attr("data-gtm-event","featured image")
                .append($("<img />").attr("src",item.files[0].path).addClass("art_img")
                    .attr("data-pin-ehow-hover","true").attr("data-pin-no-hover","true"));
            var tile_title = $("<div></div>").addClass("tile_title")
                .append($("<a></a>").attr("data-gtm-event","featured text").attr("onclick","to_detail("+item.id+")").append(item.title));

            var a_headPic = $("<a></a>").attr("data-gtm-event","featured content contributor")
                .append($("<img />").addClass("social-thumb").attr("src",item.user.headPic)
                    .attr("onerror","$(this).parent().parent().remove();"));
            var social_hover_container = $("<div></div>").addClass("social-hover-container")
                .append($("<div></div>").addClass("social-hover")
                    .append($("<a></a>")
                        .append($("<img />").attr("src",item.user.headPic).attr("data-gtm-event","featured content contributor")))
                    .append($("<div></div>").addClass("name")
                        .append($("<a></a>").attr("data-gtm-event","featured content contributor").append(item.user.nickname)))
                    .append($("<div></div>").addClass("year").append(item.user.sigature)));
            var social_thumb_container = $("<div></div>").addClass("social-thumb-container").append(a_headPic).append(social_hover_container);
            var tile_people = $("<div></div>").addClass("tile-people")
                .append($("<div></div>").addClass("social").append(social_thumb_container));
            var art_box = $("<div></div>").addClass("tile column col-xs-6 col-sm-4 col-md-3")
                .append($("<div></div>").addClass("tile-box js-tile-box").append(title_image).append(tile_title).append(tile_people));
            $(".row").append(art_box);
        });
    }
    function build_page_nav(result){
        $(".article_page").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为首页和上一页添加点击事件
            firstPageLi.click(function(){
                showArticle(1);
            });
            prePageLi.click(function(){
                showArticle(result.extend.pageInfo.pageNum-1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                showArticle(result.extend.pageInfo.pageNum+1);
            });
            lastPageLi.click(function(){
                showArticle(result.extend.pageInfo.pages);
            });
        }

        //添加首页和前一页
        ul.append(firstPageLi).append(prePageLi);
        //遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums, function(index,item){
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                showArticle(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        //将ul添加到nav中
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo(".article_page");
    }
    function to_detail(artId){
        window.location.href = "detail.jsp?artId="+artId;
    }
</script>
</body>
</html>