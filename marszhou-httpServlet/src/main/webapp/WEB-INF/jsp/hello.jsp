<%--
  Created by IntelliJ IDEA.
  User: marszhou
  Date: 15/12/17
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>接收 attribute:</h1>
<h2> ${currentTime} </h2>
<h3><%out.print(request.getAttribute("currentTime"));%></h3>
</body>
</html>
