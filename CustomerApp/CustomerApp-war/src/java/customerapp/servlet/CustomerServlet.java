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
import customerapp.service.CustomerBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guzman
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

    @EJB private CustomerBean customerBean;

    @EJB private DiscountCodeFacade discountCodeFacade;
    @EJB private MicroMarketFacade microMarketFacade;
    //@EJB private CustomerFacade customerFacade;

    
    
    
        
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

        HttpSession session;        
        String nombre, supermercado;        
        List<Customer> lista;
        List<MicroMarket> listaSupermercados;      
        List<DiscountCode> listaDescuentos;
        
        session = request.getSession();
        
        nombre = request.getParameter("patron");
        supermercado = request.getParameter("supermercado");
                
        lista = customerBean.findByZipAndName(supermercado, nombre);
        request.setAttribute("listaClientes", lista);
        
        listaSupermercados = this.microMarketFacade.findAll();
        session.setAttribute("listaSupermercados", listaSupermercados);
        
        listaDescuentos = this.discountCodeFacade.findAll();
        session.setAttribute("listaDescuentos", listaDescuentos);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listado.jsp");
        rd.forward(request, response);                        
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
