/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp.servlet;

import customerapp.dao.CustomerFacade;
import customerapp.dao.DiscountCodeFacade;
import customerapp.dao.MicroMarketFacade;
import customerapp.entity.Customer;
import customerapp.entity.DiscountCode;
import customerapp.entity.MicroMarket;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guzman
 */
@WebServlet(name = "CustomerGuardarServlet", urlPatterns = {"/CustomerGuardarServlet"})
public class CustomerGuardarServlet extends HttpServlet {

    @EJB
    private DiscountCodeFacade discountCodeFacade;

    @EJB
    private MicroMarketFacade microMarketFacade;

    @EJB
    private CustomerFacade customerFacade;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String str;
        Customer cliente;
        boolean esNuevo = true;
        
        str = request.getParameter("id");        
        if (str == null || str.isEmpty()) {
            cliente = new Customer();
        } else {
            cliente = this.customerFacade.find(new Integer(str));
            esNuevo = false;
        }
        str = request.getParameter("nombre");
        cliente.setName(str);        
        str = request.getParameter("domicilio1");        
        cliente.setAddressline1(str);
        str = request.getParameter("domicilio2");        
        cliente.setAddressline2(str);        
        str = request.getParameter("ciudad");        
        cliente.setCity(str);
        str = request.getParameter("estado");        
        cliente.setState(str);        
        str = request.getParameter("telefono");        
        cliente.setPhone(str);
        str = request.getParameter("fax");        
        cliente.setFax(str);
        str = request.getParameter("email");        
        cliente.setEmail(str);
        
        str = request.getParameter("credito");        
        cliente.setCreditLimit(new Integer(str));        
        
        str = request.getParameter("mercado");
        MicroMarket supermercado = this.microMarketFacade.find(str);
        cliente.setZip(supermercado);
        
        str = request.getParameter("descuento");
        DiscountCode dc = this.discountCodeFacade.find(str);
        cliente.setDiscountCode(dc);        
                      
        if (esNuevo) {
            this.customerFacade.crearNuevo(cliente);
        } else {        
            this.customerFacade.edit(cliente);                        
        }        
        
        RequestDispatcher rd = request.getRequestDispatcher("/CustomerServlet");
        rd.forward(request, response);
        
        //response.sendRedirect("CustomerServlet");
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
        processRequest(request, response);
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
