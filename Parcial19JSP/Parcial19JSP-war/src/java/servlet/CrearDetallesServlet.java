/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.OrderdetailsFacade;
import dao.OrdersFacade;
import entity.Orderdetails;
import entity.OrderdetailsPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(name = "CrearDetallesServlet", urlPatterns = {"/CrearDetallesServlet"})
public class CrearDetallesServlet extends HttpServlet {

    @EJB private OrderdetailsFacade detailsFacade;
    @EJB private OrdersFacade ordersFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String strId = request.getParameter("odId");
        String producto = request.getParameter("producto");
        String strCantidad = request.getParameter("cantidad");
        String strPrecio = request.getParameter("precio");
        String strOln = request.getParameter("oln");
        
        Integer id = Integer.parseInt(strId);
        Integer cantidad = Integer.parseInt(strCantidad);
        BigDecimal precio = new BigDecimal(Integer.parseInt(strPrecio));
        Integer oln = Integer.parseInt(strOln);
        
        Orderdetails od = new Orderdetails(new OrderdetailsPK(id, producto), cantidad, precio, oln);
        this.detailsFacade.create(od);
        
        RequestDispatcher rd = request.getRequestDispatcher("IndexServlet");
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
