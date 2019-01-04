<%@ page import="java.sql.*" %>


<html>
    <head>
        <title>Insert</title>
    </head>
    <body>
        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Store", "Lidi", "1234");

            Statement statement = connection.createStatement();

            String user = request.getParameter("first_name")+" "+request.getParameter("last_name");
            String pass=request.getParameter("password");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            int no=Integer.parseInt(phone);    
            statement.executeUpdate("insert into users(username,email,phone,password,position)values ('"+user+"','"+email+"',"+no+",'"+pass+"','CASHIER')") ; 
        %>
<%@include file="WEB-INF/Pages/Footer.jsp" %>