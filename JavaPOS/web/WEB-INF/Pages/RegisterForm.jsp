<%-- 
    Document   : Register
    Created on : Dec 18, 2018, 4:17:58 PM
    Author     : Romelia Milascon
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="external.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <%@include file="Meniu.jsp" %>
    <!--<form class="w-60 p-3 text-center" action="Register" method="post">
            <table>
		<tr>
        		<td>First Name</td>
			<td><input type="text" name="first_name" /></td>
		</tr>
                <tr>
			<td>Last Name</td>
			<td><input type="text" name="last_name" /></td>
		</tr>				
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
                        <td>Email</td>
                        <td><input type="email" name="email" /></td>
                </tr>
                <tr>
                        <td>Contact No</td>
                        <td><input type="text" name="phone" /></td>
                </tr>
            </table>
            <input type="submit" value="Submit" />
        </form>-->
   
        <form class="w-60 p-3 text-center" action="Register" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Prenume</label>
                <input type="text" class="form-control" name="first_name"  placeholder="Ex:Ionel"/>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Nume</label>
                <input type="text" class="form-control" name="last_name"  placeholder="Ex:Popa"/>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Parola</label>
                <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Ex:123">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Email</label>
                <input type="email" class="form-control" name="email"  placeholder="Ex:popa.ionel@yahoo.com"/>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Telefon</label>
                <input type="tel" class="form-control" name="phone"  placeholder="Ex:0722334455"/>
            </div>
            <button type="submit" value="Submit" class="btn btn-primary">Submit</button>
        </form>
        <%@include file="Footer.jsp" %>
 











    <%@include file="Footer.jsp" %>
