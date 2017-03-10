<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模块管理</title>
<script>
	function validatefunction() {
		if (document.form1.function_code.value == "") {
			window.alert("功能代码不能为空!");
			window.form1.function_code.focus();
			return false;
		}
	}
</script>
</head>
<body>

	<h3>模块功能浏览</h3>

	<p>
		[<a href="<%=contextPath%>/module/showmodule.do">返回模块浏览</a>]
	</p>

	<p>模块名称：${module.module_name}</p>
	<table width="100%%" border="0" cellpadding="2" cellspacing="2"
		bgcolor="#cccccc">
		<tr>
			<td width="25%"><div align="center">功能代码</div></td>
			<td width="48%"><div align="center">功能描述</div></td>
			<td width="15%"><div align="center">删除</div></td>
			<td width="12%"><div align="center">修改</div></td>
		</tr>

		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${functionLists}" var="x">
			<%
				if (c == 1) {
						color = "#ffffff";
						c = 0;
					} else {
						color = "#f5f5f5";
						c = 1;
					}
			%>

			<tr>
				<td bgcolor="#FFFFFF" style="word-break: break-all;"><div
						align="center">${x.function_code}</div></td>
				<td bgcolor="#FFFFFF" style="word-break: break-all;">${x.description}</td>
				<td bgcolor="#FFFFFF"><div align="center">
						<a
							href="<%=contextPath%>/function/deletefunction.do?function_id=${x.function_id}">删除</a>
					</div></td>
				<td bgcolor="#FFFFFF"><div align="center">
						<a href="<%=contextPath%>/function/updatefunction.do?function_id=${x.function_id}">修改</a>
					</div></td>
			</tr>
		</c:forEach>
	</table>
	<h3>添加功能到当前模块</h3>

	<form action="<%=contextPath %>/function/addfunction.do" name="form1" method="post"
		onSubmit="return validatefunction()">
		<input type="hidden" name="module_id" value="${module_id}">
		<table width="100%" border="0" cellpadding="1" cellspacing="1"
			bgcolor="#CCCCCC">
			<tr bgcolor="#f0f0f0" height="20">
				<td width="16%"><div align="right">*功能代码：</div></td>
				<td width="84%"><input name="function_code" type="text"
					id="function_code" size="30" value=""
					maxlength="40" /></td>
			</tr>
			<tr bgcolor="#f5f5f5" height="20">
				<td><div align="right">功能描述：</div></td>
				<td><textarea name="description" cols="20" rows="3"
						id="description"></textarea></td>
			</tr>
			<tr bgcolor="#f5f5f5" height="20">
				<td>&nbsp;</td>
				<td><input name="submit" type="submit" value="提交" /> <input
					name="reset" type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
	<table width="100%" border="0" cellpadding="1" cellspacing="1">
		<tr bgcolor="#f5f5f5" height="20">
			<td height="30" bgcolor="#FFFFFF"><em>注意:名称前有*的为必填项</em></td>
		</tr>
	</table>
</body>
</html>