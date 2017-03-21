<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>洗车系统后台管理中心</title>
		<link rel="stylesheet" href="<%=basePath%>/resources/css/pintuer.css">
		<link rel="stylesheet" href="<%=basePath%>/resources/css/admin.css">
		<script src="<%=basePath%>/resources/js/jquery.js"></script>
	</head>
	<body style="background-color: #f2f9fd;">
		<div class="header bg-main">
			<div class="logo margin-big-left fadein-top">
				<h1>
					<img src="<%=basePath%>/resources/images/y.jpg" class="radius-circle rotate-hover"
						height="50" alt="" />
					洗车系统后台管理中心
				</h1>
			</div>
 				<div class="head-l"><a class="button button-little bg-green" href="./homepage1.jsp"><span class="icon-home"></span> 前台首页</a>&nbsp;&nbsp;<a class="button button-little bg-red" href="./login.do"><span class="icon-power-off"></span> 退出登录</a> </div>
		</div>
		<div class="leftnav">
			<div class="leftnav-title">
				<strong><span class="icon-list"></span>菜单列表</strong>
			</div>
			<h2>
				<span class="icon-user"></span>基本设置
			</h2>
			<ul style="display: block">
				<li>
					<a href="<%=basePath%>user/showuser.do" target="right"><span
						class="icon-caret-right"></span>用户信息列表</a>
				</li>

			</ul>
			<h2>
				<span class="icon-pencil-square-o"></span>洗车管理
			</h2>
			<ul>
				<li>
					<a href="<%=basePath%>car/show.do" target="right"><span
						class="icon-caret-right"></span>车辆信息列表</a>
				</li>
				<li>
					<a href="<%=basePath%>car/add.do" target="right"><span
						class="icon-caret-right"></span>车辆信息添加</a>
				</li>
				<li>
					<a href="./find_car.jsp" target="right"><span
						class="icon-caret-right"></span>车辆信息查找</a>
				</li>
			</ul>
			
			<h2>
				<span class="icon-pencil-square-o"></span>权限管理
			</h2>
			<ul>
				<li>
					<a href="<%=basePath%>module/showmodule.do" target="right"><span
						class="icon-caret-right"></span>模块管理</a>
				</li>
				<li>
					<a href="<%=basePath%>role/showrole.do" target="right"><span
						class="icon-caret-right"></span>角色管理</a>
				</li>
			</ul>

		</div>
		<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		})
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
</script>
		<ul class="bread">
			<li>
				<a href="<%=basePath%>module/showmodule.do" target="right" class="icon-home">模块管理</a>
			</li>
			<li>
				<a href="<%=basePath%>role/showrole.do" id="a_leader_txt">角色管理</a>
			</li>
		</ul>
		<div class="admin">
			<iframe scrolling="auto" rameborder="0" src="info.jsp" name="right"
				width="100%" height="100%"></iframe>
		</div>

	</body>
</html>