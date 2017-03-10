<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理中心</title>
<script>
	function valicatemodule() {
		if (document.form1.name.value == "") {
			window.alert("名称不能为空!");
			window.form1.name.focus();
			return false;
		}
	}
</script>
<body>
	<h3>创建模块</h3>
	${actionmessage}
	<h4>
		[<a href="<%=contextPath %>/module/showmodule.do">返回模块浏览</a>]
	</h4>

	<form action="<%=contextPath %>/module/addmodule.do" method="post" name="form1" id="form1"
		onsubmit="return valicatemodule()">
		<table width="100%" border="0" cellpadding="1" cellspacing="1"
			bgcolor="#CCCCCC">
			<tr bgcolor="#f0f0f0" height="20">
				<td width="15%"><div align="right">* 模块名称：</div></td>
				<td width="85%" style="word-break: break-all;"><input
					name="module_name" type="text" size="20" maxlength="32" /></td>
			</tr>
			<tr bgcolor="#f5f5f5" height="20">
				<td><div align="right">模块描述：</div></td>
				<td><textarea name="description" cols="20" rows="3"></textarea></td>
			</tr>
			<tr bgcolor="#f5f5f5" height="20">
				<td></td>
				<td><input name="submit" type="submit" value="提交" /> <input
					name="reset" type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>