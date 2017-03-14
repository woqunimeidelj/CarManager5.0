<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hsz.maven.model.User"%>
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理</title>
<%--因为mystyle.css在css文件中,所以写成href="../css/mystyle.css"--%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/mystyle.css"></link>
</head>
<body>
	<h1 align="center" style="color:blue">用户信息管理</h1>
	<table width="100%" border="0" 
		bgcolor="#cccccc">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>审核状态</td>
			<td colspan="2">操作</td>
		</tr>
		
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${userLists}" var="user">
		    
		    <%
			    if (c == 1) {
					color = "#ffffff";
					c = 0;
				} else {
					color = "#f5f5f5";
					c = 1;
				}
		    %>
		    
			<tr bgcolor="<%=color%>">
				<%-- <td>
					<c:if test="${empty student.headerImg}">
					    <img src= "${pageContext.request.contextPath}/images/y.jpg" width="60px" height="60px"/>
					</c:if>
					<c:if test="${!empty student.headerImg}">
					   <img src= "${pageContext.request.contextPath}${student.headerImg}" width="60px" height="60px"/>
					</c:if>
				</td> --%>
				<td>${user.user_id}</td>
				<td>${user.username}</td>
				<td>******</td>
				<td><c:if test="${user.state == 1}">未通过</c:if>
					<c:if test="${user.state == 2}">通过</c:if>
				</td>
				<td><a href="<%=basePath%>user/deleteuser.do?id=${user.user_id}">删除</a></td>
				<td><a href="<%=basePath%>user/seleteuser.do?user_id=${user.user_id}">审核</a></td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>