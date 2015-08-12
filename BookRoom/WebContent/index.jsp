<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=cn-gb">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>SSI整合</title>
<script type="text/javascript">
	var link;
	function doLink(link) {
		document.getElementById("myform").action = link;
		document.getElementById("myform").submit();
	}
</script>
</head>

<body>
<center>
<h2>Struts 2 -Spring-Ibatis 用户登录</h2>
</center>

<form id="myform" action="login" method="post">
username:<input type="text" name="username" />&nbsp;&nbsp;&nbsp;
<input type="button" name="b1" value="用户管理"
	onClick="doLink('queryall')" />
<br>
password:<input type="password" name="password" /><br>
<input type="submit" name="sub" value="登录" /> &nbsp;&nbsp; 
<input type="reset" name="reset" value="重置" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="b2" value="注册"
	onClick="window.open('register.jsp','new','height=250,width=400,top=100,left=400')" />
</form>

</body>
</html>
