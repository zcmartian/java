<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=cn-gb">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>SSI����</title>
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
<h2>Struts 2 -Spring-Ibatis �û���¼</h2>
</center>

<form id="myform" action="login" method="post">
username:<input type="text" name="username" />&nbsp;&nbsp;&nbsp;
<input type="button" name="b1" value="�û�����"
	onClick="doLink('queryall')" />
<br>
password:<input type="password" name="password" /><br>
<input type="submit" name="sub" value="��¼" /> &nbsp;&nbsp; 
<input type="reset" name="reset" value="����" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="b2" value="ע��"
	onClick="window.open('register.jsp','new','height=250,width=400,top=100,left=400')" />
</form>

</body>
</html>
