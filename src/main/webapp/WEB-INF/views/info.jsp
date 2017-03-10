<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>网站信息</title>
		<link rel="stylesheet" href="<%=basePath%>/resources/css/pintuer.css">
		<link rel="stylesheet" href="<%=basePath%>/resources/css/admin.css">
		<script src="<%=basePath%>/resources/js/jquery.js"></script>
		<script src="<%=basePath%>/resources/js/pintuer.js"></script>
	</head>
	<body>
		<div>
		  <h1>欢迎来到学生管理系统 模块开发中</h1>
		  <h2>您跳转的界面未找到！请进行修改！......</h2>
		</div>
	</body>
</html>