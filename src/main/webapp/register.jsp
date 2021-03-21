
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form method="post" action="register">
    Username:<input type="text" name="Username" placeholder="Username"><br/>
    Password:<input type="password" name="Password" placeholder="Password"><br/>
    Email:<input type="text" name="Email" placeholder="Email"><br/>
    Gender:<input type="radio" name="Gender" value="male">Male<input type="radio" name="Gender"value="female">Female<br/>
    Birthdate:<input type="text" name="Email" placeholder="Birthdate(yyyy-mm-dd)"><br/>
    <input type="submit" name="register" value="register">
</form>
</body>
</html>
