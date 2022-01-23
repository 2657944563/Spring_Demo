<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="<c:url value="/account/test"/>">test</a>
<br/>
<a href="<c:url value="/save.jsp"/>">save.jsp</a>
<br/>
<a href="<c:url value="/account/findAll"/>">findAll</a>
</body>
</html>