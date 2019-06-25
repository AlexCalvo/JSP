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
@WebServlet(name = "SaveClienteServlet", urlPatterns = {"/SaveClienteServlet"})
public class SaveClienteServlet extends HttpServlet {

    @EJB private ClientesFacade clientesFacade;
    @EJB private CallespoblacionesFacade callesFacade;
    @EJB private ProvinciasFacade provinciasFacade;
    @EJB private PoblacionesFacade poblacionesFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("codigo");
        String nombre =request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String apellido2 =request.getParameter("apellido2");
        String numero=request.getParameter("numero");
        String piso=request.getParameter("piso");
        String metros=request.getParameter("metros");
        
        String calle =request.getParameter("calle");
        Integer idC = Integer.parseInt(calle);
        Callespoblaciones ca = this.callesFacade.find(idC);
        
        String provincia=request.getParameter("provincia");
        Integer idPr = Integer.parseInt(provincia);
        Provincias p = this.provinciasFacade.find(idPr);
        
        String poblacion=request.getParameter("poblacion");
        Poblaciones po = this.poblacionesFacade.find(poblacion);
                
        Integer id = Integer.parseInt(codigo);
        Clientes c = this.clientesFacade.find(id);
        
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setApellido2(apellido2);
        c.setNumero(new Integer(numero));
        c.setPiso(new Integer(piso));
        c.setMetros(new Integer(metros));
        c.setCalle(ca);
        c.setCodigoprovincia(p);
        c.setCodigopoblacion(po);
        
        this.clientesFacade.edit(c);
        
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
