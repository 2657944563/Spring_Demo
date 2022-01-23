<%--
  Created by IntelliJ IDEA.
  User: 2657944563
  Date: 2022/1/22
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>保存账户</title>
</head>
<body>
<h1>信息添加</h1>
<form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
    账户名称：<input type="text" name="name"/><br>
    账户金额：<input type="text" name="money"/><br>
    <input type="submit" name="保存"/><br>

</form>
</body>
</html>
