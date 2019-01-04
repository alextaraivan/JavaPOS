<%-- 
    Document   : LoginForm
    Created on : Dec 18, 2018, 5:40:19 PM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="external.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <%@include file="Meniu.jsp" %>
            <form class="w-60 p-3 text-center">
                <div class="form-group">
                  <label for="exampleInputEmail1">Username</label>
                  <input type="text" class="form-control" name="user" placeholder="Ex:PopaIonel"/>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Parola</label>
                  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ex:123">
                </div>
                <button type="submit" value="login" class="btn btn-primary">Login</button>
            </form>
     <%@include file="Footer.jsp" %>