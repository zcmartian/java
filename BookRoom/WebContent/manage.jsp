<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>

<style type="text/css">
.class1 {
	background: url(images/modify_page.png);
	border: none;
	height: 24px;
	width: 60px
}

.class2 {
	background: url(images/to_modify_page.png);
	border: none;
	height: 24px;
	width: 60px
}

.class3 {
	background: url(images/delete_page.png);
	border: none;
	height: 24px;
	width: 60px
}

.class4 {
	background: url(images/to_delete_page.png);
	border: none;
	height: 24px;
	width: 60px
}
</style>
<script type="text/javascript">
	var link;
	function doLink(link) {
		document.getElementById("myform").action = link;
		document.getElementById("myform").submit();
	}
</script>
</head>
<body>
<div align="center">
<form action="#" id="myform" name="myform" method="post">
<table border=1 width="80%">
	<tr>
		<th width="39%">用户名</th>
		<th width="39%">密码</th>
		<th>修改</th>
		<th>删除</th>
	</tr>
	<tr>
		<s:iterator value="#request.user" id="id"status="st">
			 <s:if test="#st.index%2==0||#st.last">
		     <tr>      
       		 </s:if> 
			<td><s:property value="#id.username" /></td>
			<td><s:property value="#id.password" /></td>
			<td><input style="width: 40px; height: 40px" name="button"
					type="button" class="class1" onMouseOver="this.className='class2'"onMouseOut="this.className='class1'"
                    onClick="window.open('update.jsp?username=<s:property value="#id.username" />&password=<s:property value="#id.password" />','new','height=500,width=800,top=100,left=400')"
					value="修改" /></td>
			<td><input style="width: 40px; height: 40px" name="button"
					type="button" class="class3" onMouseOver="this.className= 'class4'"onMouseOut="this.className= 'class3'"
                    onclick="doLink('delete?username=<s:property value="#id.username" />')"
					value="删除" /></td>
			
					
   		     <s:if test="#st.index%2==0||#st.last">   
             </tr>       
       		 </s:if>   

			
		</s:iterator>
	</tr>
	<!--
	<logic:notEmpty name="user">
		<logic:iterate id="e" name="user">
			<tr>
				<td>${e.username}</td>
				<td>${e.password}</td>
				<td><input style="width: 40px; height: 40px" name="button"
					type="button" class="class1" onMouseOver="this.className='class2'"onMouseOut="this.className='class1'"
                    onClick="doLink('update?username=${e.username}')"
					value="修改" /></td>
				<td><input style="width: 40px; height: 40px" name="button"
					type="button" class="class3" onMouseOver="this.className= 'class4'"onMouseOut="this.className= 'class3'"
                    onclick="doLink('delete?username=${e.username}')"
					value="删除" /></td>
			</tr>
		</logic:iterate>
	</logic:notEmpty>
-->
</table>
</form>
</div>
</body>
</html>