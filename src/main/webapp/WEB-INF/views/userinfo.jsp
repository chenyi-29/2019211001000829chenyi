<%@ page import="com.chenyi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2021/4/11
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>user Info</h1>
<%
    User u=(User)session.getAttribute("user");
%>
<table>
    <tr>
        <td>Username</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender</td><td><%=u.getGender()%></td>
    </tr>
    <tr>
        <td>birthdate</td><td><%=u.getBirthDate()%></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
