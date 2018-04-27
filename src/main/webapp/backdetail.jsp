<%--
  Created by IntelliJ IDEA.
  User: songchao
  Date: 2018/4/24
  Time: 23:04
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
        html{
            background-color: #f4f4f4;
        }
        .article{
            border:1px solid black;
            width:900px;
            height: 660px;
            margin: 70px auto;
            background-color: white;
        }
        .article_title{
            text-align: center;
            margin-top: 5px;
            font-size: 24px;
        }
        .article_content{
            width: 720px;
            margin-left: 90px;
        }
        .ban_btn{
            text-align: center;
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
<div class="article">
    <div class="article_title">

    </div>
    <div class="article_content"></div>
    <div class="ban_btn">

    </div>
</div>

<script type="text/javascript">
    $(function(){
        showArticle();
    });
    //获取跳转页面携带过来的参数
    function parseUrl(){
        var url=location.href;
        var i=url.indexOf('?');
        if(i==-1)return;
        var querystr=url.substr(i+1);
        var arr1=querystr.split('&');
        var arr2=new Object();
        for  (i in arr1){
            var ta=arr1[i].split('=');
            arr2[ta[0]]=ta[1];
        }
        return arr2;
    }
    function showArticle(){
        var v = parseUrl();//解析所有参数
        var artId = v['artId'];//就是你要的结果
        $.ajax({
            url: "${APP_PATH}/article/"+artId,
            type: "GET",
            success: function(result){
                console.log(result);
                $(".article_title").append(result.extend.article.title);
                $(".article_content").html(result.extend.article.content);
                if(result.extend.article.enableFlag == "Y"){
                    var enable = "N";
                    $("<a></a>").append("封禁").attr("href","#").attr("onclick", "banArticle("+artId+")").appendTo(".ban_btn");
                }else if(result.extend.article.enableFlag == "N"){
                    var enable = "Y";
                    $("<a></a>").append("解封").attr("href","#").attr("onclick", "deblocking("+artId+")").appendTo(".ban_btn");
                }
            }
        });
    }
    function banArticle(artId){
        var enable = "N";
        $.ajax({
            url: "${APP_PATH}/article/ban/"+artId+"/"+enable,
            type: "PUT",
            success: function(result){
                $(".ban_btn").empty();
                $("<a></a>").append("解封").attr("href","#").attr("onclick", "deblocking("+artId+")").appendTo(".ban_btn");
            }
        });
    }
    function deblocking(artId){
        var enable = "Y";
        $.ajax({
            url: "${APP_PATH}/article/ban/"+artId+"/"+enable,
            type: "PUT",
            success: function(result){
                $(".ban_btn").empty();
                $("<a></a>").append("封禁").attr("href","#").attr("onclick", "banArticle("+artId+")").appendTo(".ban_btn");
            }
        });
    }
</script>

</body>
</html>
