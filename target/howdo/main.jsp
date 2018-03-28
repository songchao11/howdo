<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HowDo</title>

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
	.art_img{
		width: 287px;
		height: 198px;
	}
	.page_nav{
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
	<!-- <a href="login.jsp">登录</a><span>&nbsp;|&nbsp;</span><a href="register.jsp">注册</a> -->
          <!-- <span>
          <a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          	admin 
          	<span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">个人中心</a></li>
            
            <li role="separator" class="divider"></li>
            <li><a href="logout">退出登录</a></li>
          </ul>  
          </span> -->
        
</div>
</div>
</section>
</header>
<!-- 导航栏 end -->
<div class="non-responsive-spacer"></div>
<div class="inner-container">
</div>
<section id="Body" class="Homepage FLC" data-page-id="homepage" data-section="body" >
<!-- 特色项目 -->
<div class="container-fluid hero-container">
	<a href="/13709304/how-to-sew-diy-fabric-storage-boxes" data-gtm-event="featured hero">
	<div class="hero-image">
	<img src="../img/1.jpg.jpg" alt="How to Sew DIY Fabric Storage Boxes" data-target="https://www.ehow.com/13709304/how-to-sew-diy-fabric-storage-boxes" data-pin-ehow-hover="true" data-pin-no-hover="true"/>
	</div>
	<div class="hero-title-container">
	<div class="hero-label">
	<span>特色项目</span>
	</div>
	<div class="hero-title">
	如何缝制布料储物盒
	</div>
	</div>
	</a>
</div>
<div class="container-fluid tile-container">
<div class='row'>
<div class='full-tile column col-xs-12'>
<span class="full-title">DIY & 如何做到一切</span>
<div class="rounded-line"></div>
</div>

	<div class="art_list"></div>
<%--<div class='tile column col-xs-6 col-sm-4 col-md-3'>--%>
<%--<div class='tile-box js-tile-box'>--%>
<%--<a class='tile-image' href="" data-gtm-event="featured image">--%>
<%--<img src="http://119.23.77.220/images/201803211521634135128084551.jpg" class="art_img" data-pin-ehow-hover="true" data-pin-no-hover="true"/>--%>
<%--</a>--%>
<%--<div class='tile-title'>--%>
<%--<a href="" data-gtm-event="featured text">23 Surprisingly Easy Chicken Recipes</a>--%>
<%--</div>--%>

<%--<div class='tile-people'>--%>
	<%--<div class="social">--%>
		<%--<div class="social-thumb-container">--%>
			<%--<a href="" data-gtm-event="featured content contributor">--%>
				<%--<img class="social-thumb" src="http://119.23.77.220/images/cat.jpg" onerror="$(this).parent().parent().remove();">--%>
			<%--</a>--%>
			<%--<div class="social-hover-container">--%>
				<%--<div class="social-hover">--%>
					<%--<a href="/contributor/chrystl_sanchez/">--%>
						<%--<img src="http://119.23.77.220/images/cat.jpg" data-gtm-event="featured content contributor">--%>
					<%--</a>--%>
					<%--<div class="name">--%>
						<%--<a href="/contributor/chrystl_sanchez/" data-gtm-event="featured content contributor">杰克马</a>--%>
					<%--</div>--%>
					<%--<div class="year">Contributed this</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
	<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>



</div>
	<div class="page_nav"></div>
</section>
<script type="text/javascript">
	$(function(){
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
		showUser();
        showArticle(1);
	});
    function showUser(){
        //清空 .user_menu div里面的东西
        $(".user_menu").empty();
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);

		if(userEntity != null){
			var a_user = $("<a></a>").addClass("dropdown-toggle").attr("href","#").attr("data-toggle","dropdown")
				.attr("role","button").attr("aria-haspopup","true").attr("aria-expanded","false").append(userEntity.nickname)
				.append($("<span></span>").addClass("caret"));
			var a_ul = $("<ul></ul>").addClass("dropdown-menu").append($("<li></li>").append($("<a></a>").attr("href","personal.jsp").append("个人中心")))
				.append($("<li></li>").addClass("divider").attr("role","separator"))
				.append($("<li></li>").append($("<a></a>").append("退出登录").attr("id","a_logout").attr("href","logout").attr("onclick","removeSession()")));
			$("<span></span>").append(a_user).append(a_ul).appendTo(".user_menu");
		}else if(userEntity ==null){
		    //用户上一次登录时记住我，此时用户无需再次登录，需要将信息再次存入sessionStorage
            $.ajax({
                url: "${APP_PATH}/user",
                type: "GET",
                success: function(result){
                    if(result.code == 100){
                        //将用户信息放入 sessionStorage 中
                        sessionStorage.setItem('userInfo',JSON.stringify(result.extend.user));
                        var a_user = $("<a></a>").addClass("dropdown-toggle").attr("href","#").attr("data-toggle","dropdown")
                            .attr("role","button").attr("aria-haspopup","true").attr("aria-expanded","false").append(result.extend.user.nickname)
                            .append($("<span></span>").addClass("caret"));
                        var a_ul = $("<ul></ul>").addClass("dropdown-menu").append($("<li></li>").append($("<a></a>").attr("href","personal.jsp").append("个人中心")))
                            .append($("<li></li>").addClass("divider").attr("role","separator"))
                            .append($("<li></li>").attr("id","a_logout").append($("<a></a>").append("退出登录").attr("href","logout").attr("onclick","removeSession()")));
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
    }
    function removeSession(){
        sessionStorage.removeItem("userInfo");
	}
	function showArticle(page){
        var size = 12;
        $.ajax({
			url: "${APP_PATH}/article/all?page="+page+"&size="+size,
			type: "GET",
			success: function(result){
			    console.log(result);
                buildArticleTable(result);
                build_page_nav(result);
			}
		});
	}



	function buildArticleTable(result){
	    $(".art_list").empty();
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
			$(".art_list").append(art_box);
		});
	}

    function build_page_nav(result){
        $(".page_nav").empty();
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
        navEle.appendTo(".page_nav");
    }
    function to_detail(artId){
        window.location.href = "detail.jsp?artId="+artId;
    }
</script>
</body>
</html>