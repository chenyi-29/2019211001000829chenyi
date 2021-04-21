<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2021/4/5
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<form method="post" action="login">
    <%
        if(! (request.getAttribute("message")==null)){
            out.println(request.getAttribute("message"));
        }

    %>
    <%
        Cookie[] allCookie=request.getCookies();
        String username="",password="",rememberMeVale="";
        if (allCookie!=null){
            for (Cookie c:allCookie) {
                if (c.getName().equals("cusername")){
                    username=c.getValue();
                }
                if (c.getName().equals("cpassword")){
                    password=c.getValue();
                }
                if (c.getName().equals("rememberMe")){
                    rememberMeVale=c.getValue();
                }
                
            }
        }
    %>
    Username:<input type="text" name="Username" placeholder="Username"value="<%=username%>"><br/>
    Password:<input type="password" name="Password" placeholder="Password"value="<%=password%>"><br/>
    <input type="checkbox"name="rememberMe" value="1"<%=rememberMeVale.equals("1")?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>
