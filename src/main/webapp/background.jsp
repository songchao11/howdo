<%--
  Created by IntelliJ IDEA.
  User: songchao
  Date: 2018/4/24
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>

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
        body{
            background-color: #f4f4f4;
        }
        .user_menu {
            width: 125px;
            height: 30px;
            float: right;
            /*margin-top: -25px;*/
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
        .article_list{
            /*border:1px solid black;*/
            width:900px;
            height: 660px;
            margin: 70px auto;
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
            width:865px;
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
            width:865px;
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
<body>

<!-- 导航栏 start -->
<header id="Header" data-section="header" class="header-non-responsive js-headroom">
    <section class="header-section">
        <div class="container-fluid container-non-responsive">
            <div class='fl'>
                <a href="" class="logo-container"><img src="//v5-static.ehowcdn.com/media/images/logos/logov3.png" alt="eHow Logo" class="logo" data-gtm-event="nav header" data-gtm-info="logo"/></a>
            </div>

            <div class="user_menu">

            </div>
        </div>
    </section>
</header>
<!-- 导航栏 end -->
<div class="article_list">

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

    function showUser(){
        //清空 .user_menu div里面的东西
        $(".user_menu").empty();
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);

        if(userEntity != null){
            var a_user = $("<a></a>").addClass("dropdown-toggle").attr("href","#").attr("data-toggle","dropdown")
                .attr("role","button").attr("aria-haspopup","true").attr("aria-expanded","false").append(userEntity.nickname)
                .append($("<span></span>").addClass("caret"));
            var a_ul = $("<ul></ul>").addClass("dropdown-menu")
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
                        var a_ul = $("<ul></ul>").addClass("dropdown-menu")
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

    function showArticleList(page,enable){
        var size = 5;
        var flag = 'not_search';
        $.ajax({
            url: "${APP_PATH}/articles/admin/"+enable+"/"+page+"/"+size,
            type: "GET",
            success: function(result){
                console.log(result);
                if(result.extend.pageInfo.pages != 0){
                    //显示文章列表
                    build_article_table(result);
                    //显示分页条
                    build_page_nav(result,enable,flag);
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

            var item_info = $("<div></div>").addClass("article_list_item_info")
                .append($("<div></div>").addClass("item_info_left").append($("<span></span>").append(item.lastUpdateDate)))
                .append($("<div></div>").addClass("item_info_right").append($("<span></span>").append($("<a></a>").attr("href","#").attr("onclick","to_detail("+item.id+")").append("查看"))));

            $("<div></div>").addClass("article_list_item").append(item_title).append(item_info).appendTo(".article_content");
        });
    }
    function showArticleTotal(){
        $(".article_tabs").empty();
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
        var page = 1;
        $.ajax({
            url: "${APP_PATH}/article/total/admin",
            type: "GET",
            success: function(result){
                var li1 = $("<li></li>").attr("onclick","switchover_all()").append($("<a></a>").attr("id","tab_1").addClass("shadow").append("未封禁("+result.extend.noBan+")"));
                var li2 = $("<li></li>").attr("onclick","switchover_article()").append($("<a></a>").attr("id","tab_2").append("已封禁("+result.extend.baned+")"));
//                var li3 = $("<li></li>").attr("onclick","switchover_draft()").append($("<a></a>").attr("id","tab_3").append("草稿箱("+result.extend.draftTotal+")"));
                var div_search = $("<div></div>").addClass("article_search").append($("<input/>").attr("type","input").attr("id","search_input").attr("onkeydown","entersearch()"))
                    .append($("<span></span>").attr("id","search_span").attr("onclick","search("+page+")").addClass("glyphicon glyphicon-search"));
                var top = $("<ul></ul>").addClass("nav nav-pills").attr("id","pills-tab").attr("role","tablist").append(li1).append(li2);
                $("<span></span>").append(top).append(div_search).appendTo(".article_tabs");
            }
        });
    }

    function build_page_nav(result, enable, flag){
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
                    showArticleList(1,enable);
                }else if(flag == 'search'){
                    search(1);
                }

            });
            prePageLi.click(function(){
                if(flag == 'not_search'){
                    showArticleList(result.extend.pageInfo.pageNum-1, enable);
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
                    showArticleList(result.extend.pageInfo.pageNum+1, enable);
                }else if(flag == 'search'){
                    alert(flag);
                    search(result.extend.pageInfo.pageNum+1);
                }
            });
            lastPageLi.click(function(){
                if(flag == 'not_search'){
                    showArticleList(result.extend.pageInfo.pages, enable);
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
                    showArticleList(item, enable);
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
        var size = 1;
        var flag = 'search';
        var isPublish = 'Y';
        $.ajax({
            url: "${APP_PATH}/articles/search/admin/"+keyword+"/"+page+"/"+size,
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
        window.location.href = "backdetail.jsp?artId="+artId;
//        window.open("backdetail.jsp?artId="+artId);
    }
</script>

</body>
</html>
