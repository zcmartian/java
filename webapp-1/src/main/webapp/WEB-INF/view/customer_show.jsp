<%--
  Created by IntelliJ IDEA.
  User: marszhou
  Date: 15/12/18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户详情</title>
</head>
<body>
<h2>${customer.id}</h2>
<h2>${customer.name}</h2>
<h2>${customer.contact}</h2>
<h2>${customer.phone}</h2>
<h2>${customer.email}</h2>
</body>
</html>
