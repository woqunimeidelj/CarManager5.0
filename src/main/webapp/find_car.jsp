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
<title>查找车辆</title>
	<style type="text/css">
		body{
			background-image:url('http://img4.imgtn.bdimg.com/it/u=2691393669,4252231193&fm=23&gp=0.jpg');
			background-size:100%;
			text-align:center;
		}
		
		h1{
			color:#40E0D0;
			font-size:60px;
		}
		
	</style>
</head>

<body>
	<h1 align="center">查找车辆信息</h1>
	<br>
	<br>
	<br>
	<div>
		<form action="<%=basePath%>/car/find.do" method="post">
			<select name="type" class="aa">
				<option value="carnumber">车牌号码</option>
				<option value="phone">电话号码</option>
				<option value="owner">车主姓名</option>
			</select>
			<input type="text" name="word"/>
			<input type="submit" value="查询">
		</form>
	</div>
</body>
</html>