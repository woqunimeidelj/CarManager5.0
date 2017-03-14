<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hsz.maven.model.Car"%>
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆列表</title>
<%--因为mystyle.css在css文件中,所以写成href="../css/mystyle.css"--%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/mystyle.css"></link>
</head>
<body>
	<h1 align="center" style="color:blue">车辆信息列表</h1>
	<table width="100%" border="0" 
		bgcolor="#cccccc">
		<tr>
			<td>车牌号码</td>
			<td>车辆类型</td>
			<td>车主姓名</td>
			<td>联系电话</td>
			<td colspan="2">操作</td>
		</tr>
		
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${carLists}" var="car">
		    
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
				<td>${car.carnumber}</td>
				<td>${car.carname}</td>
				<td>${car.owner}</td>
				<td>${car.phone}</td>
				<td><a href="<%=basePath%>car/delete.do?id=${car.id}">删除</a></td>
				<td><a href="<%=basePath%>car/find.do?number=${car.carnumber}">修改</a></td>
			</tr>
		</c:forEach>
	
	</table>
	<br>
	${url}
</body>
</html>