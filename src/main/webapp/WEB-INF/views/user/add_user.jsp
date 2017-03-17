<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统</title>
</head>

<body>
<div id="midcolumn">
<script>
function validateitem(){
   if(document.registerform.username.value==""){
      window.alert("用户名不能为空!");
      window.registerform.username.focus;
      return false;
   }
   if(document.registerform.password.value==""){
      window.alert("密码不能为空!");
      window.registerform.password.focus;
      return false;
   }
   if(document.registerform.configpassword.value==""){
      window.alert("确认密码不能为空!");
      window.registerform.configpassword.focus;
      return false;
   }
   if(document.registerform.configpassword.value != document.registerform.password.value){
	      window.alert("确认密码不一致!");
	      window.registerform.configpassword.focus;
	      return false;
	   }
   return true;
 }
</script>
<h3>用户注册</h3>
<form action="<%=basePath%>user/adduser.do" method="post" name="registerform" id="registerform" onsubmit="return validateitem()">
  <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tbody><tr bgcolor="#f0f0f0" height="20">

      <td width="30%"><div align="right">* 用户名：</div></td>
      <td width="39%"><input name="username" type="text" id="username" size="20" ></td>
      <td width="31%">&nbsp;</td>
    </tr>
    <tr bgcolor="#f5f5f5" height="20">
      <td><div align="right">* 密码：</div></td>
      <td><input name="password" type="password" id="password" size="20" ></td>
      <td><label></label></td>
    </tr>
    <tr bgcolor="#f0f0f0" height="20">
      <td><div align="right">* 密码确认:</div></td>
       <td><input name="configpassword" type="password" id="configpassword" size="20" ></td>
      <td><label></label></td>
    </tr><tr bgcolor="#f5f5f5" height="20">
      <td>&nbsp;</td>
      <td colspan="2"><input name="submit" type="submit" value="提交">
       <input name="submit2" type="reset" value="重置"> <a href="<%=basePath%>login.do"><font size="3" color="#000000">[返回]</font></a></td>
    </tr>
  </tbody></table>
</form>		
<hr class="clearer">
</div>

	<div id="footer">
	<p>Copyright © 2014 成都华特网络科技有限公司. 版权所有</p>
	</div>
<script type="text/javascript">window.status = "加载完成.";</script>

</body>
</html>