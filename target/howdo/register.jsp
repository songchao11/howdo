<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">
	body{
    background: url("http://119.23.77.220/images/201804011522587369432091994.jpg");
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
		0%   {background:url(http://119.23.77.220/images/201804011522587369432091994.jpg);}
		34%  {background:url(http://119.23.77.220/images/201804011522587391910098634.jpg);}
		67%  {background:url(http://119.23.77.220/images/201804011522587406290005025.jpg);}
		100% {background:url(http://119.23.77.220/images/201804011522587369432091994.jpg);}
	}
.form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}
/*阴影*/
.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
input[type="text"],input[type="password"]{padding-left:26px;}
.checkbox{padding-left:21px;}
#error_box{
	color: red;
}
</style>

</head>
<body>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">REGISTER</h3>
	                <div class="col-md-9">
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="用户名" id="username" name="username" autofocus="autofocus"/>
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="密码" id="password1" name="password1" />
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="确认密码" id="password2" name="password2" />
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-envelope fa-lg"></i>
	                            <input class="form-control required" type="text" placeholder="邮箱" id="email" name="email" />
	                    </div>
	                    <div id="error_box"></div>
	                    <div class="form-group col-md-offset-9">
	                        <button type="submit" class="btn btn-success pull-right" name="submit" id="register_btn">注册</button>
	                    </div>
	                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    	$("#register_btn").click(function(){
    		var username = $("#username").val();
    		var password = $("#password1").val();
    		var email = $("#email").val();
	 		if(validate_info()){
	 			$.ajax({
	    			url: "${APP_PATH}/user",
	    			data: {"account": username, "password": password, "email": email},
	    			dataType: "json",
	    			type: "POST",
	    			success: function(result){
	    				if(result.code == 100){
	    					window.location.href = "login.jsp";
	    				}
	    			}
	    		});
	  		}else{
	  			
	  		} 
    	});
    	
    	//账号验证标志
    	var validate_flag = true;
    	
    	$("#username").change(function(){
    		$("#error_box").text("");
    		var username = this.value;
    		console.log(username);
    		$.ajax({
    			url: "${APP_PATH}/account",
    			data: "username="+username,
    			type: "GET",
    			success: function(result){
    			    console.log(result);
    				if(result.code == 100){
    					validate_flag = true;
    					return ;
    				}else if(result.code == 200){
    					validate_flag = false;
    					showError("此账号已存在!");
    					return ;
    				}
    			}
    		});
    	});

    	function checkAccount(){

		}
    	
    	function validate_info(){
    		//判断之前账号是否验证成功
    		if(!validate_flag){
    			return ;
    		}
    		//拿到需要校验的数据，使用正则表达式验证
    		//验证之前先将错误信息去掉
    		$("#error_box").text("");
    		var username = $("#username").val();
    		var password1 = $("#password1").val();
    		var password2 = $("#password2").val();
    		var email = $("#email").val();
    		var regUsername = /(^[a-zA-Z0-9_-]{4,16}$)/;
    		var regPassword = /(^[a-zA-Z0-9_-]{6,}$)/;
    		var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    		if(username == ""){
    			showError("账号不能为空!");
    			return false;
    		}
    		if(!regUsername.test(username)){
    			showError("账号必须是4-16位英文或数字的组合!");
    			return false;
    		}
    		if(password1 == ""){
    			showError("密码不能为空!");
    			return false;
    		}
    		if(!regPassword.test(password1)){
    			showError("密码长度太短，建议6位及以上!");
    			return false;
    		}
    		if(password2 == ""){
    			showError("确认密码不能为空!");
    			return false;
    		}
    		if(password1 != password2){
    			showError("两次输入密码不同!");
    			return false;
    		}
    		if(email == ""){
    			showError("邮箱不能为空!");
    			return false;
    		}
    		if(!regEmail.test(email)){
    			showError("邮箱格式不正确!");
    			return false;
    		}
    		return true;
    	}
    	function showError(msg){
    		$("#error_box").text("");
    		$("#error_box").text(msg);
    	}
    </script>
</body>
</html>