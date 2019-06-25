/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CallespoblacionesFacade;
import dao.ClientesFacade;
import dao.PoblacionesFacade;
import dao.ProvinciasFacade;
import entity.Callespoblaciones;
import entity.Clientes;
import entity.Poblaciones;
import entity.Provincias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "EditarClienteServlet", urlPatterns = {"/EditarClienteServlet"})
public class EditarClienteServlet extends HttpServlet {

    @EJB private ClientesFacade clientesFacade;
    @EJB private CallespoblacionesFacade callesFacade;
    @EJB private ProvinciasFacade provinciasFacade;
    @EJB private PoblacionesFacade poblacionesFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String strId = request.getParameter("cId");
            Integer id = Integer.parseInt(strId);
            Clientes cliente = this.clientesFacade.find(id);
            request.setAttribute("cliente", cliente);
            
            List<Callespoblaciones> calles = this.callesFacade.findAll();
            request.setAttribute("calles", calles);
            
            List<Provincias> provincias = this.provinciasFacade.findAll();
            request.setAttribute("provincias", provincias);
            
            List<Poblaciones> poblaciones = this.poblacionesFacade.findAll();
            request.setAttribute("poblaciones", poblaciones);
            
            RequestDispatcher rd = request.getRequestDispatcher("editCliente.jsp");
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
