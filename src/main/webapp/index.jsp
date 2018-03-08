<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h2>项目初始化</h2>
<shiro:user>
	欢迎<shiro:principal /> 登录<br/>
</shiro:user>
<a href="user.jsp">User Page</a><br/>
<a href="admin.jsp">Admin Page</a><br/>
<a href="shiro/logout">退出</a>

<script type="text/javascript">

    $(function(){
        //去首页
        console.log('hello');
        getUser();
    });

    function getUser(){
        $.ajax({
            url: "${APP_PATH}/users",
            type: "get",
            success: function(result){
                console.log("测试"+result);
            }
        });
    }
</script>

</body>
</html>
