<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的文章</title>
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
	.article_search{
		margin-top: -33px;
		background: #f4f4f4;
		float: right;
		margin-right: 30px;
		width: 280px;
	}
	.article_search input{
		background: #f4f4f4;
		border-radius:4px;
		width: 250px;
	}
	.article_content{
		width:1017px;
		margin-left: 25px;
		margin-top: 10px;
		height: 480px;
	}
	.article_list_item{
		height: 75px;
		border-bottom:1px dashed #DDDDDD;
		width:1017px;
	}
	.article_list_item_title{
		margin-top: 20px;
		margin-left: 15px;
		/*border:1px solid black;*/
		height:30px;
	}
	.article_list_item_title p a{
		font-size: 18px;
		color: #4f4f4f;
		margin-bottom: 0;
	}
	.article_list_item_info{

		margin-left: 15px;
		/*border:1px solid red;*/
		height: 30px;
		font-size:12px;
	}
	.item_info_left{
		float: left;
	}
	.item_info_left span{
		margin-right: 15px;
	}
	.item_info_right{
		float: right;
	}
	.item_info_right span{
		margin-right: 10px;
	}
	.article_page{
		margin-top: -20px;
		text-align: center;
	}
	.shadow{
		background-color: #f1f1f1;
	}
	.no_content{
		margin-top: 130px;
		margin-left: 315px;
		font-family: '微软雅黑', 'Microsoft Yahei';
		font-size: 24px;
	}
</style>
</head>
<body >

<!-- 导航栏 start -->
<header id="Header" data-section="header" class="header-non-responsive js-headroom">
<section class="header-section">
<div class="container-fluid container-non-responsive">
<div class='fl'>
<a href="main.jsp" class="logo-container"><img src="//v5-static.ehowcdn.com/media/images/logos/logov3.png" alt="eHow Logo" class="logo" data-gtm-event="nav header" data-gtm-info="logo"/></a>
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
	  <li role="presentation" class="active"><a href=""><span class="glyphicon glyphicon-book"></span>&nbsp;&nbsp;我的文章</a></li>
	  <li role="presentation"><a href="write.jsp"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;写&nbsp;文&nbsp;章</a></li>
	  <li role="presentation"><a href="information.jsp"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;个人信息</a></li>
	</ul>
</div>
<div class="right_content">
	
	<div class="article_management">
		<span>|</span> 文章管理
	</div>
	<div class="article_tabs">

	</div>
	<div class="article_content">

	</div>
	<%--分页--%>
	<div class="article_page">

	</div>
	
</div>

<script type="text/javascript">
	$(function(){
		showUser();
        showArticleList(1,"Y");
        showArticleTotal();
	});
	function showArticleList(page,isPublish){
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
	    var userId = userEntity.id;
	    var size = 5;
	    var flag = 'not_search';
	    $.ajax({
			url: "${APP_PATH}/articles/"+userId+"/"+page+"/"+size+"/"+isPublish,
			type: "GET",
			success: function(result){
			    console.log(result);
			    if(result.extend.pageInfo.pages != 0){
                    //显示文章列表
                    build_article_table(result);
                    //显示分页条
                    build_page_nav(result,isPublish,flag);
				}else{
			        $(".article_content").empty();
			        $(".article_content").append($("<div></div>").addClass("no_content").append("暂无文章!"));
				}
			}
		});
	}
	function build_article_table(result){
        $(".article_content").empty();
        var articles = result.extend.pageInfo.list;
        var current_page = result.extend.pageInfo.pageNum;
        $.each(articles, function(index, item){
            var item_title = $("<div></div>").addClass("article_list_item_title")
                .append($("<p></p>").append($("<a></a>").attr("href","#").attr("onclick","to_detail("+item.id+")").append(item.title)));
            if(item.isComment == 'Y'){
                var item_info = $("<div></div>").addClass("article_list_item_info")
                    .append($("<div></div>").addClass("item_info_left").append($("<span></span>").append(item.lastUpdateDate))
                        .append($("<span></span>").addClass("glyphicon glyphicon-eye-open").append(item.readNum))
                        .append($("<span></span>").addClass("glyphicon glyphicon-comment").append(item.commentNum)))
                    .append($("<div></div>").addClass("item_info_right").append($("<span></span>").append($("<a></a>").attr("href","#").attr("onclick","to_write("+item.id+")").append("编辑")))
                        .append($("<span></span>").attr("id","allow_ban_"+item.id).append($("<a></a>").attr("href","#").append("禁止评论").attr("onclick","ban_comment("+item.id+")")))
                        .append($("<span></span>").append($("<a></a>").attr("href","#").append("删除").attr("onclick","delete_article("+item.id+","+current_page+")"))));
			}else if(item.isComment == 'N'){
                var item_info = $("<div></div>").addClass("article_list_item_info")
                    .append($("<div></div>").addClass("item_info_left").append($("<span></span>").append(item.lastUpdateDate))
                        .append($("<span></span>").addClass("glyphicon glyphicon-eye-open").append(item.readNum))
                        .append($("<span></span>").addClass("glyphicon glyphicon-comment").append(item.commentNum)))
                    .append($("<div></div>").addClass("item_info_right").append($("<span></span>").append($("<a></a>").attr("href","#").attr("onclick","to_write("+item.id+")").append("编辑")))
                        .append($("<span></span>").attr("id","allow_ban_"+item.id).append($("<a></a>").attr("href","#").append("允许评论").attr("onclick","allow_comment("+item.id+")")))
                        .append($("<span></span>").append($("<a></a>").attr("href","#").append("删除").attr("onclick","delete_article("+item.id+","+current_page+")"))));
			}

            $("<div></div>").addClass("article_list_item").append(item_title).append(item_info).appendTo(".article_content");
        });
	}
	function showArticleTotal(){
	    $(".article_tabs").empty();
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
        var page = 1;
	    $.ajax({
			url: "${APP_PATH}/article/total/"+userEntity.id,
			type: "GET",
			success: function(result){
				var li1 = $("<li></li>").attr("onclick","switchover_all()").append($("<a></a>").attr("id","tab_1").addClass("shadow").append("全部("+result.extend.articleTotal+")"));
                var li2 = $("<li></li>").attr("onclick","switchover_article()").append($("<a></a>").attr("id","tab_2").append("已发表("+result.extend.articleTotal+")"));
                var li3 = $("<li></li>").attr("onclick","switchover_draft()").append($("<a></a>").attr("id","tab_3").append("草稿箱("+result.extend.draftTotal+")"));
				var div_search = $("<div></div>").addClass("article_search").append($("<input/>").attr("type","input").attr("id","search_input").attr("onkeydown","entersearch()"))
					.append($("<span></span>").attr("id","search_span").attr("onclick","search("+page+")").addClass("glyphicon glyphicon-search"));
				var top = $("<ul></ul>").addClass("nav nav-pills").attr("id","pills-tab").attr("role","tablist").append(li1).append(li2).append(li3);
				$("<span></span>").append(top).append(div_search).appendTo(".article_tabs");
			}
		});
	}

	function build_page_nav(result, isPublish, flag){
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
                if(flag == 'not_search'){
                    showArticleList(1,isPublish);
				}else if(flag == 'search'){
                    search(1);
				}

            });
            prePageLi.click(function(){
                if(flag == 'not_search'){
                    showArticleList(result.extend.pageInfo.pageNum-1, isPublish);
                }else if(flag == 'search'){
                    search(result.extend.pageInfo.pageNum-1);
                }
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                if(flag == 'not_search'){
                    alert(flag);
                    showArticleList(result.extend.pageInfo.pageNum+1, isPublish);
                }else if(flag == 'search'){
                    alert(flag);
                    search(result.extend.pageInfo.pageNum+1);
                }
            });
            lastPageLi.click(function(){
                if(flag == 'not_search'){
                    showArticleList(result.extend.pageInfo.pages, isPublish);
                }else if(flag == 'search'){
                    search(result.extend.pageInfo.pages);
                }
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
                if(flag == 'not_search'){
                    showArticleList(item, isPublish);
                }else if(flag == 'search'){
                    search(item);
                }
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        //将ul添加到nav中
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo(".article_page");
	}
	function allow_comment(artId){
	    var isComment = 'Y';
	    $.ajax({
            url: "${APP_PATH}/article/isComment",
			type: "PUT",
            data: {"id": artId, "isComment": isComment},
            dataType: 'json',
			success: function(result){
                $("#allow_ban_"+artId).empty();
                $("<a></a>").attr("href","#").append("禁止评论").attr("onclick","ban_comment("+result.extend.article.id+")").appendTo("#allow_ban_"+artId);
			}
		});
	}
    function ban_comment(artId){
        var isComment = 'N';
        $.ajax({
            url: "${APP_PATH}/article/isComment",
            type: "PUT",
            data: {"id": artId, "isComment": isComment},
            dataType: 'json',
            success: function(result){
                $("#allow_ban_"+artId).empty();
                $("<a></a>").attr("href","#").append("允许评论").attr("onclick","allow_comment("+result.extend.article.id+")").appendTo("#allow_ban_"+artId);
            }
        });
    }
	function delete_article(artId, current_page){
	    if(confirm("确认删除吗?")){
			$.ajax({
				url: "${APP_PATH}/article/"+artId,
				type: "DELETE",
				success: function(result){
				    if(result.code == 100){
                        showArticleList(current_page);
					}
				}
			});
		}
	}
	function switchover_all(){
	    $("#tab_2").removeClass("shadow");
        $("#tab_3").removeClass("shadow");
		$("#tab_1").addClass("shadow");
        showArticleList(1, "Y");
	}
    function switchover_article(){
        $("#tab_1").removeClass("shadow");
        $("#tab_3").removeClass("shadow");
        $("#tab_2").addClass("shadow");
        showArticleList(1, "Y");
    }
    function switchover_draft(){
        $("#tab_1").removeClass("shadow");
        $("#tab_2").removeClass("shadow");
        $("#tab_3").addClass("shadow");
        showArticleList(1, "N");
    }
    // 按Enter键,执行事件
    function entersearch(){
        var event = window.event || arguments.callee.caller.arguments[0];
        if (event.keyCode == 13)
        {
            search(1);
        }
    }
    function search(page){
        var keyword = $("#search_input").val();
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
        var userId = userEntity.id;
        var size = 1;
        var flag = 'search';
        var isPublish = 'Y';
        $.ajax({
            url: "${APP_PATH}/articles/search/"+keyword+"/"+userId+"/"+page+"/"+size,
            type: "GET",
            success: function(result){
                console.log(result);
                //显示文章列表
                build_article_table(result);
                //显示分页条
                build_page_nav(result,isPublish,flag);
            }
        });
	}
	function to_detail(artId){
//        window.location.href = "detail.jsp?artId="+artId;
		window.open("detail.jsp?artId="+artId);
	}
	function to_write(artId){
	    window.location.href = "write.jsp?artId="+artId;
	}
</script>
</body>
</html>