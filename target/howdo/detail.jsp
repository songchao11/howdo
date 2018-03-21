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
    <script src="https://cdn.bootcss.com/jquery/1.5.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="static/js/userinfo.js"></script>

    <link href="static/time/css/lyz.calendar.css" rel="stylesheet" type="text/css" />

    <script src="static/time/js/lyz.calendar.min.js" type="text/javascript"></script>


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
            width: 300px;
            margin-left: 130px;
            height: 500px;
            position:fixed;
            background-color: white;
        }
        .right_content{
            width: 760px;
            height: 670px;
            margin-top: 85px;
            margin-left: 448px;
            float: left;
            background-color: white;
        }
        .person_info{
            border-bottom: 1px solid #f5f5f5;
            margin-left: 15px;
            font-size: 14px;
            width: 270px;
        }
        .person_img{
            /*border:1px solid red;*/
            width: 270px;
            height: 100px;
            margin-left: 15px;
            border-bottom: 1px solid #f5f5f5;
        }
        .p_img{
            width: 60px;
            height: 60px;
            margin-left: 5px;
            margin-top: 10px;
            float: left;
            /*border:1px solid black;*/
        }
        .p_info{
            /*border:1px solid red;*/
            width: 190px;
            height: 80px;
            float: left;
            margin-left: 10px;
            margin-top: 16px;
        }
        .p_info h3{
            font-weight: bold;
        }
        .attention_btn button{
            width: 63px;
            height: 30px;
            border-color: #0063c6;
            margin-top: 5px;
            color: #0063c6;
        }
        .info_number_box{
            width: 270px;
            height: 80px;
            margin-left: 15px;
            border-bottom: 1px solid #f5f5f5;
        }
        .original{
            width: 50px;
            height: 60px;
            float: left;
            margin-left: 15px;
            margin-top: 15px;
        }
        .info_t{
            text-align: center;
            color: #788087;
        }
        .s_original{
            text-align: center;
            color: #000;
            font-weight: bold;
        }
        .s_fans{
            text-align: center;
            color: #000;
            font-weight: bold;
        }
        .s_like{
            text-align: center;
            color: #000;
            font-weight: bold;
        }
        .s_comment{
            text-align: center;
            color: #000;
            font-weight: bold;
        }
        .information{
            width: 270px;
            height: 280px;
            margin-left: 17px;
            margin-top: 25px;
        }
        .info_one{
            height: 60px;
            margin-bottom: 10px;
        }
        .info_one_sex{
            height: 60px;
            width:134px;
            float: left;
        }
        .info_one_age{
            height: 60px;
            width:134px;
            float: left;
        }
        .info_two{
            height: 60px;
            margin-bottom: 10px;
        }
        .info_two_constellation{
            height: 60px;
            width:134px;
            float: left;
        }
        .info_two_address{
            height: 60px;
            width:134px;
            float: left;
        }
        .info_three{
            height: 60px;
        }
        .content{
            width: 760px;
            background-color: white;
        }
        .title{
            width: 680px;
            height: 70px;
            /*border:1px solid red;*/
            margin-left: 55px;
            margin-top: 25px;
        }
        .title h1{
            font-weight: bold;
            font-size: 20px;
            color: #000;
        }
        .article_manage{
            width: 760px;
            height: 25px;
            border-bottom: 1px solid #f4f4f4;
        }
        .article_manage span{
            font-size: 14px;
        }
        .article_manage_time{
            margin-left: 30px;
        }
        #article_manage_read{
            margin-left: 250px;
        }
        #article_manage_comment{
            margin-left: 15px;
        }
        #collect{
            margin-left: 15px;
        }
        #praise{
            margin-left: 15px;
        }
        .category{
            height: 40px;
            border-bottom: 1px solid #f4f4f4;
        }
        #cate_tab{
            margin-left: 30px;
            margin-top: 10px;
        }
        .cate_txt{
            margin-left: 30px;
        }
        .htmledit_views{
            margin-left: 30px;
            margin-top: 10px;
        }
        .comment_input{
            border-top: 1px solid #f4f4f4;
            margin-top: 10px;
            height: 155px;
            border-bottom: 1px solid #f4f4f4;
        }
        .comment_input span img{
            width: 40px;
            height: 40px;
            margin-left: 30px;
            margin-top: -110px;
        }
        #comment_content{
            width: 650px;
            height: 80px;
            margin-top: 20px;
        }
        #comment_btn{
            margin-left: 641px;
        }
        .comment_list{
            width:760px;
            margin-top: 5px;
            border-bottom:1px solid #f4f4f4;
        }
        .comment_list_top{
            margin-left: 30px;
        }
        .comment_list_top img{
            width: 30px;
            height: 30px;
        }
        .top_date{
            margin-left: 350px;
            font-size: 14px;
        }
        .comment_list_botton{
            margin-left: 30px;
        }
        .botton_txt{
            font-size: 14px;
            margin-left: 36px;
        }
        .top_btn{
            font-size: 14px;
            margin-left: 15px;
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
    <div class="person_info">个人资料</div>
    <div class="person_img">
        <div class="p_img">
            <a><img src="http://119.23.77.220/images/cat.jpg" class="img-circle" /></a>
        </div>
        <div class="p_info">
            <h3 id="p_info_nickname"></h3>
            <div class="attention_btn">
                <%--<button type="button" class="btn btn-default">关注</button>--%>
            </div>
        </div>
    </div>
    <div class="info_number_box">
        <div class="original">
            <div class="info_t">原创</div>
            <div class="s_original">130</div>
        </div>
        <div class="original">
            <div class="info_t">粉丝</div>
            <div class="s_fans">25</div>
        </div>
        <div class="original">
            <div class="info_t">喜欢</div>
            <div class="s_like">21</div>
        </div>
        <div class="original">
            <div class="info_t">评论</div>
            <div class="s_comment">78</div>
        </div>
    </div>

    <div class="information">
        <div class="info_one">
            <div class="info_one_sex"></div>
            <div class="info_one_age"></div>
        </div>
        <div class="info_two">
            <div class="info_two_constellation"></div>
            <div class="info_two_address"></div>
        </div>
        <div class="info_three">
            
        </div>
    </div>
</div>

<div class="right_content">
    <div class="content">
        <div class="title">
            <h1 class="title_h1"></h1>
        </div>
        <div class="article_manage">
            <span class="article_manage_time">2017年11月16日 15:18:32</span>
            <span class="glyphicon glyphicon-eye-open" id="article_manage_read">5人阅读</span>
            <span class="glyphicon glyphicon-comment" id="article_manage_comment">评论(2)</span>
            <span class="glyphicon glyphicon-star" id="collect">收藏(2)</span>
            <span class="glyphicon glyphicon-thumbs-up" id="praise">点赞(2)</span>
        </div>
        <div class="category">
            <span class="glyphicon glyphicon-th-list" id="cate_tab">分类:</span>
            <span class="cate_txt">开发环境搭建</span>
        </div>
        <div class="htmledit_views">

        </div>
        <div class="comment_input">
            <span><img src="http://119.23.77.220/images/cat.jpg" class="img-circle" /></span>
            <textarea id="comment_content"></textarea>
            <button type="button" class="btn btn-default" id="comment_btn">发表评论</button>
        </div>

        <div class="comment_list">
            <div class="comment_list_top">
                <img src="http://119.23.77.220/images/cat.jpg"/>
                <span>尼古拉斯_赵四</span>
                <span class="top_date">2016-02-05 09:44发表</span>
                <span class="top_btn" id="top_btn_1"><a>回复</a></span>
            </div>
            <div class="comment_list_botton">
                <span class="botton_txt">老子今天不上班，爽翻</span>
            </div>
            <div class="reply_input">
                <input type="text"><button>回复</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        showUser();
        showPage();
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
    function showPage(){
        var userInfo = sessionStorage.getItem('userInfo');
        userEntity = JSON.parse(userInfo);
        var yourId = userEntity.id;//登录人的id
        var v = parseUrl();//解析所有参数
        var artId = v['artId'];//就是你要的结果
        $.ajax({
            url: "${APP_PATH}/article/user/"+artId+"/"+yourId,
            type: "GET",
            success: function(result){
                console.log(result);
                showArticle(result);
                showUserInfo(result);
            }
        });
    }
    function showArticle(result) {
        console.log(result.extend.article.content);
        $(".htmledit_views").empty();
        $(".htmledit_views").html(result.extend.article.content);
        $(".title_h1").empty();
        $(".title_h1").append(result.extend.article.title);
        $("#article_manage_read").empty();
        $("#article_manage_read").append(result.extend.article.readNum+"人阅读");
        $("#article_manage_comment").empty();
        $("#article_manage_comment").append("评论("+result.extend.article.commentNum+")");
        $("#collect").empty();
        $("#collect").append("收藏("+result.extend.article.collectNum+")");
        $("#praise").empty();
        $("#praise").append("点赞("+result.extend.article.praiseNum+")");
        $(".cate_txt").empty();
        $(".cate_txt").append(result.extend.article.category);
        $(".article_manage_time").empty();
        $(".article_manage_time").append(result.extend.article.lastUpdateDate);
    }//<button type="button" class="btn btn-default">关注</button>
    function showUserInfo(result){
        $("#p_info_nickname").empty();
        $("#p_info_nickname").append(result.extend.user.nickname);
        if(result.extend.user.followed == "空"){
            $(".attention_btn").empty();
        }else if(result.extend.user.followed == "关注"){
            $("<button></button>").addClass("btn btn-default").attr("type","button").append("关注").appendTo(".attention_btn");
        }else if(result.extend.user.followed == "已关注"){
            $("<button></button>").addClass("btn btn-default").attr("type","button").append("关注").appendTo(".attention_btn");
        }
        if(result.extend.user.sex != null){
            $(".info_one_sex").empty();
            $(".info_one_sex").append("性别:  "+result.extend.user.sex);
        }else{
            $(".info_one_sex").empty();
            $(".info_one_sex").append("性别:  暂无");
        }
        if(result.extend.user.age != null){
            $(".info_one_age").empty();
            $(".info_one_age").append("年龄:  "+result.extend.user.age);
        }else{
            $(".info_one_age").empty();
            $(".info_one_age").append("年龄:  暂无");
        }
        if(result.extend.user.constellation != null){
            $(".info_two_constellation").empty();
            $(".info_two_constellation").append("星座:  "+result.extend.user.constellation);
        }else{
            $(".info_two_constellation").empty();
            $(".info_two_constellation").append("星座:  暂无");
        }
        if(result.extend.user.address != null){
            $(".info_two_address").empty();
            $(".info_two_address").append("居住地:  "+result.extend.user.address);
        }else{
            $(".info_two_address").empty();
            $(".info_two_address").append("居住地:  暂无");
        }
        if(result.extend.user.sex != null){
            $(".info_three").empty();
            $(".info_three").append("个性签名:  "+result.extend.user.signature);
        }else{
            $(".info_three").empty();
            $(".info_three").append("个性签名:  暂无");
        }
    }
</script>
</body>
</html>
