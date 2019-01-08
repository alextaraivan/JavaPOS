/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Ejb.ProductBean;
import Ejb.ProductSpecBean;
import Ejb.SaleBean;
import Ejb.StoreBean;
import Ejb.TempBean;
import Ejb.UserBean;
import PosClasses.ProductDetails;
import PosClasses.ProductSpecDetails;
import PosClasses.TempDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Romelia Milascon
 */
@WebServlet(name = "FinishSale", urlPatterns = {"/FinishSale"})
public class FinishSale extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     @Inject
    UserBean userBean;
     
     @Inject
    TempBean tempBean;
     
     @Inject
    StoreBean storeBean;
     
     @Inject
     SaleBean saleBean;
     
     @Inject
     ProductBean prodBean;
     
     @Inject
     ProductSpecBean specBean;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinishSale</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinishSale at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Double cash=tempBean.getTotal();
        if(cash!=0)
        {
        String uid=(String)request.getSession().getAttribute("user"); 
        Integer uId=userBean.findUserID(uid);
        LocalDate saleD=LocalDate.now();
        LocalTime saleT=LocalTime.now();
        
        saleBean.createSale(saleD,saleT,uId,1,cash);
        
        List<TempDetails> temporarProducts = tempBean.getAllTemporars();
        for (TempDetails temp : temporarProducts) {
            
                Integer quant=temp.getQuantity(); //cantitate prod cumparata
                
                String name=temp.getProdName(); // nume produs
                
                ProductDetails prod=prodBean.findByName(name);
                
                Integer prodId=prod.getId();
                
                ProductSpecDetails spec=specBean.findByProdId(prodId);
                
                Integer specId=spec.getId();
                
                Integer qInStock=spec.getUnitInStock()-quant;
                
                specBean.updateProductSpecification(specId, qInStock);
            }
        tempBean.deleteRecords();
        }
       request.getRequestDispatcher("/WEB-INF/Pages/POS.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
