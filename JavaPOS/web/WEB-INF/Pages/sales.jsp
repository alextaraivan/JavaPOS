<%-- 
    Document   : sales
    Created on : Jan 8, 2019, 9:41:36 PM
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
       
                <table class="table table-striped table-dark mr-2">
                    <thead>
                        <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time</th>
                        <th scope="col">Payment Amount</th>
                        <th scope="col">Cashier</th>
                        <th scope="col">Store</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="sale" items="${sales}" varStatus="status">
                        <tr> 
                            
                            <td> ${sale.id} </td>
                             <td>${sale.saleDate}</td>
                             <td>${sale.saleTime}</td>
                             <td>${sale.paymentAmount}</td>
                             <td>${sale.cashierName}</td>
                             <td>${sale.storeName}</td>
                            
                        </tr>
                      </c:forEach> 
                    </tbody>
                </table>
            </form>
    </body>
</html>
