<%--
  Created by IntelliJ IDEA.
  User: 2657944563
  Date: 2022/1/13
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/quick21" enctype="multipart/form-data" method="post">
    name:<input type="text" name="name"><br>
    file:<input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
