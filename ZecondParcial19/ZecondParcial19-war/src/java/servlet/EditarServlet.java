/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.EmployeesFacade;
import dao.OfficesFacade;
import entity.Employees;
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
@WebServlet(name = "EditarServlet", urlPatterns = {"/EditarServlet"})
public class EditarServlet extends HttpServlet {

    @EJB private EmployeesFacade employeesFacade;
    @EJB private OfficesFacade officesFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String strId = request.getParameter("numero");
        String strNombre = request.getParameter("nombre");
        String strApellido = request.getParameter("apellido");
        String strExtension = request.getParameter("extension");
        String strEmail = request.getParameter("email");
        String strJobTitle = request.getParameter("jobtitle");
        String strOficina = request.getParameter("oficina");
        String strJefe = request.getParameter("jefe");
        
        Integer id = Integer.parseInt(strId);
        Employees e = this.employeesFacade.find(id);
        
        e.setEmail(strEmail);
        e.setFirstname(strNombre);
        e.setLastname(strApellido);
        e.setExtension(strExtension);
        e.setJobtitle(strJobTitle);
        
        Integer idJ = Integer.parseInt(strJefe);
        Employees j = this.employeesFacade.find(idJ);
        e.setReportsto(j);
        
        e.setOfficecode(this.officesFacade.find(strOficina));
        
        
        this.employeesFacade.edit(e);
        
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
