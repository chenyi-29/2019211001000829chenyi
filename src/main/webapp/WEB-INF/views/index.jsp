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
<%@include file="header.jsp"%>
<h2><%= "Welcome to my online shop Home Page" %>
</h2>
<br/>
<form method="get" target="_blank" action="search"></form>
<input type="text" name="txt" size="30">
<select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">bing</option>
    <option value="google">Google</option>
</select>
<input type="submit" value="search">
<a href="hello-servlet">Hello Servlet</a>
<%@include file="footer.jsp"%>
</body>
</html>