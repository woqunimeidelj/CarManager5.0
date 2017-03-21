<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加车辆信息</title>
	<style type="text/css">
		body{
			text-align:center;
		}	
	</style>
</head>
<body>
<h1 align="center" style="color:blue">添加车辆信息</h1>
	<br>
	<br>
	<br>
	<form action="<%=basePath%>car/addtwo.do" method="post" enctype="application/x-www-form-urlencoded">
		车牌号码:<input type="text" name="carnumber" value="${car.carnumber}"/><br><br>
		车辆类型:<input type="text" name="carname" value="${car.carname }"/><br><br>
		车主姓名:<input type="text" name="owner" value="${car.owner }"/><br><br>
		联系电话:<input type="text" name="phone" value="${car.phone }"/><br><br>
		<!-- 头像:<input type="file" name="myfile"/><br><br> -->
		${message}<br><br>
		<input type="submit" value="提交"/> <br>
	</form>
</body>
</html>