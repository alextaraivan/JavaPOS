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
       

     <form class="needs-validation float-right mr-5" method="POST" action="${pageContext.request.contextPath}/AddSale">
        <div class="d-flex flex-column">
            <label class=" ml-3 display-4 p-2">BarCode</label>
            <input class=" pr-2 w-40" type="number" name="barCode" required><br>
            <input type="number" min="1"  class="form-control" name="quantity" id="quantity"  value="1">
            <div class="invalid-feedback">
                 Please select a valid product.
            </div>
            <button class="btn btn-primary mt-4" type="submit">Add Item</button>       
            <p class="total">
                <%  
                    if(request.getAttribute("total")==null)
                    {
                        out.print("Total: 0 lei");
                    }
                    else
                    {
                        out.print("Total: "+request.getAttribute("total")+" lei");
                    }
                %> 
            </p>
            <div id="buttonFinish">
                <input  class="btn btn-success w-100 h-20" type="button" onclick="location.href='${pageContext.request.contextPath}/FinishSale';" value="Finish Sale" />
            </div>
        </div>
     </form>   
            <table class="table table-hover w-50 ml-5">
                 <thead>
                    <tr>
                      <th scope="col">Tip Produs</th>
                      <th scope="col">Detalii Produs</th>
                      <th scope="col">Pret</th>
                      <th scope="col">Cantitate</th>
                    </tr>
                </thead>
        <tbody>
            <c:forEach var="tempProd" items="${temporarProducts}" varStatus="status">
            
                 <tr>
                    <td scope="row">${tempProd.prodName}</td>
                    <td> ${tempProd.description}</td>
                    <td> ${tempProd.price} lei</td>
                    <td class="center">${tempProd.quantity} buc</td>
                </tr>
           
        </c:forEach>
       </tbody>
                </table>
    </body>
</html>
