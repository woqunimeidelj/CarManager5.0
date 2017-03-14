<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>审核注册用户</title>

	<style>
		body{
			text-align:center;
		}
	</style>

</head>

<body>
	<h1 align="center" style="color:red">审核注册用户</h1>
	<form action="./user/updateuser.do" method="post">
		<input type="hidden" name="user_id" value="${user.user_id}">
		用户名:<input type="text" name="username" value="${user.username}"><br/>
		密码:<input type="text" name="password" value="${user.password}"><br/>
		状态:<select name="state">
			<option value="2">通过</option>
			<option value="3">不通过</option>
		</select><br/> 
		用户权限: <select name="role_name">
			<c:forEach items="${roleLists}" var="role">
				<option value="${role.role_name}">${role.role_name}</option>
			</c:forEach>
		</select>
		 <br> <input type="submit" value="提交">
	</form>
</body>
</html>