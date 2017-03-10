<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改车辆信息操作</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/css/mystyle.css"></link>
		<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript">

		function check(){
				var number = $("#num").val(); //获取表单元素值
				if(number==""){
					$("#msg").text("一些属性不能为空!");
					return false;
				}else{
					return true;
				}
			}
		</script>
		
		<style type="text/css">
			body{
			text-align:center;
		}
		</style>
		
	</head>
	<body>
	
		<h1 align="center">修改车辆信息操作</h1>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<%--  <%=request.getContextPath() %> 获取根路径 --%>
		<form action="./car/update.do" method="post"  onsubmit="return check()">
			<input id="car" type="hidden" name="carnumber" value="${car.carnumber}"/><br/>
			<input type="hidden" name="id" value="${car.id}" /><br/>
			车辆信息:<input id="num" type="text" name="carname" placeholder="${car.carname}"/><br/>
			车主姓名:<input id="num" type="text" name="owner" placeholder="${car.owner}"/><br/>
			联系电话:<input id="num" type="text" name="phone" placeholder="${car.phone}"/><br/>
			<input type="submit"  value="提交">
			<span id="msg"></span>
		</form>
	</body>
</html>

