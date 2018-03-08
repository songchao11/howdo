<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <style type="text/css">
	body{
    background: url("static/img/1.jpg");
    animation-name:myfirst;
    animation-duration:12s;
    /*变换时间*/
    animation-delay:4s;
    /*动画开始时间*/
    animation-iteration-count:infinite;
    /*下一周期循环播放*/
    animation-play-state:running;
    /*动画开始运行*/
}
@keyframes myfirst
{
    0%   {background:url(static/img/1.jpg);}
    34%  {background:url(static/img/2.jpg);}
    67%  {background:url(static/img/3.jpg);}
    100% {background:url(static/img/1.jpg);}
}
.form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}
/*阴影*/
.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
input[type="text"],input[type="password"]{padding-left:26px;}
.checkbox{padding-left:21px;}
</style>
</head>
<body>
<div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">LOGIN</h3>
                
                <form action="login" method="post">
	                <div class="col-md-9">
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20" required="required"/>
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8" required="required"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="checkbox">
	                            <input type="checkbox" name="remember" value="1"/>记住我
	                        </label>
	                    </div>
	                    <div class="form-group col-md-offset-9">
	                        <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
	                    </div>
	                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
