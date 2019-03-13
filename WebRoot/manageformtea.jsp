<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<h2>信息列表</h2>
		<div class="top-input">
			<form action="" name="search" method="post">
				<table id="top-table">
					<tbody>
						<tr>
							<td><span>教员姓名</span> <select name="" class="">
									<option>中华</option>
							</select></td>
							<td><span>教员编号</span> <input type="text" class="textfield" />
							</td>

							<td>
								<!-- Search -->
								<div class="search">
									<input type="text" class="field" /> <input type="submit"
										class="button" value="GO" />
								</div> <!-- / Search -->
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<table id="rounded-corner">
			<thead>
				<tr>
					<th scope="col" class="rounded-company">全选<input
						type="checkbox" name="input" /></th>
					<th scope="col" class="rounded">教员姓名</th>
					<th scope="col" class="rounded">教员编号</th>
					<th scope="col" class="rounded">入职时间</th>
					<th scope="col" class="rounded">性别</th>
					<th scope="col" class="rounded">辞职时间</th>
					<th scope="col" class="rounded">修改</th>
					<th scope="col" class="rounded-q4">删除</th>
				</tr>
			</thead>
			<tbody>
				<!-- 单条记录 -->
				<c:forEach items="${teacher}" var="t">
					<tr>
						<td><input type="checkbox" name="" /></td>
						<td>${t.username }</td>
						<td>${t.usernum }</td>
						<td>${t.intake }</td>
						<td>${t.gender }</td>
						<td>${t.outtake }</td>
						
						<td><a href="./UserServlet?action=finduser&tablename=teacher&userid=${t.userid }"><img src="images/user_edit.png"
								alt="" title="" border="0" /></a></td>
						<td><a href="./UserServlet?action=delete&tablename=teacher&userid=${t.userid }" class="ask"><img src="images/trash.png"
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
					class="bt_green">显示全部教员</a> <a href="#" class="bt_green">批 量 删
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