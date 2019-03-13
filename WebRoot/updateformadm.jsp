<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.etc.entity.Users" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>皇家理工 • ECT学员社区信息管理系统 | 修改用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
	
		<form id="userupdate" class="userAdd" action="UserServlet?action=update&tablename=${user.type }" method="post">
			<div class="right_content" align="center">
				<h2>用户信息</h2>
				<table id="input-table" style="width: 40%;">
					<input name="userid" id="" type="hidden" value="${user.userid }" />
					<tbody>
						<tr>
							<td>
								<span class="">用户编号*</span>
							</td>
							<td>
								<input name="usernum" id="" class="info-textfield" type="text" value="${user.usernum }" >
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户姓名*</span>
							</td>
							<td>
								<input name="username" id="" class="info-textfield" type="text" value="${user.username }"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						<tr>
							<td>
								<span class="">用户性别*</span>
							</td>
							<td>
								<span>男</span>
								<input type="radio" name="gender" value="nan" checked/>
								<span>女</span>
								<input type="radio" name="gender" value="nv" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						
						<tr>
							<td>
								<span class="">入职时间</span>
							</td>
							<td>
								<input name="intake" class="Wdate" type="text" onclick="WdatePicker()" value="${user.intake }" />
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
						
						<tr>
							<td>
								<span class="">辞职时间</span>
							</td>
							<td>
								<input name="outtake" class="Wdate" type="text" onclick="WdatePicker()" value="${user.outtake }"/>
							</td>
							<!--<td><span class="">用户名不可更改。</span></td>-->
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td colspan="2" class="">
								<script type="text/javascript">
								function reset() {
									$(".userAdd")[0].reset();
								}
								function submit() {
									$(".userAdd").submit();
								}
								</script>
								<!-- 页码 + 按钮 -->
								<div class="btns-pagenav">
									<!-- 按钮 -->
									<div class="div-btns" style="float: left;">
										<a href="javascript:void(0)" class="bt_green" onclick="submit()">修 改 用 户</a>
										<a href="javascript:void(0)" class="bt_green" onclick="reset()">返 回</a>
									</div>
									<!--end 按钮 -->
								</div>
								<!-- / 页码 + 按钮 -->
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
	
		<div class="clear"></div>
	</body>
</html>