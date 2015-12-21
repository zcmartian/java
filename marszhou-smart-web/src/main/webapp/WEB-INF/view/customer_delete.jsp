<%--
  Created by IntelliJ IDEA.
  User: marszhou
  Date: 15/12/19
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>客户详情</title>
</head>
<body>
<h2>被删除的客户详情</h2>
<h2>${customer.id}</h2>
<h2>${customer.name}</h2>
<h2>${customer.contact}</h2>
<h2>${customer.phone}</h2>
<h2>${customer.email}</h2>
<a href="${BASE}/customer">返回</a>
</body>
</html>
