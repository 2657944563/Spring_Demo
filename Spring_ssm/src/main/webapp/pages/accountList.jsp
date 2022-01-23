<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 2657944563
  Date: 2022/1/22
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据展示</title>
</head>
<body>
<h1>展示账户数据</h1>
<table>
    <tr>
        <td>账户</td>
        <td>账户名称</td>
        <td>账户金额</td>
    </tr>
    <c:forEach items="${accountList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
