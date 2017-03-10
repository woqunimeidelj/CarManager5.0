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
function _delete(url,msg)
{
	var msg="真的要删除" + msg + "吗?";
	if(confirm(msg))
	{	
		location.href=url;
	}
	else
	{
		return false;
	}
}
</script>
</head>
<body>
	<h3>模块浏览</h3>
	${actionmessage}
	<p>
		[<a href="<%=contextPath%>/module/login_module.do">创建模块</a>]
	</p>
	<table width="100%%" border="0" cellpadding="2" cellspacing="2"
		bgcolor="#cccccc">
		<tr>
			<td width="25%"><div align="center">模块名称</div></td>
			<td width="37%"><div align="center">模块描述</div></td>
			<td width="8%"><div align="center">删除</div></td>
			<td width="10%"><div align="center">修改</div></td>
			<td width="20%"><div align="center">模块功能管理</div></td>
		</tr>
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${moduleLists}" var="module">
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
						align="center">${module.module_name}</div></td>
				<td bgcolor="#FFFFFF" style="word-break: break-all;">${module.description}</td>
				<td bgcolor="#FFFFFF"><div align="center">
						<a
							href="javascript:void _delete(deletemodule.do?module_id=${module.module_id}','模块')">删除</a>
					</div></td>
				<td bgcolor="#FFFFFF"><div align="center">
						<a href="<%=contextPath %>/module/updatemodule.do?module_id=${module.module_id}">修改</a>
					</div></td>
				<td bgcolor="#FFFFFF"><div align="center">
						<a href="<%=contextPath %>/function/showfunction.do?module_id=${module.module_id}">模块功能管理</a>
					</div></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>