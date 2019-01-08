<%-- 
    Document   : POS
    Created on : Dec 19, 2018, 9:07:48 PM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="external.jsp" %>
        <title>POS</title>
    </head>
    <body>
        <header>
             <%@include file="MeniuLogat.jsp" %>
        </header>
        
        <div id="content">
            <% if (request.getSession().getAttribute("userRole").equals("admin"))
            { %> 
             <p>Content for admin</p>
             <div id="adminPage"> 
                <input type="button" onclick="location.href='${pageContext.request.contextPath}/Users'" value="Users" />
            </div>        
             <% } 
                else { 
             %>
            
            <p>Content POS casier</p>
             <div id="cashierPage"> 
                <input type="button" onclick="location.href='${pageContext.request.contextPath}/AddSale';" value="New Sale" />
                <input type="button" onclick="location.href='${pageContext.request.contextPath}/NewReturn';" value="New Return" />
            </div>
          <% } %>
        </div>
        
    </body>
</html>
