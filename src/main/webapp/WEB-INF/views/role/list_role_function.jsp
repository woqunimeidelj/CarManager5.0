<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hsz.maven.model.Function"%>
<%@ page import="java.util.*"%>
<%
	String contextPath = request.getContextPath();
%>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>模块管理</title>
<script>
	function selectAll(form, elementName) {
		for (var i = 0; i < form.elements.length; i++) {
			var e = form.elements[i];
			if (e.name == elementName) {
				e.checked = form.chkall.checked;
			}
		}
	}
</script>
</head>
<body>
	<h3>权限管理 &gt; 角色管理 &gt; 管理角色功能</h3>
	<p>
		[<a href="<%=contextPath%>/role/showrole.do">返回</a>]
	</p>

	<p>角色名称：${role.role_name}</p>
	<form id="form1" name="form1" method="post"
		action="<%=contextPath%>/role/submitrolefunction.do">
		<table width="100%" border="0" cellpadding="2" cellspacing="2"
			bgcolor="#cccccc">
			<tr>
				<td width="4%"><label> <input name="chkall"
						type="checkbox" id="chkall" value=""
						onclick="javascript:selectAll(form1,'selectId')" />
				</label></td>
				<!-- <td width="24%"><div align="center">模块</div></td> -->
				<td width="38%"><div align="center">功能</div></td>
				<td width="34%"><div align="center">功能描述</div></td>
				<td><div align="center">操作</div></td>
			</tr>
			<%
				String color = "";
				int c = 1;
			%>

			<%
				List<Function> allLists = (List<Function>) request.getAttribute("functionAllLists");
				for (Function function : allLists) {
			%>
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
					<%
						int z = 0;
						List<Function> lists = (List<Function>) request.getAttribute("functionLists");
						for (Function f : lists) {
							if (f.getFunction_id() == function.getFunction_id()) {
								z = 1;
							}
						}
					%>
	
					<%
						if (z == 1) {
					%>
					<td bgcolor="<%=color%>"><input name="selectId" type="checkbox"
						value="<%=function.getFunction_id() %>" checked="checked" /></td>
					<%
						} else {
					%>
					<td bgcolor="<%=color%>"><input name="selectId" type="checkbox"
						value="<%=function.getFunction_id() %>" /></td>
					<%
						}
					%>
	
					<%-- <td bgcolor="<%=color%>"><div align="center">${x.module.name}</div></td> --%>
					<td bgcolor="<%=color%>"><div align="center"><%=function.getFunction_code() %></div></td>
					<td bgcolor="<%=color%>" style="word-break: break-all;"><%=function.getDescription() %></td>
				</tr>

			<%
				}
			%>
			<tr>
				<td>&nbsp;<input type="hidden" name="role_id" value="${role_id}"></td>
				<td colspan="3"><input name="submit1" type="submit" value="提交" />
					<input name="submit2" type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>