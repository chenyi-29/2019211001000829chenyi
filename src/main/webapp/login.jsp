<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2021/4/5
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<form method="post" action="login">
    Username:<input type="text" name="Username" placeholder="Username"><br/>
    Password:<input type="password" name="Password" placeholder="Password"><br/>
    <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>
