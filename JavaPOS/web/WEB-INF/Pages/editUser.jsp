<%-- 
    Document   : editUser
    Created on : Jan 5, 2019, 11:31:22 PM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="external.jsp" %>
        <title>Edit User</title>
        
        <%@include file="MeniuLogat.jsp" %>
        
    </head>
    <body>
        <h1>Edit User</h1>
    <form class="needs-validation" method="POST" action="${pageContext.request.contextPath}/EditUser">
        <div class="row">
            <div class="mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="username" required value="${user.username}">
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Email" required value="${user.email}">
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="mb-3">
                <label for="phone">Phone</label>
                <input type="tel" class="form-control" name="phone" id="phone" placeholder="Phone" required value="${user.phone}">
                <div class="invalid-feedback">
                    Phone is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mb-3">
                <label for="position">Position</label>
                <select class="custom-select d-block w-100" name="position" id="position" required>
                      <option value="${user.position}"} selected>${user.position}</option>
                      <option value="ADMIN">ADMIN</option>
                      <option value="CASHIER">CASHIER</option>
                </select>
                <div class="invalid-feedback">
                    Please select a valid position.
                </div>
            </div>
        </div>        
        <input type="hidden" name="user_id" value="${user.id}" />
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
    </form>
    </body>
</html>
