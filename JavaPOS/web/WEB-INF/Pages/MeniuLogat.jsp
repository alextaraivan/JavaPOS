<%-- 
    Document   : MeniuLogat
    Created on : Jan 5, 2019, 1:53:35 AM
    Author     : Romelia Milascon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
    
        <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
            <h5 class="my-0 mr-md-auto font-weight-normal"><label class="icon p-2 text-dark">POS NextGen</label></h5>
           <nav class="my-2 my-md-0 mr-md-3">
               <label class="effect p-2 text-dark ">
                   <%   
                    out.print("Name: "+request.getSession().getAttribute("user"));
                   %> 
               </label>
             <label class="effect p-2 text-dark">
                <script> document.write(new Date().toLocaleDateString()); </script>
             </label> 
             <a class="effect p-2 text-dark" href="${pageContext.request.contextPath}/Logout">Logout</a>
           </nav>
         </div>