<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2021/6/15
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body> <%
    Cookie[] cookies=request.getCookies();
    String firstValue="";
    String secondValue="";
    String result="";
    String name="";
    String length="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("cLength")){
                length=cookie.getValue();
            }
            if (cookie.getName().equals("cResult")){
                result=cookie.getValue();
            }
            if (cookie.getName().equals("cSecondValue")){
                secondValue=cookie.getValue();
            }
            if (cookie.getName().equals("cFirstValue")){
                firstValue=cookie.getValue();
            }
            if (cookie.getName().equals("cName")){
                name=cookie.getValue();
            }
        }
    }
%>
<form method="post" action="CalServlet">
    First val:  <input type="text" name="firstVal" value="<%=firstValue%>"/>      Enter a name: <input type="text" name="name"  value="<%=name%>"/><br>
    Second val:  <input type="text" name="secondVal" value="<%=secondValue%>">      Length: <input type="text" name="length" value="<%=length%>" /><br>
    Result:  <input type="text" name="result" value="<%=result%>"><br>

    <input type="button" value="add" >
    <input type="button" value="subtract">
    <input type="button" value="multiply">
    <input type="button" value="divide">
    <input type="button" value="computerLength">
    <input type="button" value="Reset">
    <input type="hidden" name="action">

</form>
</body>
</html>

