<%-- 
    Document   : LoginForm
    Created on : Dec 18, 2018, 5:40:19 PM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="Login" method="post">  
            Name:<input type="text" name="username"/><br/><br/>  
            Password:<input type="password" name="userpass"/><br/><br/>  
            <input type="submit" value="login"/>  
        </form> 
    </body>
</html>
