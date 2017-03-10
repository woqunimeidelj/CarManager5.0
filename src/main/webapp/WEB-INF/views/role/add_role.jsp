<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%
	String contextPath = request.getContextPath();
%>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模块管理</title>
<script>
	function validaterole() {
		if (document.form1.name.value == "") {
			window.alert("角色不能为空!");
			window.form1.name.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<h3>权限管理 &gt; 角色管理 &gt; 添加角色</h3>

	<h4>
		[<a href="<%=contextPath %>/role/showrole.do">返回</a>]
	</h4>
	<form action="<%=contextPath %>/role/addrole.do" method="post" name="form1" id="form1"
		onSubmit="return validaterole()">
		<table width="100%" border="0" cellpadding="1" cellspacing="1"
			bgcolor="#CCCCCC">
			<tr bgcolor="#f0f0f0" height="20">
				<td width="12%"><div align="right">* 角色：</div></td>
				<td width="24%" style="word-break: break-all;"><input
					name="role_name" type="text" id="role_name" size="20" maxlength="32" /></td>
				<td width="64%">&nbsp;</td>
			</tr>
			<tr bgcolor="#f5f5f5" height="20">
				<td><div align="right">描述：</div></td>
				<td><label> <textarea name="description" cols="20"
							rows="3" id="description"></textarea>
				</label></td>
				<td>&nbsp;</td>
			</tr>
			<tr bgcolor="#f5f5f5" height="20">
				<td>&nbsp;</td>

				<td><input name="submit" type="submit" value="提交" /> <input
					name="submit2" type="reset" value="重置" /></td>
				<td>&nbsp;</td>
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