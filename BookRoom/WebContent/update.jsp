<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=cn-gb">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>SSI整合</title>
</head>

<body>
<center>
<h2>Struts 2 -Spring-Ibatis 用户修改</h2>
</center>
<% String username=request.getParameter("username");
String password=request.getParameter("password");
%>
<form id="myform" action="update?username=<%=username %>" method="post">
username:<input readonly type="text" name="username" value="<%=username %>" />
<br>
password:<input type="text" name="password" value="<%=password %>" /><br>
<input type="submit" name="sub" value="提交" /> &nbsp;&nbsp; 
<input type="reset" name="reset" value="重置" />

</form>

</body>
</html>
