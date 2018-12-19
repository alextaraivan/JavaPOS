<%-- 
    Document   : login
    Created on : Dec 19, 2018, 4:09:19 PM
    Author     : Romelia Milascon
--%>
<%@ page import="java.sql.*" %>


<HTML>
    <HEAD>
        <TITLE>Fetching Data From a Database</TITLE>
    </HEAD>

    <BODY>
        <H1>Fetching Data From a Database</H1>

        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Store", "Lidi", "1234");

            Statement statement = connection.createStatement();

            String user = request.getParameter("user");
            String pass=request.getParameter("userpass");

            ResultSet resultset = statement.executeQuery("select * from users where username = '"+user+"' and password='"+pass+"' ") ; 

            if(!resultset.next()) {
                out.println("Sorry, you are  not registered. ");
            } else {
        %>

        <TABLE BORDER="1">
            <TR>
               <TH>ID</TH>
               <TH>FirstName</TH>
               <TH>LAstNAme</TH>
           </TR>
           <TR>
               <TD> <%= resultset.getString(1) %> </TD>
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
           </TR>
       </TABLE>
       <BR>
       <% 
           } 
       %>
    </BODY>
</HTML>