<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.etc.serverse.UserServlet" %>
<html>
  <head>
    
    <title>皇家理工 • ECT学员社区信息管理系统 | Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="css/login.css" rel="stylesheet" type="text/css" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		function isEmprotyUserName(){
			if(document.getElementById("userName").value==""){
				alert("请输入用户名！！！");
				return false;
			}
			return true;
		}
		function isEmprotyUserPwd(){
			if(document.getElementById("userPwd").value==""){
				alert("请输入密码！！！");
				return false;
			}
			return true;
		}
		
		function checkUserNP(){
			 return isEmprotyUserName()&&isEmprotyUserPwd();
		}
	</script>
	
  </head>
  
  <body>
	<div id="login_container">
		<div id="innerlogin">
            <form action="./UserServlet" method="post" onsubmit="return checkUserNP()">
                <input name="action" id="action" type="hidden" value="login" />
                <input name="userName" id="userName" type="text" class="logininput" value="" />
                <input name="userPwd" id="userPwd" type="password" class="logininput" value=""/>
                <input name="" type="submit" class="loginbtn"/>
            </form>
		</div>
    </div>
    <div class="login_footer">皇家理工 &#8226; ECT学员社区信息管理系统 | Powered by <a href="#">WFamily</a></div>
  </body>
</html>
