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
             <div id="adminPage"> 
                 <div class="w-25 p-3 mx-auto">
                    <input class="btn btn-primary btn-lg btn-block" type="button" onclick="location.href='${pageContext.request.contextPath}/Users'" value="Users" />
                </div>     
            </div>        
             <% } 
                else { 
             %>
            
            <p class="display-4 d-flex justify-content-center">Alege tipul operatiunii</p>
            <div id="cashierPage" class="d-flex justify-content-center"> 
                <input class="btn btn-primary w-25 mr-1" type="button" onclick="location.href='${pageContext.request.contextPath}/AddSale';" value="Vanzare Noua" />
                <input class="btn btn-warning w-25" type="button" onclick="location.href='${pageContext.request.contextPath}/NewReturn';" value="Retur Nou" />
            </div>
          <% } %>
        </div>
        
    </body>
</html>
