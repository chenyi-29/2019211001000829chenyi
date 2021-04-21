<%@ page import="com.chenyi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2021/4/21
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");

%>
<form method="post" action="register">
    <input type="hidden"name="id"value="<%=u.getId()%>">
    Username:<input type="text" name="Username" value="<%=u.getUsername()%>"><br/>
    Password:<input type="password" name="Password" ><br/>
    Email:<input type="text" name="Email" value="<%=u.getEmail()%>"><br/>
    Gender:<input type="radio" name="Gender" value="male"<%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="Gender"value="female"<%="female".equals(u.getGender())?"checked":""%>>Female<br/>
    Birthdate:<input type="text" name="Email" value="<%=u.getBirthDate()%>"><br/>
    <input type="submit"  value="Save Changes">
</form>
<%@include file="footer.jsp"%>