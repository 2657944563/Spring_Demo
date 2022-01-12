<%--
  Created by IntelliJ IDEA.
  User: 2657944563
  Date: 2022/1/12
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VoTest</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/quick16" method="post">
    1.name<input type="text" name="userList[0].name"><br>
    1.age<input type="text" name="userList[0].age"><br>
    1.name<input type="text" name="userList[1].name"><br>
    1.age<input type="text" name="userList[1].age"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
