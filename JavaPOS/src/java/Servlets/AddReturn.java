/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Ejb.ProductBean;
import Ejb.ProductSpecBean;
import Ejb.TempBean;
import PosClasses.ProductSpecDetails;
import PosClasses.TempDetails;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddReturn", urlPatterns = {"/AddReturn"})
public class AddReturn extends HttpServlet {

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
    private ProductBean productBean;
    
    @Inject
    private ProductSpecBean productSpecBean;
    
    @Inject
    TempBean temporarBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddReturn</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddReturn at " + request.getContextPath() + "</h1>");
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
        
        temporarBean.deleteRecords();
        request.getRequestDispatcher("/WEB-INF/Pages/Return.jsp").forward(request, response);
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
        
          String barcode = request.getParameter("barCode");
          
        ProductSpecDetails prodSpecDetails = productSpecBean.findByBarcode(barcode);
        
        if (prodSpecDetails == null){
        
            List<TempDetails> temporarProducts = temporarBean.getAllTemporars();
            request.setAttribute("temporarProducts", temporarProducts);
            
            Double total=temporarBean.getTotal();
             request.setAttribute("total", total);
            
            request.getRequestDispatcher("/WEB-INF/Pages/Return.jsp").forward(request, response);
        }
        else
        {
          Integer quantity = Integer.parseInt(request.getParameter("quantity"));    
        
        TempDetails t=temporarBean.findByName(prodSpecDetails.getProdName());
        if(quantity > prodSpecDetails.getUnitInStock())
        {
            List<TempDetails> temporarProducts = temporarBean.getAllTemporars();
            request.setAttribute("temporarProducts", temporarProducts);
            
            Double total=temporarBean.getTotal();
             request.setAttribute("total", total);
            
            request.getRequestDispatcher("/WEB-INF/Pages/Return.jsp").forward(request, response);
        }
        else{ 
        if(t!=null)
        {
            
            Integer id=t.getId();
            Integer q=quantity+t.getQuantity();
            temporarBean.updateTemp(id,q);
        }
        else
        {
            temporarBean.createTemp(prodSpecDetails.getProdName(), prodSpecDetails.getDescription(), prodSpecDetails.getPrice(),quantity);
        }
        
        List<TempDetails> temporarProducts = temporarBean.getAllTemporars();
        Double total=temporarBean.getTotal();
        request.setAttribute("temporarProducts", temporarProducts);
        request.setAttribute("total", total);
        request.getRequestDispatcher("/WEB-INF/Pages/Return.jsp").forward(request, response);
        }
        }
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
