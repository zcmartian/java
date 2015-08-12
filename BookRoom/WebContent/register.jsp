<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=cn-gb">
<title>SSI整合</title>

</head>

<body>
<center>
<h2>Struts 2 -Spring-Ibatis 用户注册</h2>
</center>

<form id="myform" action="register" method="post">
username:<input type="text" name="username" /><br></br>
password:<input type="password" name="password" /><br></br>
<input type="submit" name="sub" value="提交" /> &nbsp;&nbsp; <input
	type="reset" name="reset" value="重置" />
</form>
</body>
</html>