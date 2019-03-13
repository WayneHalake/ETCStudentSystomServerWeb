<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>皇家理工 • ECT学员社区信息管理系统 | menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/ddaccordion.js"></script>
	<script type="text/javascript">
	ddaccordion.init({
		headerclass: "submenuheader", //Shared CSS class name of headers group
		contentclass: "submenu", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
		mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
	</script>
  </head>
  
<body>
    <div class="sidebarmenu">
    			<a class="menuitem submenuheader" href="">用户管理</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="./UserServlet?action=student" target="mainFrame">学员信息管理</a></li>
		                <li><a href="./UserServlet?action=teacher" target="mainFrame">教员信息管理</a></li>
		                <li><a href="./UserServlet?action=admister" target="mainFrame">管理员用户管理</a></li>
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="" >文章帖子管理</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="./ArticleServlet?action=showall&type=article" target="mainFrame">查看文章</a></li>
		                <li><a href="./ArticleServlet?action=showall&type=note" target="mainFrame">查看帖子</a></li>
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="">帖子管理</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="pages/goodSale.jsp" target="mainFrame">查看帖子</a></li>
		                <li><a href="RestOrderServlet?do=getrest" target="mainFrame">修改帖子</a></li>
		            </ul>
		        </div>
    			<a class="menuitem submenuheader" href="goodCounter.html">统计分析</a>
		        <div class="submenu">
		            <ul>
		                <li><a href="GoodInventoryServlet?f=inventorInfo&pageSize=5" target="mainFrame">进销存报表</a></li>
		                <li><a href="GoodCarrySearchServlet?f=carryInfo&p=1&pageSize=5" target="mainFrame">结转查询</a></li>
		                <li><a href="GoodSellTotalServlet?f=sellInfo&p=1&pageSize=5" target="mainFrame">销售汇总</a></li>
		            </ul>
		        </div>
    </div>		
</body>
</html>
