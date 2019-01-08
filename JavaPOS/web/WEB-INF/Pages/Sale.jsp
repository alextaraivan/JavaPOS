<%-- 
    Document   : Sale
    Created on : Jan 7, 2019, 6:04:47 PM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="external.jsp" %>
        <title>Sale</title>
    </head>
    <body>
        <header>
             <%@include file="MeniuLogat.jsp" %>
        </header>
       
     <form class="needs-validation" method="POST" action="${pageContext.request.contextPath}/AddSale">
        <div class="row">
              <div class="mb-3">
                 BarCode:<br>
                 <input type="number" name="barCode" required><br>
                 <input type="number" min="1"  class="form-control" name="quantity" id="quantity"  value="1">
                   <div class="invalid-feedback">
                       Please select a valid product.
                   </div>
               </div>
                     
               <button class="btn btn-primary btn-lg btn-block" type="submit">Add Item</button>       
        </div>
     </form>   
        <div id="receipt">
            <c:forEach var="tempProd" items="${temporarProducts}" varStatus="status">
            <div class="row">
                <div class="col-md-3">
                    ${tempProd.prodName}
                </div>
                <div class="col-md-3">
                    ${tempProd.description}
                </div>
                <div class="col-md">
                    ${tempProd.price} lei
                </div>
                 <div class="col-md">
                    ${tempProd.quantity} buc
                </div>
            </div>
        </c:forEach>
            <p>
            <%   
                    out.print("Total: "+request.getAttribute("total"));
            %> 
            </p>

        </div>
        
        <div id="buttonFinish">
            <input type="button" onclick="location.href='${pageContext.request.contextPath}/FinishSale';" value="Finish Sale" />
       </div>
        
    </body>
</html>
