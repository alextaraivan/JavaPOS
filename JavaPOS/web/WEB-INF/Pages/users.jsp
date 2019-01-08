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
       
        <% if (request.getSession().getAttribute("userRole").equals("admin")){ %>
            <form class="mx-auto w-75" method="POST" action="${pageContext.request.contextPath}/Users">
                <p>
                    <a class="btn btn-primary w-25" href="${pageContext.request.contextPath}/Register" role="button">Adauga Utilizator</a>
                    <button class="btn btn-danger w-25" type="submit">Stergere Utilizator</button>
                </p>
        <% } %>
                <table class="table table-striped table-dark mr-2">
                    <thead>
                      <tr>
                        <th scope="col">Select</th>
                        <th scope="col">Username</th>
                        <th scope="col">Email</th>
                        <th scope="col">Telefon</th>
                        <th scope="col">Tip</th>
                        <th scope="col">Telefon</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="user" items="${users}" varStatus="status">
                        <tr> 
                            <td>
                                <label class="container">
                                    <input type="checkbox" name="user_ids" value="${user.id}">
                                    <span class="checkmark"></span>
                                </label>
                            </td>
                             <td>${user.username}</td>
                             <td>${user.email}</td>
                             <td>@${user.phone}</td>
                             <td>${user.position}</td>
                             <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button">Editare</a></td>
                        </tr>
                      </c:forEach> 
                    </tbody>
                </table>
            </form>
    </body>
</html>
