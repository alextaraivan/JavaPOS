<%-- 
    Document   : Users
    Created on : Jan 5, 2019, 7:00:41 PM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@include file="external.jsp" %>
        <title>Users</title>
        
        <%@include file="MeniuLogat.jsp" %>
    </head>
    <body>
        <h1>Users</h1>
    <% if (request.getSession().getAttribute("userRole").equals("admin")){ %>
    
      <form method="POST" action="${pageContext.request.contextPath}/Users">
        <p>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Register" role="button">Add User</a>
            <button class="btn btn-danger" type="submit">Delete users</button>
        </p>

    <% } %>
    <c:forEach var="user" items="${users}" varStatus="status">
        <div class="row">
            <div class="col-md">
            <input type="checkbox" class="form-check-input" name="user_ids" value="${user.id}" />
            </div>
            <div class="col-md-4">
                ${user.username}
            </div>
            <div class="col-md-4">
                ${user.email}
            </div>
             <div class="col-md-4">
                ${user.phone}
            </div>
            <div class="col-md-4">
                ${user.position}
            </div>
            <div class="col-md-2">
              <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button">Edit User</a>
            </div>
        </div>
    </c:forEach>
    </form>
    </body>
</html>
