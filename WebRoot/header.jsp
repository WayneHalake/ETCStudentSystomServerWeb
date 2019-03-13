<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>皇家理工 • ECT学员社区信息管理系统 | header</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
<body>
	<div class="header">
        <div class="logo" align="center"><a href="index.jsp"><img src="images/logo.png" alt="" title="" border="0" /></a></div>
        <div class="header_menu">
            <div class="header_left">管理员&nbsp; | <a href="pages/userUpate.jsp" target="mainFrame">修改个人资料</a></div>
            <div class="header_center">2013-01-10&nbsp; 10:00&nbsp; 星期四</div>
			<div class="header_right">
				<a href="welcome.jsp" target="mainFrame" class="home">首页</a> | 
				<!--
				<a href="#" class="prev">前进</a> | 
				<a href="#" class="next">后退</a> | 
				-->
				<a href="#loginout" target="_top" class="logout">退出</a>
			</div>
        </div>
    </div>
</body>
</html>
