<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>皇家理工 • ECT学员社区信息管理系统 | manageform</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
</script>
</head>

<body>
	<div class="right_content">
		<h2>文章列表</h2>
		<table id="rounded-corner">
			<thead>
				<tr>
					<th scope="col" class="rounded-company">全选<input
						type="checkbox" name="input" /></th>
					<th scope="col" class="rounded">文章名称</th>
					<th scope="col" class="rounded">发布时间</th>
					<th scope="col" class="rounded">发布人</th>
					<th scope="col" class="rounded">发布人id</th>
					<th scope="col" class="rounded">内容</th>
					<th scope="col" class="rounded-q4">删除</th>
				</tr>
			</thead>
			<tbody>
				<!-- 单条记录 -->
				<c:forEach items="${articles}" var="art">
					<tr>
						<td><input type="checkbox" name="" /></td>
						<td>${art.articlename}</td>
						<td>${art.publishedtime }</td>
						<td>${art.username }</td>
						<td>${art.userid }</td>
						<td>${art.articlecontent }</td>
						<td><a href="./ArticleServlet?action=delete&type=article&articleid=${art.articleid }" class="ask"><img src="images/trash.png"
								alt="" title="" border="0" /></a></td>
					</tr>
				</c:forEach>
				<!--end 单条记录 -->
			</tbody>

		</table>

		<!-- 页码 + 按钮 -->
		<div class="btns-pagenav">
			<!-- 按钮 -->
			<div class="div-btns">
				<a href="#"
					class="bt_green">显示全文章</a> <a href="#" class="bt_green">批 量 删
					除</a>
			</div>
			<!--end 按钮 -->

			<!-- 页码 -->
			<div class="page-navigator">
				<div class="page-navigator-left">
					每页 <select class="select-short" name="select">
						<option value="0" selected="selected">5</option>
						<option value="1">10</option>
						<option value="2">15</option>
					</select> 条
				</div>
				<div class="page-navigator-right">
					<a href="" class="first">«</a> <a href="" class="prev">‹</a>
					&nbsp;第 1 页&nbsp; &nbsp;共 20 页&nbsp; <a href="" class="next">›</a>
					<a href="" class="last">»</a>
				</div>
			</div>
			<!--End 页码 -->
		</div>
		<!-- / 页码 + 按钮 -->
	</div>
	<div class="clear"></div>
</body>
</html>

